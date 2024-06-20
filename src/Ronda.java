public class Ronda {
    Mano mano;
    Boolean continuarRonda = true;
    Jugador jugador1;
    Jugador jugador2;
    int valorRonda = 1;

    public Ronda(Jugador jugador1, Jugador jugador2){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;

        jugador1.inicializarEnRonda(true);
        jugador2.inicializarEnRonda(false);

        this.crearRondas();
    }

    private void crearRondas(){
        while (continuarRonda) {
            this.mano = new Mano(jugador1, jugador2);
            Jugador ganadorMano = this.mano.getGanador();
            ganadorMano.addPuntos(valorRonda);
            ganadorMano.addManoGanada();

            this.checkFinRonda(ganadorMano);
        }
    }

    private void checkFinRonda(Jugador ultimoGanador) {
        boolean fin = false;

        if (ultimoGanador.getManosGanadasEnRonda() == 2) {
            fin = true;
        }

        this.continuarRonda = !fin;
    }
}
