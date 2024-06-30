package core.cartas;

public class Carta {
    private int valor;
    private Palo palo;
    private boolean usada;

    public Carta(int valor, Palo palo) {
        this.valor = valor;
        this.palo = palo;
        this.usada = false;
    }

    public int getValor() {
        return valor;
    }

    public Palo getPalo() {
        return palo;
    }

    public boolean isUsada() {
        return usada;
    }

    public void setUsada(boolean usada) {
        this.usada = usada;
    }

    @Override
    public String toString() {
        return valor + " de " + palo;
    }
}
