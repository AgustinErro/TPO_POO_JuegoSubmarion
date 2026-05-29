package entidades;

import auxiliares.Area;
import auxiliares.Direccion;

public class CargaProfundidad extends EntdiadMovible{
	
	
	private boolean exploto;
	
	

	public CargaProfundidad(Area areaEntidad, Area areaJuego, int posX, int posY, double velocidad, int nivel) {
		super(areaEntidad, areaJuego, posX, posY, velocidad, nivel);
	}


	@Override
	protected void limitesDeMovimiento() {
		// TODO Auto-generated method stub
		
	}

}
