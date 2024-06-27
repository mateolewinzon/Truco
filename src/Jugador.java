import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jugador {
    private boolean ganadorPartida = false;
    private int puntos = 0;
    private int manosGanadasEnRonda = 0;
    private boolean tiraPrimero;
    private List<Carta> mano;
    private Carta cartaTirada;

    public Jugador(boolean tiraPrimero) {
        this.tiraPrimero = tiraPrimero;
        this.mano = new ArrayList<>();
        this.inicializarEnRonda(tiraPrimero);
    }

    public void inicializarEnRonda(boolean tiraPrimero) {
        this.tiraPrimero = tiraPrimero;
        this.manosGanadasEnRonda = 0;
        this.cartaTirada = null; 
    }

    public int getPuntos() {
        return this.puntos;
    }

    public Carta getCarta() {
        return this.cartaTirada;
    }

    public void recibirCarta(Carta carta) {
        mano.add(carta);
    }

    public void tirarCarta() {
        Random random = new Random();
        int index = random.nextInt(mano.size());
        cartaTirada = mano.get(index);
        mano.remove(index);
    }

    public boolean isTiraPrimero() {
        return tiraPrimero;
    }

    public void addPuntos(int puntos) {
        this.puntos += puntos;
    }

    public int getManosGanadasEnRonda() {
        return this.manosGanadasEnRonda;
    }

    public void addManoGanada() {
        this.manosGanadasEnRonda += 1;
    }

    public boolean isGanador() {
        return this.ganadorPartida;
    }

    public void setGanadorPartida(boolean ganador) {
        this.ganadorPartida = ganador;
    }
}
