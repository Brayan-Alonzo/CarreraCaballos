package backend.logicas;

import backend.estructuras.listaEnlazada.ListaEnlazada;
import backend.estructuras.listaEnlazada.Nodo;
import backend.pojos.Apuesta;

public class Resultados {

    private final ListaEnlazada<Apuesta> apuestas;
    private final int[] resultados;

    public Resultados(ListaEnlazada<Apuesta> apuestas, int[] resultados) {
        this.apuestas = apuestas;
        this.resultados = resultados;
    }

    public void procesar() {
        long tI, tF, t;
        tI = System.currentTimeMillis();
        Nodo nodo = this.apuestas.getInicio();

        do {
            calcularPuntos((Apuesta) nodo.getValor());
            nodo = nodo.getSiguiente();
        } while (nodo != null);
        tF = System.currentTimeMillis();
        System.out.println("Tiempo para calcular resultados: " + (tF - tI) + " milisegundos");
    }

    private void calcularPuntos(Apuesta apuesta) {
        int puntos = 0;
        int max = 10;

        int[] misPosiciones = apuesta.getPosiciones();
        for (int i = 0; i < this.resultados.length; i++) {
            if (this.resultados[i] == misPosiciones[i]) {
                puntos += max - i;
            }
        }
        apuesta.setPuntos(puntos);
    }

    public ListaEnlazada<Apuesta> getApuestasResultados() {
        return apuestas;
    }
}
