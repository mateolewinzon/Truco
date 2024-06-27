public class Mano {
    private Jugador ganador;
    private Jugador jugador1;
    private Jugador jugador2;
    private Mazo mazo;
    private Jugador ganadorPrimeraMano;

    public Mano(Jugador jugador1, Jugador jugador2, Mazo mazo) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.mazo = mazo;
        this.jugarMano();
    }
    
    public Jugador getGanador() {
        return ganador;
    }

    public void setGanadorPrimeraMano(Jugador ganador) {
        this.ganadorPrimeraMano = ganador;
    }

    public Jugador getGanadorPrimeraMano() {
        return ganadorPrimeraMano;
    }

    private void jugarMano() {
        jugador1.tirarCarta();
        jugador2.tirarCarta();

        Carta cartaJugador1 = jugador1.getCarta();
        Carta cartaJugador2 = jugador2.getCarta();

        ganador = compararCartasTruco(cartaJugador1, cartaJugador2);

        System.out.println("Carta de Jugador 1: " + cartaJugador1);
        System.out.println("Carta de Jugador 2: " + cartaJugador2);
        System.out.println("Ganador de la mano: " + (ganador == jugador1 ? "Jugador 1" : "Jugador 2"));
    }

    private Jugador compararCartasTruco(Carta carta1, Carta carta2) {
        int valorJugador1 = carta1.getValor();
        int valorJugador2 = carta2.getValor();
        String paloJugador1 = carta1.getPalo();
        String paloJugador2 = carta2.getPalo();

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

    public int rankingCard(int number, String stick) {
        switch (number) {
            case 4:
                return 0;
            case 5:
                return 1;
            case 6:
                return 2;
            case 7:
                if (stick.equals("basto") || stick.equals("copa"))
                    return 3;
                if (stick.equals("oro"))
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
                if (stick.equals("oro") || stick.equals("copa"))
                    return 7;
                if (stick.equals("basto"))
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
}
