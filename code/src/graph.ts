import { ThreeSat } from "./three_sat";

export interface Node {
  // ...
};

export interface Edge {
  // ...
};

export class Graph {
  constructor(private nodes: Node[], private edges: Edge[]) {}
  
  static fromThreeSat(threeSat: ThreeSat): Graph {
      const nodes: Node[] = [];
    const edges : Edge[] = [];
    // ...
    const graph = new Graph(nodes, edges);
    return graph;
  }
  
  toVisNetwork() {
    // ...
  }
}