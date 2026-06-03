package entidades;

import java.util.ArrayList;
import java.util.Random;

import auxiliares.Area;
import auxiliares.ContadorGlobal;
import interfaces.moviminetoHorizontal;

public class Barco extends EntdiadMovible implements moviminetoHorizontal {
	
	private ArrayList<CargaProfundidad> cargasDisparadas;
	private int viajes;
	private boolean direccion;
	private int esperar;

	
	public Barco(Area areaJuego, int nivel) {
		super(areaJuego, nivel);
		
		this.posY = 100;
		this.viajes = 3;
		this.areaJuego = areaJuego;
		this.areaEntidad = new Area(90,30);
		this.velocidad = ( 200);
		
		this.posInicial();
		/*
		Random random = new Random();	
		this.direccion = random.nextBoolean();
		this.posX = ((this.direccion) ? 100 : 200);
		*/
		this.cargasDisparadas = new ArrayList<CargaProfundidad>();
		
	}


	//----------Movimiento Barco-----------------------------
	
	public int moverBarco() {
		
		//TODO si hay cargas moverlas
		if (!cargasDisparadas.isEmpty()) {
			for (int i = 0; i < cargasDisparadas.size(); i++) {
				cargasDisparadas.get(i).moverAbajo();
			}
		}

		
		if (viajes >= 0) {
			
			if (this.direccion) {
				return this.moverDerecha();

			}
			else {
				return this.moverIzquierda();
			}
			
			//TODO si esta dentro del areaJuego posibilidad de tirar carga
		}
		else
			//no se mueve 
			return posX;
	}
	
	@Override
	public int moverDerecha() {
		int nuevaX = this.posX + this.velocidad;
        if (areaJuego.estaDentroHorizontal(nuevaX, (this.areaEntidad.getAncho()))) {
            this.posX = nuevaX;
        }
        else {
        	//timer de espera antes de volver a iniciar viaje
        	if (esperar > 0) {
	        	esperar--;
        	}
        	else {
        		this.posInicial();
	        	this.viajes = this.viajes -1;
	        	
	        	Random random = new Random();
	    		this.esperar = random.nextInt(1, 10);
        	}
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
        	//timer de espera antes de volver a iniciar viaje
        	if (esperar > 0) {
	        	esperar--;
        	}
        	else {
        		this.posInicial();
	        	this.viajes = this.viajes -1;
	        	
	        	Random random = new Random();
	    		this.esperar = random.nextInt(1, 10);
        	}
        }
        return posX;
		
	}
	
	public void posInicial() {
		Random random = new Random();
    	this.direccion = random.nextBoolean();
    	this.posX = ((this.direccion) ? 0 : areaJuego.getAncho());;
		
	}
	
	//---------------------------------------------------------

	public void dispararCarga() {
		System.out.println("Disparo desde X = " + this.posX);
		
		CargaProfundidad nuevaCarga = new CargaProfundidad(this.areaJuego ,this.nivel , this.posX, this.posY);
		this.cargasDisparadas.add(nuevaCarga);
	}


	protected int getViajes() {
		return viajes;
	}
	
	//----------------------------------------------------
	
	

}
