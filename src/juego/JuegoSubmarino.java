package juego;

import java.util.ArrayList;

import auxiliares.Area;
import entidades.Barco;
import entidades.Submarino;
import views.MovimientoView;

public class JuegoSubmarino {

	private int nivel;
	private ArrayList<Barco> barcos;
	
	private Submarino submarino;
	private Area areaJuego;
	private int puntos;
	private int vidasExtra;
	private int velocidadSubmarino = 10;
	private int velocidadBarco = 80;
	

	
	public JuegoSubmarino() {
		super();
		this.areaJuego= new Area(1000, 900);
		this.nivel = 1;
		this.puntos = 0;
		
		//-----CREADOR SUBMARINO
		this.submarino = new Submarino(areaJuego, 90, 30, velocidadSubmarino);
		
		//-----CREADOR DE BARCOS---------
		this.barcos = new ArrayList<Barco>();
		for (int i = 0; i < 3; i++) {
			Barco nuevoBarco = new Barco(areaJuego, 90, 30, velocidadBarco); 
			this.barcos.add(nuevoBarco);
		}
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
	
	//------------METODOS EN LOOP------------
	public void moverEntidadesAutomaticas() {
		for (int i = 0; i < barcos.size(); i++) {
			this.barcos.get(i).moverBarco();
			this.barcos.get(i).moverCargas();			
		}
	}
	
	public void sincronizarSubmarino() {
		
		ArrayList<int[]> ce = new ArrayList<int[]>();
		
		for (int i = 0; i < barcos.size(); i++) {
			ce.addAll(this.barcos.get(i).hayCargasExplotadas());
		}
		int p = submarino.detectarDaño(ce);
		puntos += p;
		if (p>0)
			System.out.println("Se ganan "+ p +" puntos");
		
		if (Math.divideExact(puntos, 500)> vidasExtra) {
			submarino.sumarVidas(Math.divideExact(puntos, 500)-vidasExtra);
			vidasExtra = Math.divideExact(puntos, 2);
		}
		
	}

	//-----------GESTIONAR NIVEL----------
	public void pasarNivel() {
		for (int i = 0; i < 3; i++) {
			Barco nuevoBarco = new Barco(areaJuego, nivel, 90, 30); 
			this.barcos.add(nuevoBarco);
		}
		
	}
	public void terminarNivel() {
		this.puntos +=200;
		this.nivel +=1;
		barcos.clear();
	}
	
	public void reiniciarJuego() {
		
	}
	//---------------------------------------
	//----------INFO PANTALLA----------------
	public ArrayList <MovimientoView> getBarcos() {
		
		ArrayList<MovimientoView> mv = new ArrayList<MovimientoView>();
			for (int i = 0; i < 3; i++) {
				mv.add(this.barcos.get(i).toView());
			}
		return mv;
		
	}

	public MovimientoView getSubmarino() {
		return submarino.toView();	
	}

	public int getNivel() {
		return nivel;
	} 
	
	public int vidasRestantes() {
		return submarino.getVidas();
	}
	
	public int saludRestante() {
		return submarino.getSalud();
	}

	public int getAlto() {
		return this.areaJuego.getAlto();
	}

	public int getAncho() {
		return this.areaJuego.getAncho();
	}

	public int getPuntos() {
		return this.puntos;
	}
	
	

}
