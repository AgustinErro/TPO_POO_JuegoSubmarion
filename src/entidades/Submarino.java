package entidades;


import auxiliares.Area;
import interfaces.moviminetoHorizontal;

public class Submarino extends EntdiadMovible implements moviminetoHorizontal {

	private int vidas;
	private int salud;
	
	public Submarino(Area areaJuego, int ancho, int alto, int velocidad) {
		super(areaJuego, ancho, alto, velocidad);
		this.posX = Math.divideExact(areaJuego.getAncho(), 2);
		this.posY = Math.divideExact(areaJuego.getAlto(), 2);
		this.salud = 100;
		this.vidas = 3;
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
    
    public void volverPosInicial() {
    	this.posX = Math.divideExact(areaJuego.getAncho(), 2);
		this.posY = posY - 20;	
	}

  //--------------------------------------------------------------------------
  //---------DAÑO-------------------------------------------------------------  
    public int detectarDaño(int centroCargaX, int centroCargaY) {
    	
    	int limiteIzquierdo = this.posX;
        int limiteDerecho = this.posX + this.areaEntidad.getAncho();
        int limiteSuperior = this.posY;
        int limiteInferior = this.posY + this.areaEntidad.getAlto();
        
        int puntoMasCercanoX = Math.max(limiteIzquierdo, Math.min(centroCargaX, limiteDerecho));
        int puntoMasCercanoY = Math.max(limiteSuperior, Math.min(centroCargaY, limiteInferior));
        
        int diferenciaX = centroCargaX - puntoMasCercanoX;
        int diferenciaY = centroCargaY - puntoMasCercanoY;
    	
        int distanciaAlBorde = (int) Math.sqrt((diferenciaX * diferenciaX) + (diferenciaY * diferenciaY));
    	
  
        return calcularDaño(distanciaAlBorde);
			
    }
    
    private int calcularDaño(int distancia) {
        
    	int puntos = 0;
    	
    	if (distancia>100) {
    		puntos = 30;
    	}
    	else if (distancia > 50 && distancia <= 100) {
            puntos = 10;
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
        return puntos;
    }
    private void perderVida() {
        this.vidas--;
        this.salud = 100;
    }
    
    public void sumarVidas(int vidasExtra) {
    	this.vidas = this.vidas + vidasExtra;
    }
    
}
