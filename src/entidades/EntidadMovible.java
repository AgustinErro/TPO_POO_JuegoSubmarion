package entidades;

import auxiliares.Area;
import views.MovimientoView;

public abstract class EntidadMovible {
	
	protected Area areaEntidad,areaJuego;
	protected int posX, posY;
	protected int velocidad;
	
	
	
	
	
	public EntidadMovible(Area areaJuego, int ancho, int alto, int velocidad) {
		super();
		this.areaJuego = areaJuego;
		this.velocidad = velocidad;
		this.areaEntidad = new Area(ancho, alto);
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
	
	public MovimientoView toView() {
		MovimientoView mv = new MovimientoView(posX, posY, areaEntidad.getAncho(), areaEntidad.getAlto());
    	return mv;
    }
	
}
