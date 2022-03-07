package backend.pojos;

public class Apuesta {

    private final String nombreApostador;
    private final double monto;
    private final int[] posiciones;
    private int puntos = 0;

    public Apuesta(String nombreApostador, double monto, int primerLugar, int segundoLugar, int tercerLugar, int cuartoLugar, int quintoLugar, int sextoLugar, int septimoLugar, int octavoLugar, int novenoLugar, int decimoLugar) {
        this.nombreApostador = nombreApostador;
        this.monto = monto;
        int aux[] = {primerLugar, segundoLugar, tercerLugar, cuartoLugar, quintoLugar, sextoLugar, septimoLugar, octavoLugar, novenoLugar, decimoLugar};
        this.posiciones = aux;
    }

    public String getNombreApostador() {
        return nombreApostador;
    }

    public double getMonto() {
        return monto;
    }

    public int[] getPosiciones() {
        return posiciones;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String[] getResultado() {
        String[] resultados = {this.nombreApostador, this.puntos + ""};
        return resultados;
    }

    @Override
    public String toString() {
        return nombreApostador + "," + monto + "," + posiciones[0] + "," + posiciones[1] + "," + posiciones[2] + "," + posiciones[3] + "," + posiciones[4] + "," + posiciones[5] + "," + posiciones[6] + "," + posiciones[7] + "," + posiciones[8] + "," + posiciones[9];
    }

}
