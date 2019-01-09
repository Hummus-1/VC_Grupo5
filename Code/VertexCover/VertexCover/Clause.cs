using System.Collections.Generic;

namespace VertexCoverSpace {

    /// <summary>
    /// Clauses representation for 3-SAT problem
    /// </summary>
    public class Clause {
        /// <summary>
        /// The literals in a clause
        /// </summary>
        public List<string> literals { get; private set; }

        /// <summary>
        /// Instantiate a new Clause without literals
        /// </summary>
        public Clause() {
            literals = new List<string>();
        }

        /// <summary>
        /// Instantiate a new Clause with literals
        /// </summary>
        public Clause(List<string> literals) {
            literals = this.literals;
        }

        /// <summary>
        /// Add a literal in the last position of the Clause
        /// </summary>
        /// <param name="literal"> The literal that will be added </param>
        public void AddLiteral(string literal) {
            literals.Add(literal);
        }

        /// <summary>
        /// Add a literal in the index specified
        /// </summary>
        /// <param name="index"> The index where the literal will be placed </param>
        /// <param name="literal"> The literal that will be added </param>
        public void AddLiteralAt(int index, string literal) {
            literals.Insert(index, literal);
        }

        /// <summary>
        /// String representing this object
        /// </summary>
        /// <returns> The string containing the data </returns>
        public override string ToString() {
            string output = "{";

            foreach (string literal in literals) {
                output += literal + ", ";

            }
            //output = output.substring(0, output.length() - 2);
            output += "}";

            return output;
        }
    }
}
