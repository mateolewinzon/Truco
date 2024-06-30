package output;

import core.cartas.Carta;
import core.Jugador;
import core.acciones.Accion;

import java.util.ArrayList;

public class ConsoleOutput implements Output {
    @Override
    public void mostrarOpcionesTurno(ArrayList<Accion> opciones, ArrayList<Carta> cartas) {
        if (opciones.contains(Accion.TIRAR_CARTA_1)) {
            print("1. "+cartas.get(0).toString());
            if (opciones.contains(Accion.TIRAR_CARTA_2)) {
                print("2. "+cartas.get(1).toString());
                if (opciones.contains(Accion.TIRAR_CARTA_3)) {
                    print("3. "+cartas.get(2).toString());
                }
            }
        }
    }

    @Override
    public void mostrarTablero(Jugador jugador1, Jugador jugador2) {
        print("-- Puntajes --");
        print(jugador1.getNombre() + ": " + jugador1.getPuntos()) ;
        print(jugador2.getNombre() + ": " + jugador2.getPuntos()) ;
        emptyLine();
    }

    @Override
    public void solicitarNombre() {
        emptyLine();
        print("Ingrese el nombre del jugador");
    }

    @Override
    public void anunciarTurno(Jugador jugador) {
        emptyLine();
        print("Turno de "+jugador.getNombre());
        print("Elegí una opción:");
    }

    @Override
    public void mostrarResultadoMano(Jugador jugador1, Jugador jugador2, Jugador ganador) {
        emptyLine();
        print("Carta de "+ jugador1.getNombre() + ": "  + jugador1.getCarta());
        print("Carta de "+ jugador2.getNombre() + ": "  + jugador2.getCarta());
        emptyLine();
        print("Ganador de la mano: " + (ganador == jugador1 ? jugador1.getNombre() : jugador2.getNombre()));
        emptyLine();
    }

    private void print(String text){
        System.out.println(text);
    }

    private void emptyLine(){
        System.out.println();
    }

}
