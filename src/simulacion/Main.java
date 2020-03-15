package simulacion;

import javax.swing.JFrame;

public class Main extends JFrame {
	
	public static void main(String[] args) {
		Main frame = new Main();
		SwingSimulacion panel_simulacion = new SwingSimulacion();
		ThreadCarros hilo = new ThreadCarros(panel_simulacion);
		hilo.start();
		
		frame.add(panel_simulacion);
		frame.setSize(800, 800);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public Main() {
		initUI();
	}

	private void initUI() {

	}
}
