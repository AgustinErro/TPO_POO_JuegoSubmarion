package test;

import controlador.Controlador;

public class TestControlador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Test get infos
		System.out.println(Controlador.getInstance().getAnchoArea());
		System.out.println(Controlador.getInstance().getAltoArea());
		System.out.println(Controlador.getInstance().getNivel());
		System.out.println(Controlador.getInstance().getsaludRestante());
		System.out.println(Controlador.getInstance().getvidasRestantes());
		
		
		//Test movimiento Submarino
		Controlador.getInstance().moverAbajoSubmarino();
		System.out.println("PosX = " + Controlador.getInstance().);
		
		
		
		
		
		
	}

}
