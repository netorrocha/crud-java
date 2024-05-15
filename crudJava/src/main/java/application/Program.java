package application;

import entities.Client;
import entitiesDao.ClientDao;
import service.ClientService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "CRUD DO NETO \n" + "Selecione uma opção a baixo: \n" +
                        "1.Cadastrar novo usuário\n" +
                        "2.Buscar usuário \n" +
                        "3.Alterar usuário \n" +
                        "4.Deletar usuário");
        int option = scanner.nextInt();
        ClientService clientService = new ClientService();

        switch (option) {
            case 1:
                System.out.println("Preencha as informações abaixo ");
                System.out.println("Nome: ");
                String name = scanner.next();
                System.out.println("Email: ");
                String email = scanner.next();
                Client clientCreate = new Client(null, name, email);
                clientService.create(clientCreate);
                break;

            case 2:
                System.out.println(
                        "1.Buscar cliente especifico por ID + \n" +
                                "2.Buscar todos os cleintes");
                int option2 = scanner.nextInt();
                switch (option2) {
                    case 1:
                        System.out.println("Informe o ID do usuário ");
                        Integer id = scanner.nextInt();
                        Client client = clientService.readForId(id);
                        System.out.println(
                                "\nID: " + client.getId() +
                                        "\nNOME: " + client.getName() +
                                        "\nEMAIL: " + client.getEmail()
                        );

                    case 2:
                        clientService.read();
                        for (Client c : clientService.read()) {
                            System.out.println("ID: " + c.getId());
                            System.out.println("Name: " + c.getName());
                            System.out.println("Email: " + c.getEmail() + "\n");
                        }
                }
            case 3:
                System.out.println("Informe o ID do usuário ");
                Integer id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Informe o novo nome do usuário");
                String newName = scanner.nextLine();
                System.out.println("Informe o novo email");
                String newEmail = scanner.next();

                Client client = new Client(id, newName, newEmail);
                clientService.update(client);
            case 4:
                System.out.println("Informe o ID do usuário ");
                Integer idDelet = scanner.nextInt();
                clientService.delete(idDelet);


        }

    }

}
