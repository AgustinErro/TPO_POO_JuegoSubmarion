package views;

public class MovimientoView {
	
    private int posX;
    private int posY;
    private int ancho;
    private int alto;	
    
    public MovimientoView() {}

	public MovimientoView(int posicionX, int posicionY, int ancho, int alto) {
		this.posX = posicionX;
		this.posY = posicionY;
		this.ancho = ancho;
		this.alto = alto;
	}

	public int getPosicionX() {
		return posX;
	}

	public void setPosicionX(int posicionX) {
		this.posX = posicionX;
	}

	public int getPosicionY() {
		return posY;
	}

	public void setPosicionY(int posicionY) {
		this.posY = posicionY;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	@Override
	public String toString() {
		return "MovimientoView [posicionX=" + posX + ", posicionY=" + posY + "]";
	}
	
	
	
}
