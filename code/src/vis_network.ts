import {} from './vc_graph';
import * as vis from 'vis';
// create an array with nodes

class VisGraph {
  constructor(private nodes: vis.Dataset, private edges: vis.Dataset) {
    this.nodes = new vis.DataSet();
    this.edges = new vis.DataSet();
  }
}

// ESTO EN EL SCRIPT DE LA PAGINA
// var container = document.getElementById("mynetwork");
// var data = {
//   nodes: nodes,
//   edges: edges,
// };
// var options = {};
// var network = new vis.Network(container, data, options);