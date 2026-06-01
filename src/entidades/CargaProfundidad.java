package entidades;

import auxiliares.Area;
import auxiliares.Direccion;

public class CargaProfundidad extends EntdiadMovible{
	


	public CargaProfundidad(Area areaJuego, int nivel, int posX, int posY) {
		super(areaJuego, nivel);
		this.posX = posX;
		this.posY = posY;
		this.velocidad = 5 + nivel;
	}
	
    public int moverAbajo() {
        int nuevaY = posY + velocidad;
        if (areaJuego.estaDentroVertical(nuevaY, areaEntidad.getAlto())) {
            posY = nuevaY;
        }
        return posY;
    }

}
