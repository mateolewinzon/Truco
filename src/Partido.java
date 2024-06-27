public class Partido {
    public Jugador jugador1;
    public Jugador jugador2;
    private Ronda ronda;
    private boolean partidaActiva;

    public Partido() {
        this.iniciarPartido();
    }

    private void iniciarPartido() {
        this.jugador1 = new Jugador(true);
        this.jugador2 = new Jugador(false);
        this.partidaActiva = true;

        while (partidaActiva) {
            this.iniciarRonda();
            this.checkFinPartida();
        }
    }

    private void iniciarRonda() {
        this.ronda = new Ronda(jugador1, jugador2); 
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
