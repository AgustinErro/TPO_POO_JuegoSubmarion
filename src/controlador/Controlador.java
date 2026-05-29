package controlador;

import modelo.MovimientoBidireccional;

public class Controlador {
	
	private static Controlador instance;
	private JuegoSubmarino juego ;
	
	
	//singleton
	public static Controlador getInstance() {
		if(instance == null)
			instance = new Controlador();
		return instance;
	}
	
	public void moverDerechaMB() {
		juego.moverDerecha();
	}
	
	public void moverIzquierdaMB() {
		mb.moverIzquierda();
	}
	
	public void moverArribaMB() {
		mb.moverArriba();
	}
	
	public void moverAbajoMB() {
		mb.moverAbajo();
	}
	
	

}
