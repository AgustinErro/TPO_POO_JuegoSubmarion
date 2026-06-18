package auxiliares;

public class ContadorGlobal {
	
	private static int totalCargas = 0;
	
    public static int registrarNuevaCarga() {
        totalCargas++;
        return totalCargas;
    }

    // Getters globales por si necesitas saber los totales

    public static int getTotalCargas() {
        return totalCargas;
    }

}
