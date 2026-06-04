package test;

import controlador.Controlador;

public class TestControlador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Test get infos
			System.out.println("Ancho de area de juego =" +Controlador.getInstance().getAnchoArea());
			System.out.println("Alto de area de juego =" +Controlador.getInstance().getAltoArea());
			System.out.println("Nivel =" +Controlador.getInstance().getNivel());
			System.out.println("Salud =" +Controlador.getInstance().getsaludRestante());
			System.out.println("Vidas =" +Controlador.getInstance().getvidasRestantes());
			System.out.println("Puntos =" +Controlador.getInstance().getPuntos());
			System.out.println();
		
		
		//Test movimiento Submarino
			System.out.println("PosSubmarino = " + Controlador.getInstance().getSubmarino());
			Controlador.getInstance().moverAbajoSubmarino();
			System.out.println("PosSubmarino = " + Controlador.getInstance().getSubmarino());
			Controlador.getInstance().moverIzquierdaSubmarino();
			System.out.println("PosSubmarino = " + Controlador.getInstance().getSubmarino());
			Controlador.getInstance().moverArribaSubmarino();
			System.out.println("PosSubmarino = " + Controlador.getInstance().getSubmarino());
			Controlador.getInstance().moverDerechaSubmarino();
			System.out.println("PosSubmarino = " + Controlador.getInstance().getSubmarino());
			System.out.println();
			

		//Test procesos loop 
			
			for (int i = 0; i < 11; i++) {
				System.out.println("PosBarco =  "+ Controlador.getInstance().getBarcos());
				Controlador.getInstance().procesosAutomaticos();
				System.out.println();		
			}
			
			for (int i = 0; i < 200; i++) {
				Controlador.getInstance().procesosAutomaticos();		
			}
			
			
			//Test get infos
			System.out.println("Ancho de area de juego =" +Controlador.getInstance().getAnchoArea());
			System.out.println("Alto de area de juego =" +Controlador.getInstance().getAltoArea());
			System.out.println("Nivel =" +Controlador.getInstance().getNivel());
			System.out.println("Salud =" +Controlador.getInstance().getsaludRestante());
			System.out.println("Vidas =" +Controlador.getInstance().getvidasRestantes());
			System.out.println("Puntos =" +Controlador.getInstance().getPuntos());
			System.out.println();


	}

}
