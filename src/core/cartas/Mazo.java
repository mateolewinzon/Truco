package core.cartas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mazo {
    private List<Carta> cartas;
    private List<Carta> cartasUsadas;

    public Mazo() {
        this.cartas = new ArrayList<>();
        this.cartasUsadas = new ArrayList<>();
        this.inicializarMazo();
        this.mezclar();
    }

    private void inicializarMazo() {
        for (Palo palo : Palo.values()) {
            for (int valor = 1; valor <= 12; valor++) {
                if (valor != 8 && valor != 9) {
                    cartas.add(new Carta(valor, palo));
                }
            }
        }
    }

    public void mezclar() {
        System.out.println("mezcalr called!");
        Collections.shuffle(cartas);
    }

    public Carta repartir() {
        Carta carta = null;
        for (int i = 0; i < cartas.size(); i++) {
            carta = cartas.get(i);
            if (!carta.isUsada()) {
                carta.setUsada(true);
                cartasUsadas.add(carta);
                cartas.remove(i);
                break;
            }
        }
        return carta;
    }

    public void reiniciar() {
        for (Carta carta : cartasUsadas) {
            carta.setUsada(false);
            cartas.add(carta);
        }
        cartasUsadas.clear();
        mezclar();
    }
}
