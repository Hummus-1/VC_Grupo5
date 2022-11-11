import { readFileSync } from 'node:fs';

export interface Literal {
  name: string;
  isNegated: boolean;
}

export type Clause = [Literal, Literal, Literal];

export interface ThreeSatJson {
  literalNames: string[];
  clauses: Clause[];
}

export class ThreeSat {
  constructor(public literalsNames: string[], public clauses: Clause[]) {}

  static fromFile(path: string): ThreeSat {
    const json = readFileSync(path, 'utf8');
    const input = JSON.parse(json) as ThreeSatJson;

    return new ThreeSat(input.literalNames, input.clauses);
  }
}
