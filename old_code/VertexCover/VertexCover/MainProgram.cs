using System;

namespace VertexCoverSpace {
    /// <summary>
    /// Class for create the program
    /// </summary>
    class MainProgram {
        /// <summary>
        /// Main method of the program
        /// </summary>
        /// <param name="args"> Console arguments </param>
        static void Main(string[] args) {
            if (args.Length != 1) {
                Console.WriteLine("Usage: VC.exe file.sat3");
                return;
            }

            ThreeSAT threeSAT = new ThreeSAT();
            FileLoader loader = new FileLoader(threeSAT, args[0]);
            loader.LoadFile();
            VertexCover vc = new VertexCover(threeSAT);
            vc.BuildVertexCover();

            vc.Show();
        }
    }
}
