public class Pozo {
    private String codigo;
    private String municipio;
    private String operador;

    public Pozo(String codigo, String municipio, String operador) {
        this.codigo = codigo;
        this.municipio = municipio;
        this.operador = operador;
    }

    public String getCodigo() { return codigo; }
    public String getMunicipio() { return municipio; }
    public String getOperador() { return operador; }
}