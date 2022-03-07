package backend.logicas;

import backend.estructuras.listaEnlazada.ListaEnlazada;
import backend.pojos.Apuesta;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CargaDatos {

    private ListaEnlazada<Apuesta> apuestas = new ListaEnlazada();

    public CargaDatos() {
    }

    public void cargarDatos(String direccionArchivo) {
        try {
            FileReader archivo = new FileReader(direccionArchivo);
            BufferedReader lector = new BufferedReader(archivo);
            String linea = lector.readLine();
            int i = 0;
            while (linea != null) {
                procesarLinea(linea);
                linea = lector.readLine();
            }
            lector.close();
        } catch (FileNotFoundException ex) {
            //
        } catch (IOException ex) {
            //
        }
    }

    public void procesarLinea(String linea) {
        String[] campos = linea.split(",");
        String nombreApostador = campos[0];
        double monto = Double.valueOf(campos[1]);
        int primerLugar = Integer.valueOf(campos[2]);
        int segundoLugar = Integer.valueOf(campos[3]);
        int tercerLugar = Integer.valueOf(campos[4]);
        int cuartoLugar = Integer.valueOf(campos[5]);
        int quintoLugar = Integer.valueOf(campos[6]);
        int sextoLugar = Integer.valueOf(campos[7]);
        int septimoLugar = Integer.valueOf(campos[8]);
        int octavoLugar = Integer.valueOf(campos[9]);
        int novenoLugar = Integer.valueOf(campos[10]);
        int decimoLugar = Integer.valueOf(campos[11]);
        Apuesta apuesta = new Apuesta(nombreApostador, monto, primerLugar, segundoLugar, tercerLugar, cuartoLugar, quintoLugar, sextoLugar, septimoLugar, octavoLugar, novenoLugar, decimoLugar);
        apuestas.agregarFinal(apuesta);
    }

    public ListaEnlazada<Apuesta> getApuestas() {
        return this.apuestas;
    }

}
