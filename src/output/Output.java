package output;

import core.cartas.Carta;
import core.Jugador;
import core.acciones.Accion;

import java.util.ArrayList;

public interface Output {
    void anunciarQuienComienza(Jugador jugador1, Jugador jugador2);
    void anunciarInicioDeRonda();
    void mostrarOpcionesTurno(ArrayList<Accion> opciones, ArrayList<Carta> cartas);
    void mostrarTablero(Jugador jugador1, Jugador jugador2);
    void solicitarNombre();
    void anunciarTurno(Jugador jugador);
    void mostrarResultadoMano(Jugador jugador1, Jugador jugador2, Jugador ganador);
    void anunciarFinDeRondaPorManosGanadas(Jugador ganador);
    void mostrarOpcionesTruco();
}
