import { Literal, ThreeSat } from './three_sat';

export interface Node {
  id: number;
  label: string;
}

export interface Edge {
  from: number;
  to: number;
}

const literalToString = (literal: Literal): string =>
  (literal.isNegated ? '~' : '') + literal.name;

export class VCGraph {
  constructor(private nodes: Node[], private edges: Edge[]) {}

  static fromThreeSat(threeSat: ThreeSat): VCGraph {
    const nodes: Map<number, Node> = new Map();
    threeSat.literalsNames.forEach((name, index) => {
      const literal: Literal = { name, isNegated: false };
      const node = { label: literalToString(literal), id: index * 2 };
      nodes.set(node.id, node);
      const negatedliteral: Literal = { ...literal, isNegated: true };
      nodes.push({ label: literalToString(negatedliteral), id: index * 2 + 1 });
    });

    const edges: Edge[] = [];

    return new VCGraph([...nodes], edges);
  }

  idToNode(id: number): Node {
    return this.nodes[id];
  }

  toVisNetwork(): { nodes: Node[]; edges: Edge[] } {
    return { nodes: this.nodes, edges: this.edges };
    //   nodes: this.nodes.map((node): Node => ({ id: node.id, label: 'a' })), // cambiar label a una string,
    //   edges: this.edges,
    // };
  }
}
