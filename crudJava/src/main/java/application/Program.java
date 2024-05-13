package application;

import entities.Client;
import entitiesDao.ClientDAO;

import java.sql.SQLException;


public class Program {
    public static void main(String[] args) throws SQLException {
        ClientDAO clientDAO = new ClientDAO();
        Client client1 = new Client(null,"Annelise","anninhadonetao@gmail.com");
        clientDAO.update(client1);

        for (Client c : clientDAO.read()){
            System.out.println("Cliente: " + c.getName());
        }

    }

}
