package app.service;

import app.model.Equipamento;

import java.util.ArrayList;
import java.util.List;

public class AlmoxarifadoService {
    private List<Equipamento> listaDeEquipamentos = new ArrayList<>();

    public void adicionar(Equipamento e){
        listaDeEquipamentos.add(e);
    }

    public void listarTodos(){
        listaDeEquipamentos.stream()
                .forEach(System.out::println);
    }

    public void transferir(String id, String novaLocalizacao){
        if (!novaLocalizacao.equalsIgnoreCase("Piracicaba") && !novaLocalizacao.equalsIgnoreCase("Campo Largo")){
            System.out.println("Erro: Localização invãlida! Apenas Piracicaba ou Campo largo são permitidos.");
            return;
        }
        listaDeEquipamentos.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .ifPresentOrElse(e -> {
                    e.setLocalizacao(novaLocalizacao);
                    System.out.println("Transferência realizada com sucesso para " + novaLocalizacao);
                },
                    () -> System.out.println("Erro: Equipamento com ID " + id + " não encontrado.")
                );
    }
}
