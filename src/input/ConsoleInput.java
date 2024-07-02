package input;

import core.acciones.Accion;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleInput implements Input{
    private Scanner scanner;

    public ConsoleInput(){
        this.scanner = new Scanner(System.in);
    }

    public Accion jugarTurno(ArrayList<Accion> opciones) {
        int seleccion;
        Accion accion = null;

        while (accion == null) {
            try {
                seleccion = scanner.nextInt();
                accion = opciones.get(seleccion-1);
            } catch (Exception e) {
                System.out.println("opcion invalida!!");
            }
        }

        return accion;
    }

    @Override
    public String ingresarNombre() {
        return scanner.next();
    }

    @Override
    public boolean apuestaTruco() {
        int respuesta = scanner.nextInt();

        if (respuesta == 1) {
            return true;
        }
        return false;
    }
}
