import java.util.Scanner;

public class Mano {
    Jugador ganador;
    Jugador jugador1;
    Jugador jugador2;

    public Mano(Jugador jugador1, Jugador jugador2){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.iniciarMano();
    }

    private void iniciarMano(){
        Jugador tiraPrimero;
        Jugador tiraSegundo;

        if (jugador1.isTiraPrimero()){
            tiraPrimero = jugador1;
            tiraSegundo = jugador2;
        } else  {
            tiraPrimero = jugador2;
            tiraSegundo = jugador1;
        }

        tiraPrimero.tirarCarta();
        tiraSegundo.tirarCarta();

        int valorPrimero = tiraPrimero.getCarta().getValor();
        ganador = tiraPrimero;
        int valorSegundo = tiraSegundo.getCarta().getValor();

        if (valorSegundo > valorPrimero){
            ganador = tiraSegundo;
        }
    }

    public void setGanador(Jugador ganador) {
        this.ganador = ganador;
    }

    public Jugador getGanador() {
        return ganador;
    }
}
