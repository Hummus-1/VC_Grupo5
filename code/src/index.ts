import { readFileSync } from 'node:fs';


// export type Clause = Literal[];

// export interface ThreeSatData {
//   literalNames: string[];
//   clauses: Clause[];
// }

// export interface Node {}

// export interface Edge {}

// export interface VCData {
//   nodes: Node[];
//   edges: Edge[];
// }

const json = readFileSync('./data/prueba.json', 'utf8');
const threeSAT = JSON.parse(json) as ThreeSatData;

console.log(JSON.stringify(threeSAT, null, 2));

// let graph: VCData = {
//   nodes: [],
//   edges: []
// };

// for (const literal of threeSAT.literalNames) {
//   graph.nodes.push([{literal, isNegated: true}, {literal, isNegated: false}]);
//   graph.edges.push({from: literal.name() /* suponiendo clase literal*/, to: /*literal negado*/});
// }

// // Sé que queda feo con índices, pero es para dar nombre a las a's.
// for (let i = 0; i < threeSAT.clauses.length; ++i) {
//   for (let j = 0; j < threeSAT.clauses[i].length; ++j) {
//     // Un nodo ficticio del triángulo.
//     // No me peguen por el nombre de variable, es el del libro de clase.
//     let a = `a${j}${i}`;
//     graph.nodes.push(a);
//     // Conectar cada elemento del triángulo a su nodo de literal.
//     graph.edges.push({from: a, to: threeSAT.clauses[i].name()})
//   }

//   // Crear triángulo, de nuevo molaría tener un método para dar nombre automáticamente.
//   graph.edges.push([
//     {from: `a1${i}`, to: `a2${i}`},
//     {from: `a1${i}`, to: `a3${i}`},
//     {from: `a2${i}`, to: `a3${i}`},
//   ]);
// }
