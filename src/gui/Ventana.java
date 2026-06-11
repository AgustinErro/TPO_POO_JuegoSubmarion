package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import controlador.Controlador;
import views.MovimientoView;

public class Ventana extends JFrame {

	private static final long serialVersionUID = -5360041225007601188L;

	private JLabel submarino;
	private ArrayList<JLabel> labelsBarcos;
	private ArrayList<JLabel> labelsCargas;
	private Container contenedor;

	// Nuevos JLabels para mostrar los datos de la partida en tiempo real
	private JLabel lblNivel;
	private JLabel lblSalud;
	private JLabel lblVidas;

	public Ventana() {
		labelsBarcos = new ArrayList<>();
		labelsCargas = new ArrayList<>();
		
		configurar();
		this.setVisible(true);
		int ancho = Controlador.getInstance().getAnchoArea();
		int alto = Controlador.getInstance().getAltoArea();
		this.setSize(ancho, alto);
		this.setTitle("Objetos Moviles - Juego Submarino");
		this.setLocationRelativeTo(null); // Centra la ventana en pantalla
		eventos();
	}
	
	private void configurar() {
		contenedor = this.getContentPane();
		contenedor.setLayout(null);
		contenedor.setBackground(new Color(135, 206, 235)); // Color celeste que simula el agua
		
		// Definimos una fuente llamativa para los datos numéricos
		Font fuenteHUD = new Font("Arial", Font.BOLD, 16);

		// Inicialización obteniendo los datos directamente del Controlador
		lblNivel = new JLabel("Nivel: " + Controlador.getInstance().getNivel());
		lblNivel.setBounds(20, 20, 120, 30);
		lblNivel.setFont(fuenteHUD);
		lblNivel.setForeground(Color.BLACK);
		contenedor.add(lblNivel);

		lblSalud = new JLabel("Salud: " + Controlador.getInstance().getsaludRestante() + "%");
		lblSalud.setBounds(160, 20, 150, 30);
		lblSalud.setFont(fuenteHUD);
		lblSalud.setForeground(Color.BLACK);
		contenedor.add(lblSalud);

		lblVidas = new JLabel("Vidas: " + Controlador.getInstance().getvidasRestantes());
		lblVidas.setBounds(330, 20, 120, 30);
		lblVidas.setFont(fuenteHUD);
		lblVidas.setForeground(Color.BLACK);
		contenedor.add(lblVidas);
		
		// Inicializamos gráficamente el submarino
		MovimientoView auxSubmarino = Controlador.getInstance().getSubmarino();
		submarino = new JLabel("Submarino");
		submarino.setHorizontalAlignment(SwingConstants.CENTER);
		submarino.setForeground(Color.WHITE);
		submarino.setBounds(auxSubmarino.getPosicionX(), auxSubmarino.getPosicionY(), auxSubmarino.getAncho(), auxSubmarino.getAlto());
		submarino.setOpaque(true);
		submarino.setBackground(Color.BLUE);
		contenedor.add(submarino);
	}
	
	private void eventos() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) { }
			
			@Override
			public void keyReleased(KeyEvent e) { }
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 37)
					Controlador.getInstance().moverIzquierdaSubmarino();
				else if(e.getKeyCode() == 38)
					Controlador.getInstance().moverArribaSubmarino();
				else if(e.getKeyCode() == 39)
					Controlador.getInstance().moverDerechaSubmarino();
				else if(e.getKeyCode() == 40)
					Controlador.getInstance().moverAbajoSubmarino();
			}
		});
		
		// Bucle principal del juego (Game Loop) configurado a 30 milisegundos
		Timer gameLoop = new Timer(30, new MuevoEntidadesAutomaticas());
		gameLoop.start();
	}
	
	private void gestionarLabelsDinámicos(ArrayList<JLabel> listaLabels, int cantidadNecesaria, Color color, String texto) {
		while (listaLabels.size() < cantidadNecesaria) {
			JLabel nuevoLabel = new JLabel(texto);
			nuevoLabel.setHorizontalAlignment(SwingConstants.CENTER);
			nuevoLabel.setOpaque(true);
			nuevoLabel.setBackground(color);
			nuevoLabel.setForeground(Color.BLACK);
			contenedor.add(nuevoLabel);
			listaLabels.add(nuevoLabel);
		}
		
		while (listaLabels.size() > cantidadNecesaria) {
			JLabel labelSobrante = listaLabels.remove(listaLabels.size() - 1);
			contenedor.remove(labelSobrante);
		}
	}
	
	private void actualizarPantalla() {
		// Actualizar los textos de los indicadores consultando al Controlador
		lblNivel.setText("Nivel: " + Controlador.getInstance().getNivel());
		lblSalud.setText("Salud: " + Controlador.getInstance().getsaludRestante() + "%");
		lblVidas.setText("Vidas: " + Controlador.getInstance().getvidasRestantes());

		// 1. Actualizar posición del Submarino
		MovimientoView auxSubmarino = Controlador.getInstance().getSubmarino();
		submarino.setBounds(auxSubmarino.getPosicionX(), auxSubmarino.getPosicionY(), auxSubmarino.getAncho(), auxSubmarino.getAlto());
		
		// 2. Actualizar posiciones de los Barcos
		ArrayList<MovimientoView> vistasBarcos = Controlador.getInstance().getBarcos();
		gestionarLabelsDinámicos(labelsBarcos, vistasBarcos.size(), Color.GREEN, "Barco");
		for (int i = 0; i < vistasBarcos.size(); i++) {
			MovimientoView v = vistasBarcos.get(i);
			labelsBarcos.get(i).setBounds(v.getPosicionX(), v.getPosicionY(), v.getAncho(), v.getAlto());
			labelsBarcos.get(i).setText("Barco " + (i + 1));
		}
		
		// 3. Actualizar posiciones de las Cargas
		ArrayList<MovimientoView> vistasCargas = Controlador.getInstance().getCargas();
		gestionarLabelsDinámicos(labelsCargas, vistasCargas.size(), Color.RED, "Carga");
		for (int i = 0; i < vistasCargas.size(); i++) {
			MovimientoView v = vistasCargas.get(i);
			labelsCargas.get(i).setBounds(v.getPosicionX(), v.getPosicionY(), v.getAncho(), v.getAlto());
		}

		// Redibujar el contenedor para procesar altas y bajas de componentes de interfaz
		contenedor.repaint();
	}
	
	class MuevoEntidadesAutomaticas implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Controlador.getInstance().procesosAutomaticos();
			actualizarPantalla();
		}
	}
}