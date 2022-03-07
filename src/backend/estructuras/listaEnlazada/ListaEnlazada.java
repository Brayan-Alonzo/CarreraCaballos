package backend.estructuras.listaEnlazada;

public class ListaEnlazada<T> {

    private Nodo<T> primero;
    private Nodo<T> ultimo;

    public void buscar(T valor) {
        int contador = 0;
        boolean encontrado = false;
        Nodo<T> nodo = primero;
        do {
            if (valor.equals(nodo.getValor())) {
                encontrado = true;
            }
            nodo = nodo.getSiguiente();
            contador++;
        } while (nodo != null && encontrado != true);

        if (encontrado) {
            System.out.println("Se encontro. Pasos: " + contador);
        } else {
            System.out.println("No se encontro. Pasos: " + contador);
        }
    }

    public void eliminar(T valor) {
        int contador = 0;
        boolean encontrado = false;
        Nodo<T> nodo = primero;
        do {
            if (valor.equals(nodo.getValor())) {
                encontrado = true;
                nodo.getAnterior().setSiguiente(nodo.getSiguiente());
                nodo.getSiguiente().setAnterior(nodo.getAnterior());
            }
            nodo = nodo.getSiguiente();
            contador++;
        } while (nodo != null && encontrado != true);

        if (encontrado) {
            System.out.println("Se elimino. Pasos: " + contador);
        } else {
            System.out.println("No se encontro, No se elemino. Pasos: " + contador);
        }
    }

    public void agregarInicio(T valor) {
        if (primero == null) {
            primero = new Nodo<>(valor);
            ultimo = primero;
        } else {
            Nodo<T> aux = primero;
            primero = new Nodo<>(valor);
            aux.setAnterior(primero);
            primero.setSiguiente(aux);
        }
    }

    public void agregarFinal(T valor) {
        if (primero == null) {
            primero = new Nodo<>(valor);
            ultimo = primero;
        } else {
            Nodo<T> aux = ultimo;
            ultimo = new Nodo<>(valor);
            aux.setSiguiente(ultimo);
            ultimo.setAnterior(aux);
        }
    }

    public void imprimirInicioAFinal() {
        System.out.println("Impresion I a F");
        Nodo<T> nodo = primero;
        do {
            System.out.println("-" + nodo.getValor());
            nodo = nodo.getSiguiente();
        } while (nodo != null);
    }

    public Nodo getInicio() {
        return this.primero;
    }
    
    public Nodo getFinal(){
        return this.ultimo;
    }

    public void imprimirFinalAInicio() {
        System.out.println("Impresion F a I");
        Nodo<T> nodo = ultimo;
        do {
            System.out.println("-" + nodo.getValor());
            nodo = nodo.getAnterior();
        } while (nodo != null);
    }
    
    public void concatenarLista(ListaEnlazada<T> lista){
        if (primero == null) {
            primero = lista.getInicio();
            ultimo = lista.getFinal();
        }else{
            ultimo.setSiguiente(lista.primero);
            lista.primero.setAnterior(ultimo);
            this.ultimo = lista.getFinal();
        }
    }

    public void setPrimero(Nodo<T> primero) {
        this.primero = primero;
    }

    public void setUltimo(Nodo<T> ultimo) {
        this.ultimo = ultimo;
    }
    
    public void vaciar(){
        this.primero = null;
        this.ultimo = null;
    }
    
    public boolean estaVacia(){
        return this.primero == null;
    }

}
