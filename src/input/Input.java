package input;

import core.acciones.Accion;

import java.util.ArrayList;

public interface Input {
    Accion jugarTurno(ArrayList<Accion> opciones);
    String ingresarNombre();
    boolean apuestaTruco();
    boolean apuestaEnvido();
}
