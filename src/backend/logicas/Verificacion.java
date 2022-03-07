package backend.logicas;

import backend.estructuras.listaEnlazada.ListaEnlazada;
import backend.estructuras.listaEnlazada.Nodo;
import backend.pojos.Apuesta;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Verificacion {

    private final ListaEnlazada<Apuesta> apuestas;
    private String rechazados = "";

    public Verificacion(ListaEnlazada<Apuesta> apuestas) {
        this.apuestas = apuestas;
    }

    public void verificar() {
        long tI, tF, t;
        tI = System.currentTimeMillis();
        Nodo nodo = this.apuestas.getInicio();

        boolean incorrecto;
        do {
            Apuesta apuesta = (Apuesta) nodo.getValor();
            incorrecto = verificarCampos(apuesta.getPosiciones());
            if (incorrecto) {
                this.rechazados += apuesta + "\n";
                cambiarLaterales(nodo);
            }

            nodo = nodo.getSiguiente();
        } while (nodo != null);

        tF = System.currentTimeMillis();
        System.out.println("Tiempo de verificacion: " + (tF - tI) + " milisegundos");
    }

    public void cambiarLaterales(Nodo nodo) {
        Nodo siguiente;
        Nodo anterior;
        anterior = nodo.getAnterior();
        siguiente = nodo.getSiguiente();
        try {
            anterior.setSiguiente(siguiente);
            siguiente.setAnterior(anterior);
        } catch (NullPointerException ex) {
            if (siguiente == null) {
                anterior.setSiguiente(siguiente);
                apuestas.setUltimo(anterior);
            } else {
                siguiente.setAnterior(anterior);
                apuestas.setPrimero(siguiente);
            }
        }
    }

    public boolean verificarCampos(int[] arreglo) { //Peor de los casos 9 * 10 iteraciones
        boolean incorrecto = false;
        int cont = 0;
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length; j++) {
                if (arreglo[i] == arreglo[j]) {
                    cont++;
                }
                if (cont > 1) {
                    incorrecto = true;
                    break;
                }
            }
            if (cont > 1) {
                break;
            }
            cont = 0;
        }
        return incorrecto;
    }

    public static boolean guardarArchivo(File archivo, String contenido) {
        boolean guardado = true;
        archivo = new File(archivo.getAbsolutePath() + ".csv");
        FileOutputStream salida;
        try {
            salida = new FileOutputStream(archivo);
            byte[] bytxt = contenido.getBytes();
            salida.write(bytxt);

        } catch (FileNotFoundException ex) {
            guardado = false;
        } catch (IOException ex) {
            guardado = false;
        }
        return guardado;
    }

    public String getRechazados() {
        return this.rechazados;
    }

}
