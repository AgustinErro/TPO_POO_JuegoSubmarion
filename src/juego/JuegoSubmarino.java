package juego;

import java.util.ArrayList;

import auxiliares.Area;
import entidades.Barco;
import entidades.Submarino;

public class JuegoSubmarino {

	private int nivel;
	private ArrayList<Barco> barcos;
	private Submarino submarino;
	private int vidas;
	private Area areaJuego;
	

	
	public JuegoSubmarino() {
		super();
		this.areaJuego= new Area(1000, 900);
		this.nivel = 1;
		this.submarino = new Submarino(areaJuego,nivel);
		this.vidas = 3;
		//-----CREADOR DE BARCOS---------
		this.barcos = new ArrayList<Barco>();
	}
	
	//-------MOVIMIENTO SUBMARINO----------
	public void moverDerecha() {
		submarino.moverDerecha();
		
	}
	public void moverIzquierda() {
		submarino.moverIzquierda();
		
	}
	public void moverArriba() {
		submarino.moverArriba();
	}
	public void moverAbajo() {
		submarino.moverAbajo();
		
	}
	//-------------------------------------

}
