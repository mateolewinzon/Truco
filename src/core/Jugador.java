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
    private int envido;

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

    public void calcularEnvido() {
        int envido = 0;

        Carta carta1 = null, carta2 = null;
        for (int i = 0; i < cartas.size() - 1; i++) {
            for (int j = i + 1; j < cartas.size(); j++) {
                Carta c1 = cartas.get(i);
                Carta c2 = cartas.get(j);
                if (c1.getPalo() == c2.getPalo()) {
                    carta1 = c1;
                    carta2 = c2;
                    break;
                }
            }
            if (carta1 != null && carta2 != null) {
                break;
            }
        }
        if (carta1 != null && carta2 != null) {
            // Si hay dos cartas del mismo palo
            int valor1 = carta1.getValor();
            int valor2 = carta2.getValor();
            if (valor1 >= 10) valor1 = 0; // Las figuras valen 0 puntos
            if (valor2 >= 10) valor2 = 0; // Las figuras valen 0 puntos
            envido = valor1 + valor2 + 20;
        } else {
            // Si no hay dos cartas del mismo palo, encontrar la carta más alta
            int maxValor = 0;
            for (Carta carta : cartas) {
                int valor = carta.getValor();
                if (valor > maxValor && valor < 10) { // Solo considerar cartas que no sean figuras
                    maxValor = valor;
                }
            }
            envido = maxValor;
        }

        this.envido = envido;
    }

    public int getEnvido(){
    	return this.envido;
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
