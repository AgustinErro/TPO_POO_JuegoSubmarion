package entidades;

import java.util.Random;

import auxiliares.Area;
import auxiliares.Direccion;
import interfaces.moviminetoHorizontal;

public class Barco extends EntdiadMovible implements moviminetoHorizontal {
	
	private boolean activo;
	private CargaProfundidad cargaDisparada;
	private Area areaBarco;

	
	public Barco(double nivel, int posMax) {
		super();
		
		Random random = new Random();
		
		this.velocidad = (10 + 0.2 * nivel);	
		this.direccion = random.nextBoolean() ? Direccion.DERECHA : Direccion.IZQUIERDA;
		this.posX = (this.direccion == Direccion.DERECHA) ? 0 : posMax;
		
		
		
		
		// TODO Auto-generated constructor stub
	}

	public void dispararCarga() {
		
	}
	
	@Override
	protected void limitesDeMovimiento() {	
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moverDerecha() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moverIzquierda() {
		// TODO Auto-generated method stub
		
	}

}
