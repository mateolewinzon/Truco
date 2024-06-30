package core;


import core.cartas.Mazo;
import output.Output;

public class Ronda {
    private Output output;

    private Mano mano;
    private boolean continuarRonda = true;
    private Jugador jugador1;
    private Jugador jugador2;
    private Mazo mazo;

    public Ronda(Jugador jugador1, Jugador jugador2, Output output) {
        this.output = output;

        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.mazo = new Mazo();

        jugador1.inicializarEnRonda(true);
        jugador2.inicializarEnRonda(false);

        repartirCartas(jugador1);
        repartirCartas(jugador2);
        
        this.jugarRondas();
    }
    
    private void repartirCartas(Jugador jugador) {
        for (int i = 0; i < 3; i++) {
            jugador.recibirCarta(mazo.repartir());
        }
    }


    private void jugarRondas() {
        while (continuarRonda) {
            this.mano = new Mano(jugador1, jugador2, mazo, output);
            Jugador ganadorMano = this.mano.getGanador();

            ganadorMano.addPuntos(1);
            ganadorMano.addManoGanada();

            output.mostrarTablero(jugador1, jugador2);

            this.checkFinRonda(ganadorMano);
        }
    }

    private void checkFinRonda(Jugador ultimoGanador) {
        if (ultimoGanador.getManosGanadasEnRonda() == 2) {
            this.continuarRonda = false;
        }
    }
}
