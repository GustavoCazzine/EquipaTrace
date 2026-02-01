package app.model;

public enum Localizacao {
    PIRACICABA("piracicaba"),
    CAMPO_LARGO("campo largo");

    private String nomeFormatado;

    Localizacao(String nomeFormatado){
        this.nomeFormatado = nomeFormatado;
    }

    public String getNomeFormatado(){
        return nomeFormatado;
    }
}
