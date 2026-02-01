package app;

import app.model.Ferramenta;
import app.model.Laptop;
import app.service.AlmoxarifadoService;

public class Main {
    public static void main(String[] args) {
        Ferramenta e1 = new Ferramenta("1", "Furadeira", "Makita", "Piracicaba", 13.2);
        Laptop e2 = new Laptop("2", "Laptop", "Dell", "Campo Largo", "Intel Core i9=10850K 3.6Ghz");
        AlmoxarifadoService service = new AlmoxarifadoService();

        service.adicionar(e1);
        service.adicionar(e2);

        service.listarTodos();

        service.transferir("1", "Campo Largo");
        service.transferir("2", "Wakanda");
        service.transferir("2", "Piracicaba");

        service.listarTodos();

    }
    }
