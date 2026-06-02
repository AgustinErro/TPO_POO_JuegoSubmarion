package entidades;

import auxiliares.Area;
import interfaces.moviminetoHorizontal;

public class Submarino extends EntdiadMovible implements moviminetoHorizontal {

	private int vidas;
	private int salud;
	private int puntos;
	
	public Submarino(Area areaJuego, int nivel) {
		super(areaJuego, nivel);
		this.velocidad = 10;
		this.areaEntidad = new Area(90,30);
		this.posX = Math.divideExact(areaJuego.getAncho(), 2);
		this.posY = posY - 20;
		this.salud = 100;
		this.vidas = 3;
			
		
		
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
        if (areaJuego.estaDentroVertical(nuevaY, areaEntidad.getAlto())) {
            posY = nuevaY;
        }
        return posY;
    }

    public int moverAbajo() {
        int nuevaY = posY + velocidad;
        if (areaJuego.estaDentroVertical(nuevaY, areaEntidad.getAlto())) {
            posY = nuevaY;
        }
        return posY;
    }
  //--------------------------------------------------------------------------
  //---------DAÑO-------------------------------------------------------------  
    public void detectarDaño(int centroCargaX, int centroCargaY) {
    	
    	int limiteIzquierdo = this.posX;
        int limiteDerecho = this.posX + this.areaEntidad.getAncho();
        int limiteSuperior = this.posY;
        int limiteInferior = this.posY + this.areaEntidad.getAlto();
        
        int puntoMasCercanoX = Math.max(limiteIzquierdo, Math.min(centroCargaX, limiteDerecho));
        int puntoMasCercanoY = Math.max(limiteSuperior, Math.min(centroCargaY, limiteInferior));
        
        int diferenciaX = centroCargaX - puntoMasCercanoX;
        int diferenciaY = centroCargaY - puntoMasCercanoY;
    	
        int distanciaAlBorde = (int) Math.sqrt((diferenciaX * diferenciaX) + (diferenciaY * diferenciaY));
    	
    	recibirDaño(distanciaAlBorde);
			
    }
    
    private void recibirDaño(int distancia) {
        
        if (distancia > 100) {
            this.puntos += 30;
        } 
        else if (distancia > 50 && distancia <= 100) {
            this.puntos += 10;
            this.salud -= 30;
        } 
        else if (distancia > 10 && distancia <= 50) {
            this.salud -= 50;
        } 
        else if (distancia <= 10) {
            perderVida(); 
        }

        if (this.salud <= 0) {
            perderVida();
        }
    }
    private void perderVida() {
        this.vidas--;
        this.salud = 100;
    }
    
}
