package entidades;

import java.util.ArrayList;
import java.util.Random;

import auxiliares.Area;
import interfaces.moviminetoHorizontal;

public class Barco extends EntdiadMovible implements moviminetoHorizontal {
	
	private ArrayList<CargaProfundidad> cargasDisparadas;
	private int viajes;
	private boolean direccion;
	private int esperar;

	
	public Barco(Area areaJuego, int ancho, int alto, int velocidad) {
		super(areaJuego, ancho, alto, velocidad);
		
		this.posY = 100;
		this.viajes = 3;

		this.posInicial();
		this.cargasDisparadas = new ArrayList<CargaProfundidad>();
		
	}
	
	//----------Movimiento Barco-----------------------------
	public void moverBarco() {
		
		this.moverCargas();
		
		if (viajes >= 0) {
			
			if (this.direccion) {
				posX = this.moverDerecha();

			}
			else {
				posX = this.moverIzquierda();
			}
			if (this.areaJuego.estaDentroHorizontal(this.posX, (this.areaEntidad.getAncho()))) {
				this.dispararCarga();
			}
		}

		
	}
	
	@Override
	public int moverDerecha(){
		if (esperar > 0) {
        	esperar--;
		}
		else {
			int nuevaX = this.posX + this.velocidad;
	        if (areaJuego.estaDentroHorizontal(nuevaX+100, (this.areaEntidad.getAncho()))) {
	            this.posX = nuevaX;
	        }
	        else {
	        	this.posInicial();
		        this.viajes = this.viajes -1;
	        	}
	        }	
        return posX;
		
	}
	@Override
	public int moverIzquierda() {
		if (esperar > 0) {
        	esperar--;
		}
        else {	
			int nuevaX = this.posX - this.velocidad;
	        if (areaJuego.estaDentroHorizontal(nuevaX, this.areaEntidad.getAncho()-100)) {
	            this.posX = nuevaX;
	        }
	        else {
	        	this.posInicial();
		        this.viajes = this.viajes -1;
	        }
	    }
        return posX;
		
	}
	public void posInicial() {
		Random random = new Random();
    	this.direccion = random.nextBoolean();
    	this.posX = ((this.direccion) ? -100 : areaJuego.getAncho()+1);;
		this.esperar = random.nextInt(2, 10);
		
	}
	
	//---------------------------------------------------------
	

	public void dispararCarga() {
		
		Random random = new Random();
		
		if (random.nextInt(1, 10) == 5) {
			System.out.println("Disparo carga desde X = " + this.posX);
			
			CargaProfundidad nuevaCarga = new CargaProfundidad(this.areaJuego, (this.posX + this.areaEntidad.getAncho()/2)  , this.posY, 10, 10, this.velocidad);
			this.cargasDisparadas.add(nuevaCarga);
		}
	}
	
	public void moverCargas() {
		if (!cargasDisparadas.isEmpty()) {
			for (int i = 0; i < cargasDisparadas.size(); i++) {
				cargasDisparadas.get(i).moverAbajo();					
			}
		}
	}
	public ArrayList<int[]> hayCargasExplotadas() {
		ArrayList<int[]> centrosExplocion = new ArrayList<>();
			
		for (int i = 0; i < cargasDisparadas.size(); i++) {
			if (cargasDisparadas.get(i).isExploto()) {
				int[] centroCarga = cargasDisparadas.get(i).getCentro();
				centrosExplocion.add(centroCarga);
				cargasDisparadas.remove(i);
				
			}
		}
		
		
		return centrosExplocion;
		
	}

	protected boolean isActivo() {

		return (viajes == 0 && cargasDisparadas.isEmpty());
	}

	protected int getViajes() {
		return viajes;
	}
	
	
	
	//----------------------------------------------------
	
	

}
