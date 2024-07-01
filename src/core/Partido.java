package core;

import input.Input;
import output.Output;

import java.util.Random;

public class Partido {
    public Jugador jugador1;
    public Jugador jugador2;
    private Ronda ronda;
    private boolean partidaActiva;

    Input input;
    Output output;

    public Partido(Input input, Output output) {
        this.input = input;
        this.output = output;

        this.iniciarPartido();
    }

    private void iniciarPartido() {
        this.jugador1 = new Jugador(input, output);
        this.jugador2 = new Jugador(input, output);

        this.determinarQuienComienza();

        this.partidaActiva = true;

        while (partidaActiva) {
            this.iniciarRonda();
            this.checkFinPartida();
        }
    }

    private void determinarQuienComienza(){
        Random random = new Random();
        boolean jugador1Primero = random.nextBoolean();

        if (jugador1Primero){
            jugador1.setTurno(true);
            jugador2.setTurno(false);
        } else{
            jugador2.setTurno(true);
            jugador1.setTurno(false);
        }

        output.anunciarQuienComienza(jugador1, jugador2);
    }

    private void iniciarRonda() {
        this.ronda = new Ronda(jugador1, jugador2, input, output);
    }

    private void checkFinPartida() {
        if (jugador1.getPuntos() >= 30 || jugador2.getPuntos() >= 30) {
            this.partidaActiva = false;
            Jugador ganador = jugador1.getPuntos() >= 30 ? jugador1 : jugador2;
            ganador.setGanadorPartida(true);
        }
    }

    public Jugador getGanador() {
        if (jugador1.isGanador()) {
            return jugador1;
        } else if (jugador2.isGanador()) {
            return jugador2;
        }
        return null;
    }

}
