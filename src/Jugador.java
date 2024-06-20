import java.util.HashSet;
import java.util.Random;

public class Jugador {
    private boolean ganadorPartida = false;
    private int puntos = 0;
    private int manosGanadasEnRonda = 0;
    private boolean tiraPrimero;
    Carta cartaTirada;
//    HashSet<Carta> cartas;

    public int getPuntos(){
        return this.puntos;
    }

    public Carta getCarta() {
        return this.cartaTirada;
    }

    public void tirarCarta(){
        Random random = new Random();
        int randomInt = random.nextInt(10) + 1;
        cartaTirada = new Carta(randomInt);
    }

    public Jugador(boolean tiraPrimero){
        this.inicializarEnRonda(tiraPrimero);
    }

    public void inicializarEnRonda(boolean tiraPrimero){
        this.tiraPrimero = tiraPrimero;
        this.manosGanadasEnRonda = 0;
        this.cartaTirada = null;
//        this.cartas
    }

    public boolean isTiraPrimero() {
        return tiraPrimero;
    }

    public void addPuntos(int puntos){
        this.puntos += puntos;
    }

    public int getManosGanadasEnRonda() {
        return this.manosGanadasEnRonda;
    }

    public void addManoGanada(){
        this.manosGanadasEnRonda += 1;
    }

    public boolean isGanador(){
        return this.isGanador();
    }
}
