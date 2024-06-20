public class Partido {
    Jugador jugador1;
    Jugador jugador2;
    Ronda ronda;
    Jugador mano = jugador1;
    boolean partidaActiva;

    public Partido(){
        this.iniciarPartido();
    }

    private void iniciarPartido(){
        this.jugador1 = new Jugador(true);
        this.jugador2 = new Jugador(false);
        this.partidaActiva = true;

        while (partidaActiva){
            this.ronda = new Ronda(jugador1, jugador2);
            this.checkFinPartida();
        }
    }

    private void checkFinPartida(){
        if (jugador1.isGanador() || jugador2.isGanador()){
            this.partidaActiva = false;
        }
    }
}
