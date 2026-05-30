package entidades;

import auxiliares.Area;
import auxiliares.Direccion;

public class CargaProfundidad extends EntdiadMovible{
	


	public CargaProfundidad(Area areaJuego, int nivel, int posX, int posY) {
		super(areaJuego, nivel);
		this.posX = posX;
		this.posY = posY;
	}


}
