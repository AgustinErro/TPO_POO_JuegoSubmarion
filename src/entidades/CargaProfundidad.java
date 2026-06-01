package entidades;

import java.util.Random;

import auxiliares.Area;
import auxiliares.Direccion;

public class CargaProfundidad extends EntdiadMovible{
	
	private int profExplosion;

	public CargaProfundidad(Area areaJuego, int nivel, int posX, int posY) {
		super(areaJuego, nivel);
		this.posX = posX;
		this.posY = posY;
		this.velocidad = 5 + nivel;
		
		Random random = new Random();
		
		this.profExplosion = 0;
		}
	
    public int moverAbajo() {
        int nuevaY = posY + velocidad;
        if (areaJuego.estaDentroVertical(nuevaY, areaEntidad.getAlto())) {
            posY = nuevaY;
        }
        return posY;
    }

}
