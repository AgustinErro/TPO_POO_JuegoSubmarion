package entidades;

import auxiliares.Area;
import auxiliares.Direccion;

public abstract class EntdiadMovible {
	
	protected Area area;
	protected int posX, posY;
	protected double velocidad;
	protected Direccion direccion;
	
	
	
	
	
	protected EntdiadMovible() {
		super();
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



	protected void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}



	protected void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	

	
	
	

}
