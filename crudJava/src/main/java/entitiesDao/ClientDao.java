package entitiesDao;

import entities.Client;

import java.util.List;

public interface ClientDao{
    public void create(Client client);
    public List<Client> read();


}
