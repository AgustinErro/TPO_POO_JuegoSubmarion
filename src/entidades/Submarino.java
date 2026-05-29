package entidades;

import auxiliares.Area;
import interfaces.moviminetoHorizontal;

public class Submarino extends EntdiadMovible implements moviminetoHorizontal {

	
	
	public Submarino(Area areaEntidad, Area areaJuego, int posX, int posY, double velocidad, int nivel) {
		super(areaEntidad, areaJuego, posX, posY, velocidad, nivel);
	}

	@Override
	protected void limitesDeMovimiento() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int moverDerecha() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int moverIzquierda() {
		// TODO Auto-generated method stub
		return 0;
	}

}
