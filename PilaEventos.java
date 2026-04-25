public class PilaEventos {

    private EventoInspeccion[] datos;
    private int tope;
    private int capacidad;

    public PilaEventos(int capacidad) {
        this.capacidad = capacidad;
        datos = new EventoInspeccion[capacidad];
        tope = -1;
    }

    public void push(EventoInspeccion e) throws PilaLlenaException {
        if (tope == capacidad - 1) {
            throw new PilaLlenaException("Pila llena");
        }
        datos[++tope] = e;
    }

    public EventoInspeccion pop() throws PilaVaciaException {
        if (isEmpty()) {
            throw new PilaVaciaException("Pila vacía");
        }
        return datos[tope--];
    }

    public EventoInspeccion peek() throws PilaVaciaException {
        if (isEmpty()) {
            throw new PilaVaciaException("Pila vacía");
        }
        return datos[tope];
    }

    public boolean isEmpty() {
        return tope == -1;
    }

    public int size() {
        return tope + 1;
    }

    public void mostrarDesdeElTope() {
        for (int i = tope; i >= 0; i--) {
            System.out.println(datos[i]);
        }
    }
}