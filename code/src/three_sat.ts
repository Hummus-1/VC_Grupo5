import { readFileSync } from "node:fs";
import { Graph } from "./graph";

export interface Literal {
  name: string;
  isNegated: boolean;
};

export type Clause = Literal[];

export interface ThreeSatData {
  literalNames: string[];
  clauses: Clause[];
}

export class ThreeSat {
  constructor(private literalsNames: string[], private clauses: Clause[]) {}

  static fromFile(path: string): ThreeSat {
    const json = readFileSync(path, 'utf8');
    const threeSAT = JSON.parse(json) as ThreeSatData;

    return new ThreeSat(threeSAT.literalNames, threeSAT.clauses);
  }

  toVC() {
    const graph = Graph.fromThreeSat(this);
  }
}


