import { readFileSync } from "node:fs";
let json = readFileSync('./data/prueba.json', 'utf8');
let threeSAT = JSON.parse(json);
console.log(JSON.stringify(threeSAT, null, 2));
