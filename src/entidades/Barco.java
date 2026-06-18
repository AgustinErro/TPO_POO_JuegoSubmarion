package entidades;

import java.util.ArrayList;
import java.util.Random;

import auxiliares.Area;
import interfaces.movimientoHorizontal;
import views.MovimientoView;

public class Barco extends EntidadMovible implements movimientoHorizontal {
	
	private ArrayList<CargaProfundidad> cargasDisparadas;
	private int viajes;
	private boolean direccion;
	private int esperar;
	private int nivel;


	public Barco(Area areaJuego, int ancho, int alto, int velocidad, int nivel) {
		super(areaJuego, ancho, alto, velocidad);
		
		this.posY = 100;
		this.viajes = 0;
		this.nivel = nivel;

		this.posInicial();
		this.cargasDisparadas = new ArrayList<CargaProfundidad>();
		
	}
	
	//----------Movimiento Barco-----------------------------
	public void moverBarco() {

		
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
	        if (nuevaX < 0 ||areaJuego.estaDentroHorizontal(nuevaX, 0)) {
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
	        if (nuevaX+this.areaEntidad.getAncho() > areaJuego.getAncho() || areaJuego.estaDentroHorizontal(nuevaX+this.areaEntidad.getAncho(), 0)) {
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
    	this.posX = ((this.direccion) ? -this.areaEntidad.getAncho() : areaJuego.getAncho());;
    	Random random2 = new Random();
		this.esperar = random2.nextInt(1, 300);
		
	}
	
	//---------------------------------------------------------
	

	public void dispararCarga() {
		
		Random random = new Random();
		
		int limite = Math.max(5, 10 - (this.nivel - 1) / 5);
		if (random.nextInt(1, limite) == 2) {
			CargaProfundidad nuevaCarga = new CargaProfundidad(this.areaJuego, 10, 10, (this.areaEntidad.getCentroX()+ this.posX)  , (this.posY+this.areaEntidad.getAlto()-1), this.velocidad);
			this.cargasDisparadas.add(nuevaCarga);
			System.out.println("Disparo carga "+ nuevaCarga.getId()+ " desde posicion X = " +(this.areaEntidad.getCentroX()+this.posX));
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
			
		for (int i = cargasDisparadas.size() - 1; i >= 0; i--) {
			if (cargasDisparadas.get(i).isExploto()) {
				int[] centroCarga = cargasDisparadas.get(i).getCentro();
				centrosExplocion.add(centroCarga);
				cargasDisparadas.remove(i);
				
			}
		}
		
		
		return centrosExplocion;
		
	}

	public boolean isInactivo() {

		return (viajes < 0 && cargasDisparadas.isEmpty());
	}

	public int getViajes() {
		return viajes;
	}
	
	
	
	//----------------------------------------------------
	
	public ArrayList<MovimientoView> getCargasView() {
		ArrayList<MovimientoView> views = new ArrayList<>();
		for (CargaProfundidad carga : cargasDisparadas) {
			views.add(carga.toView());
		}
		return views;
	}
	
	@Override
	public MovimientoView toView() {
		MovimientoView mv = super.toView();
		mv.setViajes(this.viajes);
		return mv;
	}

}
