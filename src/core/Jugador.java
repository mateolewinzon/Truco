package core;

import core.acciones.Accion;
import core.cartas.Carta;
import input.Input;
import output.Output;

import java.util.ArrayList;

public class Jugador {
    private boolean ganadorPartida = false;
    private int puntos = 0;
    private int manosGanadasEnRonda = 0;
    private ArrayList<Carta> cartas;
    private Carta cartaTirada;
    private String nombre;

    private boolean esTurno;

    Input input;
    Output output;

    public Jugador(Input input, Output output) {
        this.input = input;
        this.output = output;

        output.solicitarNombre();
        this.nombre = input.ingresarNombre();

        this.cartas = new ArrayList<>();
        this.inicializarEnRonda();
    }

    public String getNombre() {
        return nombre;
    }

    public void inicializarEnRonda() {
        this.manosGanadasEnRonda = 0;
        this.cartaTirada = null;
        this.cartas.clear();
    }

    public void setTurno(boolean esTurno){
        this.esTurno = esTurno;
    }

    public boolean isEsTurno() {
        return esTurno;
    }

    public int getPuntos() {
        return this.puntos;
    }

    public Carta getCartaTirada() {
        return this.cartaTirada;
    }

    public void tirarCarta(int index){
        Carta carta = this.cartas.get(index);
        this.cartaTirada = carta;
        this.cartas.remove(index);
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void recibirCarta(Carta carta) {
        cartas.add(carta);
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
