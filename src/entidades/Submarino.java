package entidades;

import auxiliares.Area;
import interfaces.moviminetoHorizontal;

public class Submarino extends EntdiadMovible implements moviminetoHorizontal {

	private int vidas;
	private int salud;
	
	public Submarino(Area areaJuego, int nivel) {
		super(areaJuego, nivel);
		this.velocidad = 10;
		this.areaEntidad = new Area(90,30);
		this.posX = Math.divideExact(areaJuego.getAncho(), 2);
		this.posY = posY - 20;
		
		
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
    public void detectarDaño() {
    	
    }
    
    private void recibirDaño(int distancia) {
    	
    	
    }
    
}
