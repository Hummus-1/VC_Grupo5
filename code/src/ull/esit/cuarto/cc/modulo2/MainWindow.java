package ull.esit.cuarto.cc.modulo2;

import java.awt.EventQueue;
import com.alee.laf.WebLookAndFeel;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;



public class MainWindow {

	private JFrame frame;
	private VertexCover vertexCover;
	private String nombreFichero;
	private JLabel sat3String;
	private JPanel panelGraph;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(WebLookAndFeel.class.getCanonicalName());
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Vertex Cover");
		frame.setBounds(100, 100, 1000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnOpciones = new JMenu("Archivo");
		menuBar.add(mnOpciones);
		
		JMenuItem mntmAbrirArchivo = new JMenuItem("Abrir archivo...");
		mntmAbrirArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				JFileChooser dialogo = new JFileChooser();
				dialogo.setFileFilter(new FileNameExtensionFilter("sat3", "sat3"));
				File workingDirectory = new File(System.getProperty("user.dir"));
				dialogo.setCurrentDirectory(workingDirectory);
				
				int returnVal = dialogo.showOpenDialog(frame);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					setNombreFichero(dialogo.getSelectedFile().getAbsolutePath());
					start();
				}
				
				
			}
		});
		mnOpciones.add(mntmAbrirArchivo);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame acercaDeFrame = new JFrame("Acerca de");
				
				acercaDeFrame.getRootPane().setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
				acercaDeFrame.add(new JLabel("<html><b>Vertex Cover.</b><br><br>"
						+ "<b>Autor:</b> Isaac M. Aimán Salas<br><br>"
						+ "<b>Asignatura:</b> Complejidad Computacional.<br><br>"
						+ "<b>Curso:</b> 2017/2018</html>"), BorderLayout.NORTH);
				acercaDeFrame.setVisible(true);
				acercaDeFrame.setTitle("Información");
				acercaDeFrame.setSize(300, 300);
				acercaDeFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				acercaDeFrame.setName("info");
				
			}
		});
		mnAyuda.add(mntmAcercaDe);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		setSat3String(new JLabel(""));
		panel.add(getSat3String());
		
		setPanelGraph(new JPanel());
		frame.getContentPane().add(getPanelGraph(), BorderLayout.CENTER);
	}
	
	
	public void start() {
		
		setVertexCover(new VertexCover());
		getVertexCover().cargarFichero(getNombreFichero());
		getSat3String().setText(getVertexCover().getSat3().toString());
		getVertexCover().start();
		getVertexCover().graphFrame(getPanelGraph());
		
	}

	/**
	 * @return the vertexCover
	 */
	public VertexCover getVertexCover() {
		return vertexCover;
	}

	/**
	 * @param vertexCover the vertexCover to set
	 */
	public void setVertexCover(VertexCover vertexCover) {
		this.vertexCover = vertexCover;
	}

	/**
	 * @return the nombreFichero
	 */
	public String getNombreFichero() {
		return nombreFichero;
	}

	/**
	 * @param nombreFichero the nombreFichero to set
	 */
	public void setNombreFichero(String nombreFichero) {
		this.nombreFichero = nombreFichero;
	}

	/**
	 * @return the sat3String
	 */
	public JLabel getSat3String() {
		return sat3String;
	}

	/**
	 * @param sat3String the sat3String to set
	 */
	public void setSat3String(JLabel sat3String) {
		this.sat3String = sat3String;
	}

	/**
	 * @return the panelGraph
	 */
	public JPanel getPanelGraph() {
		return panelGraph;
	}

	/**
	 * @param panelGraph the panelGraph to set
	 */
	public void setPanelGraph(JPanel panelGraph) {
		this.panelGraph = panelGraph;
	}

}
