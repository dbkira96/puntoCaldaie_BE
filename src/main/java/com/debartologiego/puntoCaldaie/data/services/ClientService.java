package com.debartologiego.puntoCaldaie.data.services;

import com.debartologiego.puntoCaldaie.data.dto.ClientDto;
import com.debartologiego.puntoCaldaie.data.entities.Client;

import java.util.List;

public interface ClientService {
    ClientDto addClient(ClientDto client);
    ClientDto getClient(long id);
    List<ClientDto> getClients();
    List<ClientDto> loadUsers(List<ClientDto> clients);
    ClientDto updateUser(ClientDto user);

    List<ClientDto> deleteAllClients();

    ClientDto deleteClient(Long id);
}
