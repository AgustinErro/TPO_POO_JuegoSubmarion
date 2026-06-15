package entidades;


import java.util.ArrayList;

import auxiliares.Area;
import interfaces.moviminetoHorizontal;

public class Submarino extends EntidadMovible implements moviminetoHorizontal {

	private int vidas;
	private int salud;
	
	public Submarino(Area areaJuego, int ancho, int alto, int velocidad) {
		super(areaJuego, ancho, alto, velocidad);
		this.setPosInicial();
		this.salud = 100;
		this.vidas = 3;
		this.velocidad = velocidad;
		this.areaEntidad = new Area(ancho, alto);
		this.areaJuego = areaJuego;
	}
	
	public int getVidas() {
		return vidas;
	}

	public int getSalud() {
		return salud;
	}


	//-----------MOVIMIENTO------------------------------------------------
	@Override
	public int moverDerecha() {
		int nuevaX = posX + velocidad;
        if (areaJuego.estaDentroHorizontal(nuevaX, areaEntidad.getAncho())) {
        	posX = nuevaX;
        }
        return posX;
	}

	@Override
	public int moverIzquierda() {
		int nuevaX = posX - velocidad;
        if (areaJuego.estaDentroHorizontal(nuevaX, areaEntidad.getAncho())) {
        	posX = nuevaX;
        }
        return posX;
	}
	
    public int moverArriba() {
        int nuevaY = posY - velocidad;
        if (areaJuego.estaDentroVertical(nuevaY-420, areaEntidad.getAlto())) {
            posY = nuevaY;
        }
        return posY;
    }

    public int moverAbajo() {
        int nuevaY = posY + velocidad;
        if (areaJuego.estaDentroVertical(nuevaY, areaEntidad.getAlto()+70)) {
            posY = nuevaY;
        }
        return posY;
    }
    
    public void setPosInicial() {
    	this.posX = Math.divideExact(areaJuego.getAncho(), 2);
		this.posY = Math.divideExact(areaJuego.getAlto(), 2);

    }

  //---------DAÑO-------------------------------------------------------------  
    public int detectarDaño(ArrayList<int[]> centrosExplocion) {
    	
    	int puntosGanados = 0;
    		
    	for (int i = 0; i < centrosExplocion.size(); i++) {
    			
    		int centroCargaX = centrosExplocion.get(i)[0];
    		int centroCargaY = centrosExplocion.get(i)[1];
    		
		    int limiteIzquierdo = this.posX;
		    int limiteDerecho = this.posX + this.areaEntidad.getAncho();
		    int limiteSuperior = this.posY;
		    int limiteInferior = this.posY + this.areaEntidad.getAlto();
		        
		    int puntoMasCercanoX = Math.max(limiteIzquierdo, Math.min(centroCargaX, limiteDerecho));
		    int puntoMasCercanoY = Math.max(limiteSuperior, Math.min(centroCargaY, limiteInferior));
		        
		    int diferenciaX = centroCargaX - puntoMasCercanoX;
		    int diferenciaY = centroCargaY - puntoMasCercanoY;
		    	
		    int distanciaAlBorde = (int) Math.sqrt((diferenciaX * diferenciaX) + (diferenciaY * diferenciaY));
		        
		    puntosGanados += calcularDaño(distanciaAlBorde);
    	}

    	return puntosGanados;
    }
    
    private int calcularDaño(int distancia) {
        
    	int puntos = 0;
    	
    	if (distancia>100) {
    		puntos = 30;
    	}
    	else if (distancia > 50 && distancia <= 100) {
            puntos = 10;
            this.salud -= 30;
            System.out.println("Menos 30 de salud");
        } 
        else if (distancia > 10 && distancia <= 50) {
            this.salud -= 50;
            System.out.println("Menos 50 de salud");
        } 
        else if (distancia <= 10) {
        	this.salud -= 100; 
        }

        if (this.salud <= 0) {
            perderVida();
        }
        return puntos;
    }
    private void perderVida() {
    	System.out.println("Se pierde una vida");
    	this.vidas--;
        if(vidas>0) 
        	this.salud = 100;
        else {
        	this.salud = 0;
        	System.out.println("No hay mas vidas");
        }	
    }
    
    public void sumarVidas(int vidasExtra) {
    	if (this.vidas <7) {
    		this.vidas = this.vidas + vidasExtra;
    		System.out.println("Se suma " + vidasExtra +"  vida");
    	}
    }
    
    
}
