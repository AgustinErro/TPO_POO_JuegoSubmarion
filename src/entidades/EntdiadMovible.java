package entidades;

import auxiliares.Area;
import auxiliares.Direccion;

public abstract class EntdiadMovible {
	
	protected Area areaEntidad,areaJuego;
	protected int posX, posY;
	protected int velocidad;
	protected int nivel;
	
	
	
	
	
	public EntdiadMovible(Area areaJuego, int nivel) {
		super();
		this.areaEntidad = areaEntidad;
		this.areaJuego = areaJuego;
	}

	protected int getPosX() {
		return posX;
	}



	protected void setPosX(int posX) {
		this.posX = posX;
	}



	protected int getPosY() {
		return posY;
	}



	protected void setPosY(int posY) {
		this.posY = posY;
	}



	protected void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

}
