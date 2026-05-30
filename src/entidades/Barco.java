package entidades;

import java.util.ArrayList;
import java.util.Random;

import auxiliares.Area;
import auxiliares.Direccion;
import interfaces.moviminetoHorizontal;

public class Barco extends EntdiadMovible implements moviminetoHorizontal {
	
	private ArrayList<CargaProfundidad> cargasDisparadas;
	private int rebotes;

	
	
	
	
	
	public Barco(Area areaJuego, int nivel) {
		super(areaJuego, nivel);
		this.areaEntidad = new Area(90,30);
		
		Random random = new Random();	
		this.velocidad = (10 + 2* nivel) * (random.nextBoolean() ? 1 : -1);
		this.posX = (this.velocidad >= 0) ? 0 : areaJuego.getAncho();
	}


	//----------Movimiento Barco-----------------------------
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
		int nuevaX = this.posX - this.velocidad;
        if (areaJuego.estaDentroHorizontal(nuevaX, this.areaEntidad.getAncho())) {
            this.posX = nuevaX;
        }
        else
        	velocidad *= -1;
        return posX;
		
	}
	//---------------------------------------------------------

	public void dispararCarga() {
		
	}
	

}
