package controlador;

import java.util.ArrayList;

import juego.JuegoSubmarino;
import views.MovimientoView;

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
	
	//----------MOVIMINETO SUBMARINO------------------------------------------------------------------------
	public void moverDerechaSubmarino() {
		if (!juego.terminarJuego())
			juego.moverDerecha();
	}
	
	public void moverIzquierdaSubmarino() {
		if (!juego.terminarJuego())
			juego.moverIzquierda();
	}
	
	public void moverArribaSubmarino() {
		if (!juego.terminarJuego())
			juego.moverArriba();
	}
	
	public void moverAbajoSubmarino() {
		if (!juego.terminarJuego())
			juego.moverAbajo();
	}
	
	//----------PROCESOS EN LOOP------------------------------------------------------------------------
	//TODO
	 public void procesosAutomaticos() {
		 if (!juego.terminarJuego()) {
			juego.moverEntidadesAutomaticas();
		 	juego.sincronizarSubmarino();
		 	juego.sincronizarNivel();
		 }
	 }
	 
	 public int getAnchoArea() {
		return this.juego.getAncho();
	}
		
	public int getAltoArea() {
		return this.juego.getAlto();
	}
	
	public int getNivel() {
		return this.juego.getNivel();
	} 
	public int getPuntos() {
		return this.juego.getPuntos();
	}
	public int getvidasRestantes() {
		return this.juego.vidasRestantes();
	}
	
	public int getsaludRestante() {
		return this.juego.saludRestante();
	}
	
	public ArrayList <MovimientoView> getBarcos(){
		return this.juego.getBarcos();
	}
	
	public ArrayList<MovimientoView> getCargas() {
		return this.juego.getCargas();
	}
	
	public MovimientoView getSubmarino() {
		return juego.getSubmarino();
	}
}
