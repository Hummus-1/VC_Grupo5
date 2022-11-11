import type { Literal } from './three_sat';
import { ThreeSat } from './three_sat';

export interface Node {
  // id: number;
  label: string;
}

export interface Edge {
  from: string;
  to: string;
}

const literalToString = (literal: Literal): string =>
  (literal.isNegated ? '~' : '') + literal.name;

export class VCGraph {
  constructor(private nodes: Node[] = [], private edges: Edge[] = []) {}

  static fromThreeSat(threeSat: ThreeSat): VCGraph {
    const graph = new VCGraph();

    threeSat.literalsNames.forEach((name) => {
      const literal: Literal = { name, isNegated: false };
      const negatedliteral: Literal = { name, isNegated: true };

      graph.addLiteralNode(literal);
      graph.addLiteralNode(negatedliteral);
      graph.addLiteralEdge(literal, negatedliteral);
    });

    threeSat.clauses.forEach((clause, index) => {
      const auxList = clause.map((literal) => {
        const label = literalToString(literal);
        const aux = `aux ${index} ${label}`;
        graph.addNode(aux);
        graph.addEdge(label, aux);
        return aux;
      });

      const [firstAux, secondAux, thirdAux] = auxList;
      graph.addEdge(firstAux, secondAux);
      graph.addEdge(secondAux, thirdAux);
      graph.addEdge(thirdAux, firstAux);
    });

    return graph;
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

  addNode(label: string) {
    this.nodes.push({ label });
  }

  private addLiteralNode(literal: Literal) {
    const label = literalToString(literal);
    this.addNode(label);
  }

  addEdge(fromLabel: string, toLabel: string) {
    this.edges.push({ from: fromLabel, to: toLabel });
  }

  private addLiteralEdge(fromLiteral: Literal, toLiteral: Literal) {
    const fromLabel = literalToString(fromLiteral);
    const toLabel = literalToString(toLiteral);
    this.addEdge(fromLabel, toLabel);
  }
}
