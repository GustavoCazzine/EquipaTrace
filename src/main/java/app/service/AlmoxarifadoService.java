package app.service;

import app.model.Equipamento;
import app.model.Localizacao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AlmoxarifadoService {
    PersistenciaService persistencia = new PersistenciaService();
    private List<Equipamento> listaDeEquipamentos = new ArrayList<>();

    public AlmoxarifadoService() {
        this.listaDeEquipamentos = persistencia.carregarDados();
    }

    public void adicionar(Equipamento e){
        listaDeEquipamentos.add(e);
    }

    public void listarTodos(){
        listaDeEquipamentos.stream()
                .forEach(System.out::println);
    }

    public void transferir(String id, Localizacao novaLocalizacao){
        listaDeEquipamentos.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .ifPresentOrElse(e -> {
                    e.setLocalizacao(novaLocalizacao);
                    e.setUltimaMovimentacao(LocalDateTime.now());
                    System.out.println("Transferência realizada com sucesso para " + novaLocalizacao);
                },
                    () -> System.out.println("Erro: Equipamento com ID " + id + " não encontrado.")
                );
    }

    public void salvarDados(){
        persistencia.salvarDados(listaDeEquipamentos);
    }

    public List<Equipamento> lerDados(){
        return persistencia.carregarDados();
    }
}
