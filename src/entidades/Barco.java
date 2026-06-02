package entidades;

import java.util.ArrayList;
import java.util.Random;

import auxiliares.Area;
import auxiliares.ContadorGlobal;
import interfaces.moviminetoHorizontal;

public class Barco extends EntdiadMovible implements moviminetoHorizontal {
	
	private int id;
	private ArrayList<CargaProfundidad> cargasDisparadas;
	private int rebotes;
	private boolean direccion;

	
	public Barco(Area areaJuego, int nivel) {
		super(areaJuego, nivel);
		this.id = ContadorGlobal.registrarNuevoBarco();
		this.areaEntidad = new Area(90,30);
		this.velocidad = (10 + 2* nivel); 
		Random random = new Random();	
		this.direccion = random.nextBoolean();
		this.posX = ((this.velocidad == 0) ? 0 : areaJuego.getAncho()-100);
	}


	//----------Movimiento Barco-----------------------------
	
	public int moverBarco() {
		
		if (rebotes > 0) {
		
			if (this.direccion)
				return this.moverDerecha();
			else
				return this.moverIzquierda();
		}
		else
			return posX;
	}
	
	@Override
	public int moverDerecha() {
		int nuevaX = this.posX + this.velocidad;
        if (areaJuego.estaDentroHorizontal(nuevaX, (this.areaEntidad.getAncho()*2+1))) {
            this.posX = nuevaX;
        }
        else {
        	this.direccion = false;
        	this.rebotes = this.rebotes-1;
        }	
        return posX;
		
	}

	@Override
	public int moverIzquierda() {        
		int nuevaX = this.posX - this.velocidad;
        if (areaJuego.estaDentroHorizontal(nuevaX, this.areaEntidad.getAncho())) {
            this.posX = nuevaX;
        }
        else {
        	this.direccion = true;
        	this.rebotes = this.rebotes-1;
        }
        return posX;
		
	}
	//---------------------------------------------------------

	public void dispararCarga() {
		System.out.println("Disparo desde X = " + this.posX);
	}


	protected int getId() {
		return id;
	}


	protected int getRebotes() {
		return rebotes;
	}
	
	//----------------------------------------------------
	
	

}
