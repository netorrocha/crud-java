package service;

import entities.Client;
import entitiesDao.ClientDao;
import factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientService implements ClientDao {
    String sql = "";
    private  Connection conn;
    private PreparedStatement ps;
    public ClientService() throws SQLException {
        this.conn = ConnectionFactory.getConnection();
    }
    public ClientService(PreparedStatement ps){
        try {
            this.ps = conn.prepareStatement(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void create(Client client) {
        String sql = "INSERT INTO `clients`" + "(`nome`," + "`email`) VALUES(?,?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, client.getName());
            ps.setString(2,client.getEmail());

            ps.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public Client readForId(Integer id){
        sql = "SELECT * FROM clients WHERE id = ?";

        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);


            rs = ps.executeQuery();
            if (rs.next()){
                id = rs.getInt("id");
                String name = rs.getString("nome");
                String email = rs.getString("email");

                Client client = new Client(id,name,email);
                return client;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (rs!=null){
                    rs.close();
                }

            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        return null;
    }

    public List<Client>  read() {
     sql = "SELECT * FROM crud.clients";

        List<Client> clients = new ArrayList<>();

        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String name = rs.getString("nome");
                String email = rs.getString("email");

                // Crie uma instância de Client com os dados recuperados do banco de dados
                Client client = new Client(id, name, email);

                // Adicione o cliente à lista de clientes
                clients.add(client);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao ler clientes do banco de dados", e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return clients;
    }

    public void update(Client client){
    sql = "UPDATE clients SET nome = ?, email = ?" + "WHERE id = ?";


        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, client.getName());
            ps.setString(2, client.getEmail());
            ps.setInt(3, client.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Client client) {
    sql = "DELETE FROM clients WHERE id = ?";

        try {
        ps = conn.prepareStatement(sql);
        ps.setInt(1, client.getId());
        ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}


