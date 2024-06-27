public class Carta {
    private int valor;
    private String palo;
    private boolean usada;

    public Carta(int valor, String palo) {
        this.valor = valor;
        this.palo = palo;
        this.usada = false;
    }

    public int getValor() {
        return valor;
    }

    public String getPalo() {
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
