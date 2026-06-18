package gui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import auxiliares.GestorPuntajes;
import controlador.Controlador;
import views.MovimientoView;

public class VentanaTest extends JFrame {

	private static final long serialVersionUID = -5360041225007601188L;

	private static final int DURACION_EXPLOSION = 20;

	private Controlador controlador;
	private JLabel submarino;
	private ArrayList<JLabel> labelsBarcos;
	private ArrayList<JLabel> labelsCargas;
	private ArrayList<int[]> explosionesActivas = new ArrayList<>();
	private Container contenedor;

	// Nuevos JLabels para mostrar los datos de la partida en tiempo real
	private JLabel lblNivel;
	private JLabel lblSalud;
	private JLabel lblVidas;
	private JLabel lblPuntos;
	//test viajes
	private JTextArea txtInfoViajes;

	public VentanaTest(Controlador controlador) {
		this.controlador = controlador;
		labelsBarcos = new ArrayList<>();
		labelsCargas = new ArrayList<>();

		configurar();
		this.setVisible(true);
		int ancho = controlador.getAnchoArea();
		int alto = controlador.getAltoArea();
		this.setSize(ancho, alto);
		this.setTitle("Objetos Moviles - Juego Submarino");
		this.setLocationRelativeTo(null);
		eventos();
	}
	
	private void configurar() {
		// JPanel fondo
		JPanel panelFondo = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;
				
				// Dibujar el cielo (Blanco) desde Y = 0 hasta Y = 130 
				g2d.setColor(Color.WHITE);
				g2d.fillRect(0, 0, getWidth(), 130);
				
				// Dibujar el agua (Celeste) desde Y = 130 hacia abajo
				g2d.setColor(new Color(135, 206, 235));
				g2d.fillRect(0, 130, getWidth(), getHeight() - 130);
				
				// Dibujar línea sutil cada 100 píxeles a partir del inicio del agua (Y = 130)
				g2d.setColor(new Color(100, 149, 237, 120)); 
				
				// Arrancamos en 130 (la superficie) y bajamos de a 100 píxeles
				for (int y = 130; y < getHeight(); y += 100) {
					g2d.drawLine(0, y, getWidth(), y);
				}

				// Dibujar explosiones animadas
				for (int[] exp : explosionesActivas) {
					float progress = (float)(DURACION_EXPLOSION - exp[2]) / DURACION_EXPLOSION;
					float alpha = 1.0f - progress;

					// Anillo exterior naranja
					int r1 = (int)(8 + progress * 32);
					g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, Math.max(0f, alpha * 0.6f)));
					g2d.setColor(new Color(255, 120, 0));
					g2d.fillOval(exp[0] - r1, exp[1] - r1, r1 * 2, r1 * 2);

