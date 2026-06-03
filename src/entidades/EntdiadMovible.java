package entidades;

import auxiliares.Area;
import auxiliares.Direccion;
import views.MovimientoView;

public abstract class EntdiadMovible {
	
	protected Area areaEntidad,areaJuego;
	protected int posX, posY;
	protected int velocidad;
	protected int nivel;
	
	
	
	
	
	public EntdiadMovible(Area areaJuego, int nivel) {
		super();
		this.areaJuego = areaJuego;
		this.nivel = nivel;
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
		System.out.println(mv);
    	return mv;
    }
	
}
