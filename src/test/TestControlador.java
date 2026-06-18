package test;

import controlador.Controlador;

public class TestControlador {

	public static void main(String[] args) {
		Controlador controlador = new Controlador();

		//Test get infos
			System.out.println("Ancho de area de juego =" + controlador.getAnchoArea());
			System.out.println("Alto de area de juego =" + controlador.getAltoArea());
			System.out.println("Nivel =" + controlador.getNivel());
			System.out.println("Salud =" + controlador.getsaludRestante());
			System.out.println("Vidas =" + controlador.getvidasRestantes());
			System.out.println("Puntos =" + controlador.getPuntos());
			System.out.println();


		//Test movimiento Submarino
			System.out.println("PosSubmarino = " + controlador.getSubmarino());
			controlador.moverAbajoSubmarino();
			System.out.println("PosSubmarino = " + controlador.getSubmarino());
			controlador.moverIzquierdaSubmarino();
			System.out.println("PosSubmarino = " + controlador.getSubmarino());
			controlador.moverArribaSubmarino();
			System.out.println("PosSubmarino = " + controlador.getSubmarino());
			controlador.moverDerechaSubmarino();
			System.out.println("PosSubmarino = " + controlador.getSubmarino());
			System.out.println();


		//Test procesos loop
			for (int i = 0; i < 11; i++) {
				System.out.println("PosBarco =  "+ controlador.getBarcos());
				controlador.procesosAutomaticos();
				System.out.println();
			}

			for (int i = 0; i < 2000; i++) {
				controlador.procesosAutomaticos();
			}


			//Test get infos
			System.out.println("Nivel =" + controlador.getNivel());
			System.out.println("Salud =" + controlador.getsaludRestante());
			System.out.println("Vidas =" + controlador.getvidasRestantes());
			System.out.println("Puntos =" + controlador.getPuntos());
			System.out.println();
			


	}

}
