package controlador;

import java.util.ArrayList;

import juego.JuegoSubmarino;
import views.MovimientoView;

public class Controlador {

	private JuegoSubmarino juego;

	public Controlador() {
		super();
		this.juego = new JuegoSubmarino();
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
	
	public boolean getTerminoJuego() {
		return juego.terminarJuego();
	}
	
	public void reiniciarJuego() {
		this.juego.reiniciarJuego();
	}
	
	public ArrayList<int[]> getExplosiones() {
		return this.juego.getExplosionesRecientes();
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
