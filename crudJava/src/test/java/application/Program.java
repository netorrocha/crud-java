package application;

import entities.Client;
import entitiesDao.ClientDAO;
import factory.ConnectionFactory;

import java.sql.SQLException;


public class Program {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory.getConnection();
        Client client1 = new Client(null,"Annelise","anninhadonetao@gmail.com");
        ClientDAO clientDAO = new ClientDAO();
        try {
            clientDAO.save(client1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
