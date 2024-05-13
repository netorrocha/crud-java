package application;

import entities.Client;
import service.ClientService;

import java.sql.SQLException;


public class Program {
    public static void main(String[] args) throws SQLException {
        ClientService clientService = new ClientService();
        Client client1 = new Client(null,"Annelise","anninhadonetao@gmail.com");
        //clientService.create(client1);

        Client client2 = new Client(1,"Anne","anne22@gmail.com");
        //clientService.update(client2);

        Client client3 = new Client(4,"Annelise","anne22@gmail.com");
        clientService.delete(client3);

        for (Client c : clientService.read()){
            System.out.println("Cliente: " + c.getName());
        }

    }

}
