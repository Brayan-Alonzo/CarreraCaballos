package backend.logicas;

import backend.estructuras.listaEnlazada.ListaEnlazada;
import backend.estructuras.listaEnlazada.Nodo;
import backend.pojos.Apuesta;

public class Ordenamiento {

    private ListaEnlazada<Apuesta> apuestas;

    public Ordenamiento(ListaEnlazada<Apuesta> apuestas) {
        this.apuestas = apuestas;
    }

    public void ordenarPorPuntos() {
        long tI, tF, t;
        tI = System.currentTimeMillis();
        boolean comparar;

        Nodo actual = this.apuestas.getInicio();
        Nodo aux;
        do {
            aux = actual.getSiguiente();
            do {
                try {
                    Nodo anterior = actual.getAnterior();
                    if (((Apuesta) actual.getValor()).getPuntos() > ((Apuesta) anterior.getValor()).getPuntos()) {
                        if (anterior.getAnterior() != null) {
                            anterior.getAnterior().setSiguiente(actual);
                        }
                        if (actual.getSiguiente() != null) {
                            actual.getSiguiente().setAnterior(anterior);
                        }
                        anterior.setSiguiente(actual.getSiguiente());
                        actual.setAnterior(anterior.getAnterior());
                        actual.setSiguiente(anterior);
                        anterior.setAnterior(actual);
                        comparar = true;
                    } else {
                        comparar = false;
                    }
                } catch (NullPointerException ex) {
                    this.apuestas.setPrimero(actual);
                    comparar = false;
                }
            } while (comparar);

            actual = aux;
        } while (actual != null);
        tF = System.currentTimeMillis();
        System.out.println("Tiempo para ordenar por puntos: " + (tF - tI) + " milisegundos");
    }

    public void ordenarAlfabeticamente() {
        long tI, tF, t;
        tI = System.currentTimeMillis();
        boolean comparar;

        Nodo actual = this.apuestas.getInicio();
        Nodo aux;
        do {
            aux = actual.getSiguiente();
            do {
                try {
                    Nodo anterior = actual.getAnterior();
                    if (((Apuesta) actual.getValor()).getNombreApostador().compareTo(((Apuesta) anterior.getValor()).getNombreApostador()) < 0) {
                        if (anterior.getAnterior() != null) {
                            anterior.getAnterior().setSiguiente(actual);
                        }
                        if (actual.getSiguiente() != null) {
                            actual.getSiguiente().setAnterior(anterior);
                        }
                        anterior.setSiguiente(actual.getSiguiente());
                        actual.setAnterior(anterior.getAnterior());
                        actual.setSiguiente(anterior);
                        anterior.setAnterior(actual);
                        comparar = true;
                    } else {
                        comparar = false;
                    }
                } catch (NullPointerException ex) {
                    this.apuestas.setPrimero(actual);
                    comparar = false;
                }
            } while (comparar);

            actual = aux;
        } while (actual != null);
        tF = System.currentTimeMillis();
        System.out.println("Tiempo para ordenar alfabeticamente: " + (tF - tI) + " milisegundos");
    }

}
