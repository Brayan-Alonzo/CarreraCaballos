package backend.estructuras.lista;

public class Lista<T> {

    private int indice = 0;
    private final int numExpansion = 20;
    private Object[] lista = null;

    public Lista() {
        lista = new Object[numExpansion];
    }

    public void add(Object elemento) {
        if (indice < lista.length) {
            lista[indice] = elemento;
            indice++;
        } else {
            expandir();
            add(elemento);
        }
    }

    public void expandir() {
        Object[] expandido = new Object[lista.length + numExpansion];
        System.arraycopy(lista, 0, expandido, 0, lista.length);
        this.lista = expandido;
    }

    public T get(int indice) {
        return (T) lista[indice];
    }

    public int size() {
        return lista.length;
    }
    
}
