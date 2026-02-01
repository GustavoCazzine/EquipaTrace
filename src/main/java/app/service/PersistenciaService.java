package app.service;

import app.model.Equipamento;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaService {
    private ObjectMapper mapper = new ObjectMapper();

    public PersistenciaService(){
        mapper.registerModule(new JavaTimeModule()); // Registra o módulo de datas
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); // Para salvar como "2026-02-01" e não números loucos
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public void salvarDados(List<Equipamento> equipamentos){
        try{
            mapper.writerFor(new TypeReference<List<Equipamento>>() {})
                    .writeValue(new File("dados.json"), equipamentos);
            System.out.println("Dados salvos em dados.json");
        } catch (IOException e){
            System.err.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }

    public List<Equipamento> carregarDados(){
        File arquivo = new File("dados.json");
        if (!arquivo.exists()){
            return new ArrayList<>();
        }

        try{
            return mapper.readValue(arquivo, new TypeReference<List<Equipamento>>(){});
        } catch (IOException e){
            System.err.println("Erro ao carregar dados" + e.getMessage());
            return new ArrayList<>();
        }
    }
}
