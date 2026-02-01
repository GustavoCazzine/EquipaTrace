package app;

import app.model.Ferramenta;
import app.model.Laptop;
import app.service.AlmoxarifadoService;
import app.service.PersistenciaService;

public class Main {
    public static void main(String[] args) {
        AlmoxarifadoService service = new AlmoxarifadoService();

        service.listarTodos();
    }
}
