package entidades;

import auxiliares.Area;
import auxiliares.Direccion;

public abstract class EntdiadMovible {
	
	protected Area areaEntidad,areaJuego;
	protected int posX, posY;
	protected int velocidad;
	protected Direccion direccion;
	protected int nivel;
	
	
	
	
	
	public EntdiadMovible(Area areaEntidad, Area areaJuego, int posX, int posY, double velocidad, int nivel) {
		super();
		this.areaEntidad = areaEntidad;
		this.areaJuego = areaJuego;
	}


	protected abstract void limitesDeMovimiento();



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



	protected void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	

	
	
	

}
