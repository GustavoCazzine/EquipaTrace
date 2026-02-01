package app.model;

abstract class Equipamento {
    private String id;
    private String nome;
    private String marca;
    private String localizacao;

    public Equipamento(String id, String nome, String marca, String localizacao) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.localizacao = localizacao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    @Override
    public String toString() {
        return "Equipamento{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", marca='" + marca + '\'' +
                ", localizacao='" + localizacao + '\'';
    }
}
