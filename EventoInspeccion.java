import java.time.LocalDateTime;

public class EventoInspeccion {
    private int id;
    private Pozo pozo;
    private TipoEvento tipoEvento;
    private String descripcion;
    private LocalDateTime fechaHora;

    public EventoInspeccion(int id, Pozo pozo, TipoEvento tipoEvento,
                           String descripcion, LocalDateTime fechaHora) {
        this.id = id;
        this.pozo = pozo;
        this.tipoEvento = tipoEvento;
        this.descripcion = descripcion;
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                "\nPozo: " + pozo.getCodigo() +
                "\nMunicipio: " + pozo.getMunicipio() +
                "\nEvento: " + tipoEvento +
                "\nDescripcion: " + descripcion +
                "\nFecha: " + fechaHora + "\n";
    }
}