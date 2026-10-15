package tn.esprit.aichadrira4cce11.service;

import tn.esprit.aichadrira4cce11.domain.Client;
import java.util.List;

public interface IClientService {
    Client create(Client client);
    Client update(Client client);
    Client findById(Long id);
    List<Client> findAll();
    void deleteById(Long id);
}
