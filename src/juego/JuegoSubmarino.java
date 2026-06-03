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
	

	
	public JuegoSubmarino() {
		super();
		this.areaJuego= new Area(1000, 900);
		this.nivel = 1;
		this.puntos = 0;
		
		//-----CREADOR SUBMARINO
		this.submarino = new Submarino(areaJuego,nivel);
		
		//-----CREADOR DE BARCOS---------
		this.barcos = new ArrayList<Barco>();
		for (int i = 0; i < 3; i++) {
			Barco nuevoBarco = new Barco(areaJuego, nivel); 
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
	//-------------------------------------
	//------------MOVER BARCOS-------------
	public void moverBarcos() {
		for (int i = 0; i < 3; i++) {
			this.barcos.get(i).moverBarco();
		}
	}
	//-------------------------------------
	//-----------GESTIONAR NIVEL----------
	public void iniciarNivel() {
		for (int i = 0; i < 3; i++) {
			Barco nuevoBarco = new Barco(areaJuego, nivel); 
			this.barcos.add(nuevoBarco);
		}
		
	}
	public void terminarNivel() {
		this.barcos.clear();
		this.puntos +=200;
		this.nivel +=1;
		submarino.volverPosInicial();
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
	

}
