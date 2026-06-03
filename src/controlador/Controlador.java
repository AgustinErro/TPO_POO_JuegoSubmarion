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
	
	//----------EJECUTAR BARCOS------------------------------------------------------------------------
	//TODO
	 public void moverEntidadesAutomaticas() {
		 juego.moverEntidadesAutomaticas();
		 
	 }
	//---------------------------------------------------------------------------------------------------
	
	//----------MOVIMINETO CARGAS-------------------------------------------------------------------------
	//TODO
	 public void moverCargas() {
		 
	 }
	//----------------------------------------------------------------------------------------------------
	 
	 public int getAnchoArea() {
		return this.juego.getAncho();
	}
		
	public int getAltoArea() {
		return this.juego.getAlto();
	}
	
	public int getNivel() {
		return this.juego.getNivel();
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
	
	public MovimientoView getSubmarino() {
		return juego.getSubmarino();
	}
}
