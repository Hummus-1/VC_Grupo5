#!/usr/bin/env ts-node-script

import { program } from 'commander';
import { writeFileSync } from 'node:fs';
import { ThreeSat } from '../three_sat.js';
import { VCGraph } from '../vc_graph.js';

const threeSatToVC = (file: string, destination = 'vcgraph.json') => {
  const threeSAT = ThreeSat.fromFile(file);
  const vc = VCGraph.fromThreeSat(threeSAT);
  writeFileSync(destination, JSON.stringify(vc, null, 2));
};

program
  .name('3sat-to-vc')
  .argument('<file>', 'The path of the file with the 3Sat')
  .option(
    '-o, --out <destination>',
    "Path for output file. If it isn't specified the path of the origin file will be used, changing the extension to .json"
  )
  .description('Convert 3Sat file to VC')
  .action((file: string, options: { destination?: string }) => {
    threeSatToVC(file, options.destination);
  });

program.parse();
