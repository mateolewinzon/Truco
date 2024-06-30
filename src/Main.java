import core.Jugador;
import core.Partido;
import input.ConsoleInput;
import input.Input;
import output.ConsoleOutput;
import output.Output;

public class Main {
    public static void main(String[] args) {
        // ---- Interfaz grafica ----
        Input consoleInput = new ConsoleInput();
        Output consoleOutput = new ConsoleOutput();
        // --------------------------

        System.out.println("Iniciando partida de Truco...");
        Partido partido = new Partido(consoleInput, consoleOutput);
        Jugador ganador = partido.getGanador();
        if (ganador != null) {
        System.out.println("¡El ganador es: " + (ganador == partido.jugador1 ? "Jugador 1" : "Jugador 2") + "!");
        } else {
            System.out.println("No hay ganador.");
        }
    }
}
