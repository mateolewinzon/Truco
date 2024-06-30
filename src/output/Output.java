package output;

import core.cartas.Carta;
import core.Jugador;
import core.acciones.Accion;

import java.util.ArrayList;

public interface Output {
    void mostrarOpcionesTurno(ArrayList<Accion> opciones, ArrayList<Carta> cartas);
    void mostrarTablero(Jugador jugador1, Jugador jugador2);
    void solicitarNombre();
    void anunciarTurno(Jugador jugador);
    void mostrarResultadoMano(Jugador jugador1, Jugador jugador2, Jugador ganador);
}