					// Anillo interior amarillo
					int r2 = (int)(4 + progress * 18);
					g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, Math.max(0f, alpha * 0.85f)));
					g2d.setColor(new Color(255, 220, 0));
					g2d.fillOval(exp[0] - r2, exp[1] - r2, r2 * 2, r2 * 2);

					// Núcleo blanco
					int r3 = (int)(2 + progress * 7);
					g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, Math.max(0f, alpha)));
					g2d.setColor(Color.WHITE);
					g2d.fillOval(exp[0] - r3, exp[1] - r3, r3 * 2, r3 * 2);

					// Restaurar composite
					g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
				}
			}
		};
		
		this.setContentPane(panelFondo);
		
		contenedor = this.getContentPane();
		contenedor.setLayout(null);
		
		Font fuenteHUD = new Font("Arial", Font.BOLD, 16);
		//Nivel
		lblNivel = new JLabel("Nivel: " + controlador.getNivel());
		lblNivel.setBounds(20, 20, 120, 30);
		lblNivel.setFont(fuenteHUD);
		lblNivel.setForeground(Color.BLACK); 
		contenedor.add(lblNivel);
		//Salud
		lblSalud = new JLabel("Salud: " + controlador.getsaludRestante() + "%");
		lblSalud.setBounds(160, 20, 150, 30);
		lblSalud.setFont(fuenteHUD);
		lblSalud.setForeground(Color.BLACK);
		contenedor.add(lblSalud);
		//Vidas restantes
		lblVidas = new JLabel("Vidas: " + controlador.getvidasRestantes());
		lblVidas.setBounds(330, 20, 120, 30);
		lblVidas.setFont(fuenteHUD);
		lblVidas.setForeground(Color.BLACK);
		contenedor.add(lblVidas);
		// Puntos
		lblPuntos = new JLabel("Puntos: " + controlador.getPuntos());
		lblPuntos.setBounds(480, 20, 200, 30);
		lblPuntos.setFont(fuenteHUD);
		lblPuntos.setForeground(Color.BLACK);
		contenedor.add(lblPuntos);
		
		//Viajes por barcos
		txtInfoViajes = new JTextArea();
		txtInfoViajes.setBounds(700, 20, 200, 50); 
		txtInfoViajes.setFont(new Font("Arial", Font.BOLD, 14));
		txtInfoViajes.setForeground(Color.BLACK);
		txtInfoViajes.setEditable(true);
		txtInfoViajes.setFocusable(false);
		contenedor.add(txtInfoViajes);
		
		//Submarino
		MovimientoView auxSubmarino = controlador.getSubmarino();
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
		
		//KeyListener para el movimiento del submarino
		this.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) { }
			
			@Override
			public void keyReleased(KeyEvent e) { }
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 37)
					controlador.moverIzquierdaSubmarino();
				else if(e.getKeyCode() == 38)
					controlador.moverArribaSubmarino();
				else if(e.getKeyCode() == 39)
					controlador.moverDerechaSubmarino();
				else if(e.getKeyCode() == 40)
					controlador.moverAbajoSubmarino();
			}
		});
		
		// Game Loop configurado a 30 milisegundos
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
		// Actualizar los textos info
		lblNivel.setText("Nivel: " + controlador.getNivel());
		lblSalud.setText("Salud: " + controlador.getsaludRestante() + "%");
		lblVidas.setText("Vidas: " + controlador.getvidasRestantes());
		lblPuntos.setText("Puntos: " + controlador.getPuntos());

		// Actualizar posición del Submarino
		MovimientoView auxSubmarino = controlador.getSubmarino();
		submarino.setBounds(auxSubmarino.getPosicionX(), auxSubmarino.getPosicionY(), auxSubmarino.getAncho(), auxSubmarino.getAlto());
		
		//Actualizar posiciones de los Barcos
		ArrayList<MovimientoView> vistasBarcos = controlador.getBarcos();
		gestionarLabelsDinámicos(labelsBarcos, vistasBarcos.size(), Color.GREEN, "Barco");
		
		//StringBuilder para los textos info de viajes
		StringBuilder listadoViajes = new StringBuilder();
		
		for (int i = 0; i < vistasBarcos.size(); i++) {
			MovimientoView v = vistasBarcos.get(i);
			labelsBarcos.get(i).setBounds(v.getPosicionX(), v.getPosicionY(), v.getAncho(), v.getAlto());
			labelsBarcos.get(i).setText("Barco " + (i + 1));
			labelsBarcos.get(i).setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK, 2));
			
			//append de todos los viajes barcos en un solo string
			int viajesRestantes = v.getViajes() + 1;
			listadoViajes.append("Barco ").append(i + 1).append(" = viaje ").append(viajesRestantes).append("\n");

		}
		
		//Actualizar los textos info de viajes
		txtInfoViajes.setText(listadoViajes.toString());
		
		// Actualizar posiciones de las Cargas
		ArrayList<MovimientoView> vistasCargas = controlador.getCargas();
		gestionarLabelsDinámicos(labelsCargas, vistasCargas.size(), Color.RED, "Carga");
		for (int i = 0; i < vistasCargas.size(); i++) {
			MovimientoView v = vistasCargas.get(i);
			labelsCargas.get(i).setBounds(v.getPosicionX(), v.getPosicionY(), v.getAncho(), v.getAlto());
		}

		// Registrar nuevas explosiones y avanzar las existentes
		for (int[] pos : controlador.getExplosiones()) {
			explosionesActivas.add(new int[]{pos[0], pos[1], DURACION_EXPLOSION});
		}
		for (int i = explosionesActivas.size() - 1; i >= 0; i--) {
			explosionesActivas.get(i)[2]--;
			if (explosionesActivas.get(i)[2] <= 0)
				explosionesActivas.remove(i);
		}

		// Redibujar el contenedor para procesar cambios
		contenedor.repaint();
	}
	
	//inner class para AccionListener de GameLoop
	class MuevoEntidadesAutomaticas implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//Controlador ejecuta los movimientos automáticos
			controlador.procesosAutomaticos();
			
			// Actualiza los gráficos en la pantalla
			actualizarPantalla();
			
			// Ver si se termina el juego
			if (controlador.getTerminoJuego()) {
				
				Timer timer = (Timer) e.getSource();
				timer.stop(); //Parar el game loop
				
				int puntosFinales = controlador.getPuntos();
				String mensaje = "¡FIN DEL JUEGO!\n\nEl submarino ha sido destruido.\nPuntuación Final: " + puntosFinales + " puntos.";
				
				// Textos botones
				Object[] opciones = {"Volver a jugar", "Menú Principal"};

				// Cartel de GAME OVER
				int seleccion = JOptionPane.showOptionDialog(
					null,
					mensaje,
					"GAME OVER",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE,
					null,
					opciones,
					opciones[0]
				);

				// if de opciones de cartel
				if (seleccion == JOptionPane.YES_OPTION) {
					explosionesActivas.clear();
					controlador.reiniciarJuego();
					timer.start();
				} else {
					GestorPuntajes.guardarPuntuacion(puntosFinales);
					dispose();
					new VentanaMenu(controlador);
				}
			}
		}
	}
}