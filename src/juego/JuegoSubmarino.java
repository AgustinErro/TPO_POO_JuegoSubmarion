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
	private int velocidadBarco = 5;
	

	
	public JuegoSubmarino() {
		super();
		this.areaJuego= new Area(1000, 1000);
		this.nivel = 1;
		this.puntos = 0;
		
		//-----CREADOR SUBMARINO
		this.submarino = new Submarino(areaJuego, 90, 30, velocidadSubmarino);
		
		//-----CREADOR DE BARCOS---------
		this.barcos = new ArrayList<Barco>();
		for (int i = 0; i < 3; i++) {
			Barco nuevoBarco = new Barco(areaJuego, 90, 30, velocidadBarco, this.nivel); 
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
		
		int vidasPorPuntos = puntos / 500;
		if (vidasPorPuntos > vidasExtra) {
		    submarino.sumarVidas(vidasPorPuntos - vidasExtra);
		    vidasExtra = vidasPorPuntos;
		}
	}
	
	public void sincronizarNivel() {
		
		if(barcos.isEmpty()) {
			this.pasarNivel();
		}
		else {
			for (int i = barcos.size() - 1; i >= 0; i--) {
				if (barcos.get(i).isInactivo()) {
					barcos.remove(i);
				}
			}
		}
	}
	
	//-----------GESTIONAR NIVEL----------
	public void pasarNivel() {
		this.nivel +=1;
		this.puntos +=200;
		velocidadBarco = ((int)(velocidadBarco * 1.2) <= 20 ) ? (int)(velocidadBarco * 1.2) : 20;
		for (int i = 0; i < 3; i++) {
			Barco nuevoBarco = new Barco(areaJuego, 90, 30, velocidadBarco, this.nivel);
			this.barcos.add(nuevoBarco);
		}
	}
	
	public boolean terminarJuego() {
		if (submarino.getVidas() < 0) {
			System.out.println("Se termina el juego");
			return true;
		}
		else {
			return false;
		}
	}
		
	//---------------------------------------
	//----------INFO PANTALLA----------------
	public ArrayList <MovimientoView> getBarcos() {
		
		ArrayList<MovimientoView> mv = new ArrayList<MovimientoView>();
			for (int i = 0; i < this.barcos.size(); i++) {
				mv.add(this.barcos.get(i).toView());
			}
		return mv;
		
	}
	
	public ArrayList<MovimientoView> getCargas() {
		ArrayList<MovimientoView> mv = new ArrayList<>();
		for (Barco barco : this.barcos) {
			mv.addAll(barco.getCargasView());
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
