/*
 * Nombre: Isaac Aiman Salas
 * Asignatura: Complejidad Computacional
 */
package ull.esit.cuarto.cc.modulo2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;
import org.apache.commons.collections15.Transformer;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;

/**
 * Implementación del Vertex Cover.
 * @author Isaac Aiman Salas
 */
public class VertexCover {

	private SAT3 sat3;
	private Graph<String, String> graph;
	
	/**
	 * Constructor por defecto.
	 */
	public VertexCover() {
		
		setGraph(new SparseMultigraph<String, String>());
		setSat3(new SAT3());
	}

	public void start() {
		
		// Creamos las componentes de asignación;
		
		for (String literal : getSat3().getLiterales()) {
			
			getGraph().addVertex(literal);
			getGraph().addVertex("!" + literal);
			getGraph().addEdge(literal,literal, "!" + literal);
				
		}
		
		// Creamos las componentes de prueba de satisfacción.
		
		for (int i = 0; i < getSat3().getClausulas().size(); i++) {
			
			for (int j = 1; j < 4; j++) {
				getGraph().addVertex("a" + j + "[" + (i + 1) + "]");

			}
			
			getGraph().addEdge("a1[" + (i + 1) + "]", "a1[" + (i + 1) + "]", "a2[" + (i + 1) + "]");
			getGraph().addEdge("a3[" + (i + 1) + "]", "a1[" + (i + 1) + "]", "a3[" + (i + 1) + "]");
			getGraph().addEdge("a2[" + (i + 1) + "]", "a2[" + (i + 1) + "]", "a3[" + (i + 1) + "]");
		}
		
		// Creación de las aristas de comunicación.
		
	for (int i = 0; i < getSat3().getClausulas().size(); i++) {
			
		for (int j = 0; j < 3; j++) {
			getGraph().addEdge("comunicacion" + i + j, "a" + (j + 1) + "[" + (i + 1) + "]",
					getSat3().getClausulas().get(i).getLiterales().get(j));
		}
			
	}
	
	}
	
	
	public void graphFrame(JPanel panel) {
		
		panel.removeAll();
		
		CircleLayout<String, String> layout = new CircleLayout<String, String>(getGraph());
		layout.setSize(new Dimension(600,600));
		
		Transformer<String, Paint> vertexPaint = new Transformer<String, Paint>() {
			@Override
			public Paint transform(String arg0) {
				
				return Color.YELLOW;
			}
		};
		
		Transformer<String,Shape> vertexSize = new Transformer<String,Shape>(){
           public Shape transform(String i){
               Ellipse2D circle = new Ellipse2D.Double(-17, -17, 34, 34);
               return circle;
           }
		};
			
		
		BasicVisualizationServer<String, String> vv =
		new BasicVisualizationServer<String,String>(layout);
		vv.setPreferredSize(new Dimension(600,600)); //Sets the viewing area size 
		vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<String>());
		vv.getRenderContext().setVertexFillPaintTransformer(vertexPaint);
		vv.getRenderContext().setVertexShapeTransformer(vertexSize);
		vv.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);
		 
		
		panel.add(vv);
		panel.setVisible(true);
		 
	}
	
	/**
	 * Carga una instancia del problema del 3-SAT.
	 * @param nombreFichero
	 */
	public void cargarFichero(String nombreFichero) {
		
		getSat3().cargarFichero(nombreFichero);
		
	}

	/**
	 * @return the sat3
	 */
	public SAT3 getSat3() {
		return sat3;
	}


	/**
	 * @param sat3 the sat3 to set
	 */
	public void setSat3(SAT3 sat3) {
		this.sat3 = sat3;
	}

	/**
	 * @return the graph
	 */
	public Graph<String, String> getGraph() {
		return graph;
	}

	/**
	 * @param graph the graph to set
	 */
	public void setGraph(Graph<String, String> graph) {
		this.graph = graph;
	}
	
}
