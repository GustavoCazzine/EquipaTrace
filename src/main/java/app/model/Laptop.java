package app.model;

public class Laptop extends Equipamento implements ManutencaoInterface {
    private String processador;

    public Laptop() {
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public String toString() {
        return super.toString() + ", processador='" + processador + '\'' +
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
