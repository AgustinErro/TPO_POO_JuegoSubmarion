package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import controlador.Controlador;
import views.MovimientoView;

public class Ventana extends JFrame {

	private static final long serialVersionUID = -5360041225007601188L;

	private JLabel submarino;
	private JLabel barco01, barco02, barco03;

	
	public Ventana() {
		configurar();
		this.setVisible(true);
		int ancho = Controlador.getInstance().getAnchoArea();
		int alto = Controlador.getInstance().getAltoArea();
		this.setSize(ancho, alto);
		this.setTitle("Objetos Moviles");
		eventos();
	}
	
	private void configurar() {
		Container c = this.getContentPane();
		c.setLayout(null);
		MovimientoView auxSubmarino = Controlador.getInstance().getSubmarino();
		submarino = new JLabel("Submarino");
		submarino.setHorizontalAlignment(SwingConstants.CENTER);
		submarino.setForeground(Color.WHITE);
		submarino.setBounds(auxSubmarino.getPosicionX(), auxSubmarino.getPosicionY(), auxSubmarino.getAncho(), auxSubmarino.getAlto());
		submarino.setOpaque(true);
		submarino.setBackground(Color.BLUE);
		
		MovimientoView auxBarco = Controlador.getInstance().getBarco();
		barco01 = new JLabel("Barco01");
		barco01.setHorizontalAlignment(SwingConstants.CENTER);
		barco01.setBounds(auxBarco.getPosicionX(), auxBarco.getPosicionY(), auxBarco.getAncho(), auxBarco.getAlto());
		barco01.setOpaque(true);
		barco01.setBackground(Color.GREEN);

		barco02 = new JLabel("Barco02");
		barco02.setHorizontalAlignment(SwingConstants.CENTER);
		barco02.setBounds(auxBarco.getPosicionX(), auxBarco.getPosicionY(), auxBarco.getAncho(), auxBarco.getAlto());
		barco02.setOpaque(true);
		barco02.setBackground(Color.GREEN);
		
		barco03 = new JLabel("Barco03");
		barco03.setHorizontalAlignment(SwingConstants.CENTER);
		barco03.setBounds(auxBarco.getPosicionX(), auxBarco.getPosicionY(), auxBarco.getAncho(), auxBarco.getAlto());
		barco03.setOpaque(true);
		barco03.setBackground(Color.GREEN);
		c.add(barco01);
		c.add(submarino);
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
				else
					if(e.getKeyCode() == 38)
						Controlador.getInstance().moverArribaSubmarino();
					else
						if(e.getKeyCode() == 39)
							Controlador.getInstance().moverDerechaSubmarino();
						else
							if(e.getKeyCode() == 40)
								Controlador.getInstance().moverAbajoSubmarino();
				if(e.getKeyCode() >= 37 && e.getKeyCode() <= 40)
					moverSubmarino();
			}
		});
		//Timer de swing para requerir al juego que ejecute algun proceso a intervalores regulares
		Timer gameLoop = new Timer(10, new MuevoEntidadesAutomaticas());
		gameLoop.start();
		
	}
	
	
	private void moverSubmarino() {
		MovimientoView auxSubmarino = Controlador.getInstance().getSubmarino();
		submarino.setBounds(auxSubmarino.getPosicionX(), auxSubmarino.getPosicionY(), auxSubmarino.getAncho(), auxSubmarino.getAlto());
	}
	
	class MuevoEntidadesAutomaticas implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Controlador.getInstance().procesosAutomaticos();
			MovimientoView auxBarco = Controlador.getInstance().getBarco();
			barco01.setBounds(auxBarco.getPosicionX(), auxBarco.getPosicionY(), auxBarco.getAncho(), auxBarco.getAlto());
		}
	}
}
