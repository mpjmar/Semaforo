public class App {
	public static final String RESET = "\u001B[0m";
	public static final String RED = "\u001B[31m";
	public static final String YELLOW = "\u001B[33m";
	public static final String GREEN = "\u001B[32m";
	public static final String CLEAR_SCREEN = "\033[H\033[2J";

	public static int cambiaEstado(int estado) {
		while (estado <= 4)
			estado = estado == 4 ? 1 : estado + 1;
		return (estado);
	}

    public static void main(String[] args) throws Exception {

		String titulo = "SIMULADOR SEMÁFORO";
		int longTitulo = titulo.length();
		String color, nomColor = "", mensaje;
		int estado = 0, tiempo, longMensaje;
		
		while (true) {
			//System.out.println(CLEAR_SCREEN);
			estado = cambiaEstado(estado);
			switch (estado) {
				case 1:
					color = GREEN;
					nomColor = "VERDE";
					tiempo = 400;
					mensaje = "¡Puedes avanzar!";
					longMensaje = mensaje.length();
					break;
				case 2:
					color = YELLOW;
					nomColor = "AMARILLO";
					tiempo = 200;
					mensaje = "Precaución...";
					longMensaje = mensaje.length();
					break;
				case 3:
					color = RED;
					nomColor = "ROJO";
					tiempo = 500;
					mensaje = "¡Detente!";
					longMensaje = mensaje.length();
					break;
				default:
					System.out.println("Estado inválido.");
					color = RESET;
					tiempo = 0;
					mensaje = "";
					longMensaje = 0;
					break;
			}

			System.out.printf("""
				╔══════════════════════════════════╗
				║%s║
				╠══════════════════════════════════╣
				""",
				String.format("%" + (34 - longTitulo) / 2 + "s%s%" + (34 - longTitulo) / 2 + "s", "", titulo, ""));

			System.out.printf("""
				║ Estado actual: %-10s10s║
				║ Tiempo restante: %3d%3s%15s║
					""",
					String.format(color + nomColor + RESET), "",
					tiempo, String.format(color + "s" + RESET), "");

			System.out.printf("""
				╠══════════════════════════════════╣
				║%s║
				╚══════════════════════════════════╝
					""",
				String.format(color + "%" + (34 - longMensaje) / 2 + "%s%" + (34 - longMensaje) / 2 + "s" + RESET, "", mensaje, ""));

			Thread.sleep(tiempo);

		}
	}
}
