package entidades;

import auxiliares.Area;
import views.MovimientoView;

public abstract class EntdiadMovible {
	
	protected Area areaEntidad,areaJuego;
	protected int posX, posY;
	protected int velocidad;
	
	
	
	
	
	public EntdiadMovible(Area areaJuego, int ancho, int alto, int velocidad) {
		super();
		this.areaJuego = areaJuego;
		this.velocidad = velocidad;
		this.areaEntidad = new Area(ancho, alto);
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
	
	public MovimientoView toView() {
		MovimientoView mv = new MovimientoView(posX, posY, areaEntidad.getAncho(), areaEntidad.getAlto());
    	return mv;
    }
	
}
