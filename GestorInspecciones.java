public class GestorInspecciones {

    private PilaEventos pila;
    private PilaEventos undo;
    private String ultimaOperacion;

    public GestorInspecciones() {
        pila = new PilaEventos(100);
        undo = new PilaEventos(100);
    }

    public void registrarEvento(EventoInspeccion e) {
        try {
            pila.push(e);
            ultimaOperacion = "PUSH";
        } catch (PilaLlenaException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void revisarUltimo() {
        try {
            System.out.println(pila.peek());
        } catch (PilaVaciaException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void retirarUltimo() {
        try {
            EventoInspeccion e = pila.pop();
            undo.push(e);
            ultimaOperacion = "POP";
            System.out.println("Evento retirado:\n" + e);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deshacerUltimaAccion() {
        try {
            if ("PUSH".equals(ultimaOperacion)) {
                pila.pop();
                System.out.println("Se deshizo PUSH");
            } else if ("POP".equals(ultimaOperacion)) {
                EventoInspeccion e = undo.pop();
                pila.push(e);
                System.out.println("Se deshizo POP");
            } else {
                System.out.println("Nada que deshacer");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void listarEventos() {
        pila.mostrarDesdeElTope();
    }

    public void tamaño() {
        System.out.println("Cantidad: " + pila.size());
    }
}