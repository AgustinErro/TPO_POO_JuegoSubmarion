package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import auxiliares.GestorPuntajes;
import controlador.Controlador;

public class VentanaMenu extends JFrame {

	private static final long serialVersionUID = 1L;

	private JLabel lblUltimaPuntuacion;
	private JLabel lblMejorPuntuacion;

	public VentanaMenu() {
		configurar();
		this.setVisible(true);
		int ancho = Controlador.getInstance().getAnchoArea();
		int alto = Controlador.getInstance().getAltoArea();
		this.setSize(ancho, alto);
		this.setTitle("Juego Submarino - Menú Principal");
		this.setLocationRelativeTo(null);
	}

	private void configurar() {
		JPanel panelFondo = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;

				g2d.setColor(Color.WHITE);
				g2d.fillRect(0, 0, getWidth(), 130);

				g2d.setColor(new Color(135, 206, 235));
				g2d.fillRect(0, 130, getWidth(), getHeight() - 130);

				g2d.setColor(new Color(100, 149, 237, 120));
				for (int y = 130; y < getHeight(); y += 100) {
					g2d.drawLine(0, y, getWidth(), y);
				}
			}
		};

		this.setContentPane(panelFondo);
		Container contenedor = this.getContentPane();
		contenedor.setLayout(null);

		// Título
		JLabel lblTitulo = new JLabel("JUEGO SUBMARINO");
		lblTitulo.setBounds(150, 20, 700, 90);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 52));
		lblTitulo.setForeground(new Color(0, 50, 150));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		contenedor.add(lblTitulo);

		// Representación visual del submarino
		JLabel lblSubmarino = new JLabel("[ SUBMARINO ]");
		lblSubmarino.setBounds(380, 170, 240, 55);
		lblSubmarino.setFont(new Font("Arial", Font.BOLD, 18));
		lblSubmarino.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubmarino.setForeground(Color.WHITE);
		lblSubmarino.setBackground(Color.BLUE);
		lblSubmarino.setOpaque(true);
		lblSubmarino.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		contenedor.add(lblSubmarino);

		// Última puntuación
		lblUltimaPuntuacion = new JLabel("Última puntuación:  " + GestorPuntajes.getUltimaPuntuacion() + " pts");
		lblUltimaPuntuacion.setBounds(250, 300, 500, 50);
		lblUltimaPuntuacion.setFont(new Font("Arial", Font.BOLD, 20));
		lblUltimaPuntuacion.setForeground(Color.BLACK);
		lblUltimaPuntuacion.setBackground(Color.WHITE);
		lblUltimaPuntuacion.setOpaque(true);
		lblUltimaPuntuacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblUltimaPuntuacion.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		contenedor.add(lblUltimaPuntuacion);

		// Mejor puntuación
		lblMejorPuntuacion = new JLabel("Mejor puntuación:  " + GestorPuntajes.getMejorPuntuacion() + " pts");
		lblMejorPuntuacion.setBounds(250, 370, 500, 50);
		lblMejorPuntuacion.setFont(new Font("Arial", Font.BOLD, 20));
		lblMejorPuntuacion.setForeground(new Color(160, 90, 0));
		lblMejorPuntuacion.setBackground(Color.WHITE);
		lblMejorPuntuacion.setOpaque(true);
		lblMejorPuntuacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblMejorPuntuacion.setBorder(BorderFactory.createLineBorder(new Color(160, 90, 0), 2));
		contenedor.add(lblMejorPuntuacion);

		// Botón iniciar juego
		JButton btnIniciar = new JButton("INICIAR JUEGO");
		btnIniciar.setBounds(350, 500, 300, 70);
		btnIniciar.setFont(new Font("Arial", Font.BOLD, 22));
		btnIniciar.setBackground(Color.GREEN);
		btnIniciar.setForeground(Color.BLACK);
		btnIniciar.setFocusPainted(false);
		btnIniciar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		btnIniciar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnIniciar.addActionListener(e -> iniciarJuego());
		contenedor.add(btnIniciar);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void iniciarJuego() {
		Controlador.getInstance().reiniciarJuego();
		this.dispose();
		new VentanaTest();
	}
}
