package entidades;

import java.util.ArrayList;
import java.util.Random;

import auxiliares.Area;
import auxiliares.Direccion;
import interfaces.moviminetoHorizontal;

public class Barco extends EntdiadMovible implements moviminetoHorizontal {
	
	private ArrayList<CargaProfundidad> cargasDisparadas;
	private int rebotes;

	
	
	
	
	
	public Barco(Area areaEntidad, Area areaJuego, int posX, int posY, double velocidad, int nivel) {
		super(areaEntidad, areaJuego, posX, posY, velocidad, nivel);
		
		Random random = new Random();
		
		
		this.velocidad = (10 + 2 * nivel);	
		this.direccion = random.nextBoolean() ? Direccion.DERECHA : Direccion.IZQUIERDA;
		this.posX = (this.direccion == Direccion.DERECHA) ? 0 : areaJuego.getAncho();
	}


	public void dispararCarga() {
		
	}
	
	@Override
	protected void limitesDeMovimiento() {	
		// TODO Auto-generated method stub
		
	}

	@Override
	public int moverDerecha() {
		int nuevaX = this.posX + this.velocidad;
        if (areaJuego.estaDentroHorizontal(nuevaX, this.areaEntidad.getAncho())) {
            this.posX = nuevaX;
        }
        else
        	velocidad *= -1;
        return posX;
		
	}

	@Override
	public int moverIzquierda() {
		// TODO Auto-generated method stub
		return posX;
	}

}
