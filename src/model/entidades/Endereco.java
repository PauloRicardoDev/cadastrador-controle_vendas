package model.entidades;

public final class Endereco {

    private String cep;
    private String numeroLocal;
    private String pontoDeReferencia;

    public Endereco() {}
    public Endereco(String cep, String numeroLocal, String pontoDeReferencia) {
        this.cep = cep;
        this.numeroLocal = numeroLocal;
        this.pontoDeReferencia = pontoDeReferencia;
    }
    public String getCep() {
        return cep;
    }
    public String getNumeroLocal() {
        return numeroLocal;
    }
    public String getPontoDeReferencia() {
        return pontoDeReferencia;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setNumeroLocal(String numeroLocal) {
        this.numeroLocal = numeroLocal;
    }

    public void setPontoDeReferencia(String pontoDeReferencia) {
        this.pontoDeReferencia = pontoDeReferencia;
    }

    @Override
    public String toString() {
        return  " " + "\n" +
                "ENDEREÇO ENTREGA: " + "\n" +
                "Cep: " + getCep() + "\n" +
                "Número Local: " + getNumeroLocal() + "\n" +
                "Ponto de referência" + getPontoDeReferencia() + "\n" +
                "";
    }
}
