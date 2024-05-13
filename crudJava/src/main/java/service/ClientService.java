package service;

import entities.Client;
import factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    public void create(Client client) throws SQLException {
        String sql = "INSERT INTO `clients`" + "(`nome`," + "`email`) VALUES(?,?)";
        Connection conn = null;
        PreparedStatement pst = null;

        try {
            conn = ConnectionFactory.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, client.getName());
            pst.setString(2,client.getEmail());

            pst.executeUpdate();
        } catch (SQLException e) {

        } finally {
            try {
                if (pst!=null){
                pst.close();}
                if (conn!=null){
                conn.close();}
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public List<Client>  read() {
    String sql = "SELECT * FROM crud.clients";

        List<Client> clients = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();
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
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return clients;
    }

    public void update(Client client){
        String sql = "UPDATE clients SET nome = ?, email = ?" + "WHERE id = ?";

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = ConnectionFactory.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, client.getName());
            ps.setString(2, client.getEmail());
            ps.setInt(3, client.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (ps != null){
                    ps.close();
                }
                if (conn != null){
                    conn.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public void delete(Client client){
        String sql = "DELETE FROM clients WHERE id = ?";

        Connection conn = null;
        PreparedStatement ps = null;
        try {
        conn = ConnectionFactory.getConnection();
        ps = conn.prepareStatement(sql);
        ps.setInt(1, client.getId());
        ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
            if (ps != null){
                ps.close();
            }
            if (conn != null){
                conn.close();
            }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }
}


