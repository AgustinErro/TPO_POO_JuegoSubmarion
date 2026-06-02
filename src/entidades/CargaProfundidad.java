package entidades;

import java.util.Random;

import auxiliares.Area;
import auxiliares.ContadorGlobal;
import auxiliares.Direccion;

public class CargaProfundidad extends EntdiadMovible{
	
	private int id;
	private int profExplosion;
	private int radioExplosion;
	private boolean exploto;

	
	public CargaProfundidad(Area areaJuego, int nivel, int posX, int posY) {
		super(areaJuego, nivel);
		this.posX = posX;
		this.posY = posY;
		this.velocidad = 5 + nivel;
		this.id =  ContadorGlobal.registrarNuevaCarga();
		this.exploto = false;
		Random random = new Random();
		
		this.profExplosion = random.nextInt(300, 701);
		}


	public int moverAbajo() {
		if (posY < this.profExplosion) {	
	        int nuevaY = posY + velocidad;
	        if (areaJuego.estaDentroVertical(nuevaY, areaEntidad.getAlto())) {
	            posY = nuevaY;
	        }
		}
		else {
			this.exploto = true;
			System.out.println("Explota Carga "+ this.id +" posicion (" + this.posX +", "+ this.posY +")" );
		}
	    return posY;
    }


	public int getProfExplosion() {
		return profExplosion;
	}


	public int getRadioExplosion() {
		return radioExplosion;
	}


	public int getId() {
		return id;
	}


	protected boolean isExploto() {
		return exploto;
	}
	
	
	

}
