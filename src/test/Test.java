package test;

import controlador.Controlador;
import gui.VentanaMenu;

public class Test {

	public static void main(String[] args) {
		Controlador controlador = new Controlador();
		new VentanaMenu(controlador);
	}

}
