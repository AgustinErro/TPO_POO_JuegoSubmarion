package entidades;

import java.util.ArrayList;
import java.util.Random;

import auxiliares.Area;
import auxiliares.ContadorGlobal;
import interfaces.moviminetoHorizontal;

public class Barco extends EntdiadMovible implements moviminetoHorizontal {
	
	private int id;
	private ArrayList<CargaProfundidad> cargasDisparadas;
	private int viajes;
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
        if (areaJuego.estaDentroHorizontal(nuevaX, (this.areaEntidad.getAncho()*2+1))) {
            this.posX = nuevaX;
        }
        else {
        	//poner timer de espera antes de volver a iniciar viaje
        	this.volverPosInicial();
        	this.viajes = this.viajes -1;
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
        	//poner timer de espera antes de volver a iniciar viaje
        	this.volverPosInicial();
        	this.viajes = this.viajes-1;
        }
        return posX;
		
	}
	
	public void volverPosInicial() {
		Random random = new Random();
    	this.direccion = random.nextBoolean();
		this.posX = ((this.velocidad == 0) ? 0 : areaJuego.getAncho()-100);
		
	}

	//---------------------------------------------------------

	public void dispararCarga() {
		System.out.println("Disparo desde X = " + this.posX);
		
		CargaProfundidad nuevaCarga = new CargaProfundidad(this.areaJuego ,this.nivel , this.posX, this.posY);
		this.cargasDisparadas.add(nuevaCarga);
	}


	protected int getId() {
		return id;
	}


	protected int getViajes() {
		return viajes;
	}
	
	//----------------------------------------------------
	
	

}
