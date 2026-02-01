package app;

import app.model.Ferramenta;
import app.model.Laptop;

public class Main {
    public static void main(String[] args) {
        Ferramenta e1 = new Ferramenta("1", "Furadeira", "Makita", "Piracicaba", 13.2);
        Laptop e2 = new Laptop("2", "Laptop", "Dell", "Campo Largo", "Intel Core i9=10850K 3.6Ghz");

        System.out.println(e1.obterDetalhes());
        System.out.println(e2.obterDetalhes());

    }
    }
