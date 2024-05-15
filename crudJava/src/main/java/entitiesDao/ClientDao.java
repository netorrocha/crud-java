package entitiesDao;

import entities.Client;

import java.util.List;

public interface ClientDao{
    public void create(Client client);
    public Client readForId(Integer id);
    public List<Client> read();
    public void update(Client client);
    public void delete(Client client);


}
