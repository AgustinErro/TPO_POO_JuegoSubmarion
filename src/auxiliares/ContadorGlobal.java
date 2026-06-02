package auxiliares;

public class ContadorGlobal {
	
	private static int totalBarcos = 0;
	private static int totalCargas = 0;
	
	// Ahora suma 1 y devuelve el número exacto que generó
    public static int registrarNuevoBarco() {
        totalBarcos++;
        return totalBarcos; 
    }

    public static int registrarNuevaCarga() {
        totalCargas++;
        return totalCargas;
    }

    // Getters globales por si necesitas saber los totales
    public static int getTotalBarcos() {
        return totalBarcos;
    }

    public static int getTotalCargas() {
        return totalCargas;
    }

}
