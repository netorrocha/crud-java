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

        switch (option){
            case 1:
                System.out.println("Preencha as informações abaixo ");
                System.out.println("Nome: ");
                String name = scanner.next();
                System.out.println("Email: ");
                String email = scanner.next();
                Client  clientCreate = new Client(null,name,email);
                clientService.create( clientCreate);
            break;

            case 2:
                System.out.println(
                        "1.Buscar cliente especifico por ID + \n" +
                        "2.Buscar todos os cleintes");
                int  option2 = scanner.nextInt();
                switch (option2){
                        case 1:
                            System.out.println("Informe o ID do usuário ");
                            Integer id = scanner.nextInt();
                            Client client = clientService.readForId(id);
                            System.out.println(
                                    "\nID: " + client.getId() +
                                    "\nNOME: " + client.getName() +
                                    "\nEMAIL: " + client.getEmail()
                            );
                }

        }

    }

}
