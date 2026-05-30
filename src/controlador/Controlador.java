package controlador;

import juego.JuegoSubmarino;

public class Controlador {
	
	private static Controlador instance;
	private JuegoSubmarino juego;
	
	
	
	protected Controlador() {
		super();
		this.juego = new JuegoSubmarino();
	}

	//singleton
	public static Controlador getInstance() {
		if(instance == null)
			instance = new Controlador();
		return instance;
	}
	
	//----------Movimiento Submarino------------------------------------------------------------------------
	public void moverDerechaSubmarino() {
		juego.moverDerecha();
	}
	
	public void moverIzquierdaSubmarino() {
		juego.moverIzquierda();
	}
	
	public void moverArribaSubmarino() {
		juego.moverArriba();
	}
	
	public void moverAbajoSubmarino() {
		juego.moverAbajo();
	}
	
	//----------Movimiento Submarino------------------------------------------------------------------------
	
	

}
