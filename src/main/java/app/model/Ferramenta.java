package app.model;

public class Ferramenta extends Equipamento implements ManutencaoInterface {
    private double voltagem;

    public Ferramenta(String id, String nome, String marca, String localizacao, double voltagem){
        super(id, nome, marca, localizacao);
        this.voltagem = voltagem;
    }

    public double getVoltagem() {
        return voltagem;
    }

    public void setVoltagem(double voltagem) {
        this.voltagem = voltagem;
    }

    @Override
    public String toString() {
        return super.toString() + ", voltagem=" + voltagem +
                '}';
    }

    @Override
    public void realizarManutencao(){

    }

    @Override
    public String obterDetalhes(){
        return toString();
    }
}
