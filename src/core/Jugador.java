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
    private boolean tiraPrimero;
    private ArrayList<Carta> mano;
    private Carta cartaTirada;
    private String nombre;

    Input input;
    Output output;

    public Jugador(boolean tiraPrimero, Input input, Output output) {
        this.input = input;
        this.output = output;

        output.solicitarNombre();
        this.nombre = input.ingresarNombre();

        this.tiraPrimero = tiraPrimero;
        this.mano = new ArrayList<>();
        this.inicializarEnRonda(tiraPrimero);
    }

    public String getNombre() {
        return nombre;
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

    public void jugar() {
        ArrayList<Accion> opciones = getOpciones();
        output.anunciarTurno(this);
        output.mostrarOpcionesTurno(opciones, mano);
        Accion accion = input.jugarTurno(opciones);

        switch (accion){
            case TIRAR_CARTA_1 -> {
                this.cartaTirada = mano.get(0);
                mano.remove(0);
            }
            case TIRAR_CARTA_2 -> {
                this.cartaTirada = mano.get(1);
                mano.remove(1);
            }
            case TIRAR_CARTA_3 -> {
                this.cartaTirada = mano.get(2);
                mano.remove(1);
            }
        }
    }

    private ArrayList<Accion> getOpciones(){
        ArrayList <Accion> opciones = new ArrayList<Accion>();
        opciones.add(Accion.TIRAR_CARTA_1);

        if (mano.size() > 1) {
            opciones.add(Accion.TIRAR_CARTA_2);
            if (mano.size() > 2) {
                opciones.add(Accion.TIRAR_CARTA_3);
            }
        }


        return  opciones;
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
