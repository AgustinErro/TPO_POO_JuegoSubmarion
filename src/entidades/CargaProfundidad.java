package entidades;

import java.util.Random;

import auxiliares.Area;
import auxiliares.ContadorGlobal;

public class CargaProfundidad extends EntdiadMovible{
	
	private int id;
	private int profExplosion;
	private boolean exploto;

	
	public CargaProfundidad(Area areaJuego, int ancho, int alto, int posX, int posY, int velocidad) {
		super(areaJuego, ancho, alto, velocidad);
		//this.areaEntidad = new Area(ancho,alto);
		this.posX = posX;
		this.posY = posY;
		//this.velocidad = velocidad;
		this.id =  ContadorGlobal.registrarNuevaCarga();
		this.exploto = false;
		Random random = new Random();
		
		this.profExplosion = random.nextInt(300, 701);
		}
	
	public void moverAbajo() {
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
    }


	public int getProfExplosion() {
		return profExplosion;
	}

	public int getId() {
		return id;
	}


	protected boolean isExploto() {
		return exploto;
	}

	public int[] getCentro() {
		int[] centro = {this.areaEntidad.getCentroX(),this.areaEntidad.getCentroY()};
		return centro;
	}
	
	
	

}
