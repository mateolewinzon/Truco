public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando partida de Truco...");
        Partido partido = new Partido();
        Jugador ganador = partido.getGanador();
        if (ganador != null) {
        System.out.println("¡El ganador es: " + (ganador == partido.jugador1 ? "Jugador 1" : "Jugador 2") + "!");
        } else {
            System.out.println("No hay ganador.");
        }
    }
}
