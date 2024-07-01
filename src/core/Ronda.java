package core;


import core.acciones.Accion;
import core.cartas.Carta;
import core.cartas.Mazo;
import core.cartas.Palo;
import input.Input;
import output.Output;

import java.util.ArrayList;

public class Ronda {
    private Input input;
    private Output output;

    private boolean continuarRonda = true;
    private Jugador jugador1;
    private Jugador jugador2;
    private Mazo mazo;
    private int recompenzaTruco = 1;
    private Jugador ganadorPrimeraMano;


    public Ronda(Jugador jugador1, Jugador jugador2, Input input, Output output) {
        this.output = output;
        this.input = input;

        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.mazo = new Mazo();

        jugador1.inicializarEnRonda();
        jugador2.inicializarEnRonda();

        repartirCartas(jugador1);
        repartirCartas(jugador2);
        
        this.jugarRonda();
    }
    
    private void repartirCartas(Jugador jugador) {
        for (int i = 0; i < 3; i++) {
            jugador.recibirCarta(mazo.repartir());
        }
    }


    private void jugarRonda() {
        while (continuarRonda) {
//            this.mano = new Mano(jugador1, jugador2, mazo, input, output);

            Jugador primero = jugador1.isEsTurno() ? jugador1 : jugador2;
            Jugador segundo = jugador1.isEsTurno() ? jugador2 : jugador1;
            this.jugar(primero);
            this.jugar(segundo);

            Carta cartaJugador1 = jugador1.getCartaTirada();
            Carta cartaJugador2 = jugador2.getCartaTirada();

            Jugador ganador = compararCartasTruco(cartaJugador1, cartaJugador2);

            ganador.setTurno(true);
            Jugador perdedor = ganador == jugador1 ? jugador2 :jugador1 ;
            perdedor.setTurno(false);

            output.mostrarResultadoMano(jugador1, jugador2, ganador);
            this.finDeMano(ganador);
        }
    }

    private void finDeMano(Jugador ganador) {
        ganador.addManoGanada();

        if (ganador.getManosGanadasEnRonda() == 0){
            this.setGanadorPrimeraMano(ganador);
        }

        if (ganador.getManosGanadasEnRonda() == 2) {
            ganador.addPuntos(recompenzaTruco);
            ganador.addManoGanada();
            output.anunciarFinDeRondaPorManosGanadas(ganador);
            output.mostrarTablero(jugador1, jugador2);
            this.continuarRonda = false;
        }
    }


    private void jugar(Jugador jugador) {
        ArrayList<Accion> opciones = getOpciones(jugador);
        output.anunciarTurno(jugador);
        output.mostrarOpcionesTurno(opciones, jugador.getCartas());
        Accion accion = input.jugarTurno(opciones);

        switch (accion){
            case TIRAR_CARTA_1 -> {
                jugador.tirarCarta(0);
            }
            case TIRAR_CARTA_2 -> {
                jugador.tirarCarta(1);
            }
            case TIRAR_CARTA_3 -> {
                jugador.tirarCarta(2);
            }
            case TRUCO -> {

            }
        }
    }

    private ArrayList<Accion> getOpciones(Jugador jugador){
        ArrayList <Accion> opciones = new ArrayList<Accion>();
        opciones.add(Accion.TIRAR_CARTA_1);
        opciones.add(Accion.TRUCO);

        int cartasEnMano = jugador.getCartas().size();

        if (cartasEnMano > 1) {
            opciones.add(Accion.TIRAR_CARTA_2);
            if (cartasEnMano > 2) {
                opciones.add(Accion.TIRAR_CARTA_3);
            }
        }


        return  opciones;
    }

    private Jugador compararCartasTruco(Carta carta1, Carta carta2) {
        int valorJugador1 = carta1.getValor();
        int valorJugador2 = carta2.getValor();
        Palo paloJugador1 = carta1.getPalo();
        Palo paloJugador2 = carta2.getPalo();

        int rankingCarta1 = rankingCard(valorJugador1, paloJugador1);
        int rankingCarta2 = rankingCard(valorJugador2, paloJugador2);

        if (rankingCarta1 > rankingCarta2) {
            return jugador1;
        } else if (rankingCarta2 > rankingCarta1) {
            return jugador2;
        } else {
            if (this.getGanadorPrimeraMano() == jugador1) {
                return jugador1;
            } else {
                return jugador2;
            }
        }
    }

    public int rankingCard(int number, Palo palo) {
        switch (number) {
            case 4:
                return 0;
            case 5:
                return 1;
            case 6:
                return 2;
            case 7:
                if (palo == Palo.BASTO || palo == Palo.COPA)
                    return 3;
                if (palo == Palo.ORO)
                    return 10;
                else // espada
                    return 11;
            case 10:
                return 4;
            case 11:
                return 5;
            case 12:
                return 6;
            case 1:
                if (palo == Palo.ORO || palo == Palo.COPA)
                    return 7;
                if (palo == Palo.BASTO)
                    return 12;
                else // espada
                    return 13;
            case 2:
                return 8;
            case 3:
                return 9;
            default:
                return -1; // En caso de número inválido
        }
    }

    public void setGanadorPrimeraMano(Jugador ganador) {
        this.ganadorPrimeraMano = ganador;
    }

    public Jugador getGanadorPrimeraMano() {
        return ganadorPrimeraMano;
    }
}
