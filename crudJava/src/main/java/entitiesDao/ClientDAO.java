package entitiesDao;

import entities.Client;
import factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientDAO {
    public void save(Client client) throws SQLException {
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
                throw new RuntimeException(e);
            }

        }
    }
}
