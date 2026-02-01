package app.model;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

// 1. Diz que vamos usar um campo extra para diferenciar as classes
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "tipo" // Esse campo vai aparecer no JSON!
)
// 2. Mapeia os valores desse campo para as classes Java
@JsonSubTypes({
        @JsonSubTypes.Type(value = Ferramenta.class, name = "Ferramenta"),
        @JsonSubTypes.Type(value = Laptop.class, name = "Laptop")
})

public abstract class Equipamento {
    private String id;
    private String nome;
    private String marca;
    private String localizacao;

    public Equipamento() {
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
