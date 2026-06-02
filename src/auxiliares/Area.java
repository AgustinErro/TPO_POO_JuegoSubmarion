package auxiliares;

public class Area {
    private int ancho;
    private int alto;

    public Area(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
    }
        

    public boolean estaDentro(int x, int y, int ancho, int alto) {
        return (x >= 0 && x + ancho <= this.ancho) &&
               (y >= 0 && y + alto <= this.alto);
    }

    public boolean estaDentroHorizontal(int x, int ancho) {
        return (x >= 0 && x + ancho <= this.ancho);
    }

    public boolean estaDentroVertical(int y, int alto) {
        return (y >= 10 && y + alto <= this.alto);
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }
    
    public int getCentroX() {
        return this.ancho / 2;
    }

    public int getCentroY() {
        return this.alto / 2;
    }
    
    
}
