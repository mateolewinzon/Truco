package output;

import core.cartas.Carta;
import core.Jugador;
import core.acciones.Accion;

import java.util.ArrayList;

public class ConsoleOutput implements Output {
    @Override
    public void anunciarQuienComienza(Jugador jugador1, Jugador jugador2) {
        String nombre = jugador1.isEsTurno() ? jugador1.getNombre() : jugador2.getNombre();
        emptyLine();
        print("Por sorteo, comienza jugando "+nombre);
    }

    @Override
    public void anunciarInicioDeRonda() {
        print("Nueva ronda. Se mezcla y se reparten cartas.");
    }

    @Override
    public void mostrarOpcionesTurno(ArrayList<Accion> opciones, ArrayList<Carta> cartas) {
        if (opciones.contains(Accion.TIRAR_CARTA_1)) {
            print("1. Tirar "+cartas.get(0).toString());
            if (opciones.contains(Accion.TIRAR_CARTA_2)) {
                print("2. Tirar "+cartas.get(1).toString());
                if (opciones.contains(Accion.TIRAR_CARTA_3)) {
                    print("3. Tirar "+cartas.get(2).toString());
                }
            }
        }

        if (opciones.contains(Accion.TRUCO)) {
            print("4. Cantar truco");
        }

        if (opciones.contains(Accion.ENVIDO)) {
            print("5. Cantar envido");
        }
        emptyLine();
    }

    @Override
    public void mostrarTablero(Jugador jugador1, Jugador jugador2) {
        System.out.flush();
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
        emptyLine();
        print("Elegí una opción:");
    }

    @Override
    public void mostrarResultadoMano(Jugador jugador1, Jugador jugador2, Jugador ganador) {
        emptyLine();
        print("Carta de "+ jugador1.getNombre() + ": "  + jugador1.getCartaTirada());
        print("Carta de "+ jugador2.getNombre() + ": "  + jugador2.getCartaTirada());
        emptyLine();
        print("Ganador de la mano: " + (ganador == jugador1 ? jugador1.getNombre() : jugador2.getNombre()));
        emptyLine();
    }

    @Override
    public void anunciarFinDeRondaPorManosGanadas(Jugador ganador) {
        String nombre = ganador.getNombre();
        emptyLine();
        print(nombre + " ganó dos manos. Se finaliza la ronda.");
        this.anunciarInicioDeRonda();
        emptyLine();
    }

    @Override
    public void mostrarOpcionesTruco() {
        emptyLine();
        print("Respondé a la apuesta.");
        emptyLine();
        print("1. Quiero");
        print("2. No quiero");
        emptyLine();
    }
    
    @Override
    public void mostrarOpcionesEnvido() {
        emptyLine();
        print("Respondé a la apuesta.");
        emptyLine();
        print("1. Quiero");
        print("2. No quiero");
        emptyLine();
    }
    
    @Override
    public void anunciarGanadorEnvido(Jugador ganador) {
    	 String nombre = ganador.getNombre();
         emptyLine();
         print(nombre + " ganó el envido.");
    }

    private void print(String text){
        System.out.println(text);
    }

    private void emptyLine(){
        System.out.println();
    }

}
