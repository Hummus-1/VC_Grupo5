import type { Data as VisData } from 'vis-network';
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
  private bound = 0;

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

    graph.bound = threeSat.literalsNames.length + 2 * threeSat.clauses.length;

    return graph;
  }

  idToNode(id: number): Node {
    return this.nodes[id];
  }

  // toJSON(): string {
  //   return JSON.stringify(this);
  // }

  toVisNetwork(): VisData {
    const labelToId: Map<string, number> = new Map(
      this.nodes.map((node, index) => [node.label, index])
    );
    const visNodes = [...labelToId].map(([label, id]) => ({
      label,
      id,
    }));
    const visEdges = this.edges.map((edge) => ({
      from: labelToId.get(edge.from) ?? -1,
      to: labelToId.get(edge.to) ?? -1,
    }));

    return { nodes: visNodes, edges: visEdges };
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
