package com.debartologiego.puntoCaldaie.data.services.impl;

import com.debartologiego.puntoCaldaie.data.dao.ClientDao;
import com.debartologiego.puntoCaldaie.data.dao.StufaDao;
import com.debartologiego.puntoCaldaie.data.dto.ClientDto;
import com.debartologiego.puntoCaldaie.data.dto.StufaDto;
import com.debartologiego.puntoCaldaie.data.entities.Caldaia;
import com.debartologiego.puntoCaldaie.data.entities.Client;
import com.debartologiego.puntoCaldaie.data.entities.Stufa;
import com.debartologiego.puntoCaldaie.data.services.ClientService;
import com.debartologiego.puntoCaldaie.data.services.StufaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;

    @Autowired
    private StufaDao stufaDao;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    StufaService stufaService;

    @Override
    public ClientDto addClient(ClientDto clientDto) {
        Client client= modelMapper.map(clientDto,Client.class);
        setBackReference(client);
        return modelMapper.map(clientDao.save(client),ClientDto.class);
    }
    private Client setBackReference(Client c){
        if(c.getStufe()!=null) {
            for (Stufa s : c.getStufe()
            ) {
                s.setCliente(c);
            }
        }
        if(c.getCaldaie()!=null) {
            for (Caldaia cal : c.getCaldaie()
            ) {
                cal.setCliente(c);
            }
        }
        return c;
    }
    @Override
    public ClientDto getClient(long id) {
        Client client =clientDao.findById(id).orElseThrow(()->new RuntimeException("Cliente non trovato"));
        return modelMapper.map(client,ClientDto.class);
    }

    @Override
    public List<ClientDto> getClients() {
        List<Client> clients = clientDao.findAll();
        return clients.stream().map(user->modelMapper.map(user,ClientDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ClientDto> loadUsers(List<ClientDto> clientsDto) {
        List<Client> clients= clientsDto.stream().map(clientDto -> modelMapper.map(clientDto,Client.class)).collect(Collectors.toList());
        for (Client c :clients
             ) {
            setBackReference(c);
        }
        clients=clientDao.saveAll(clients);
        return clients.stream().map(user->modelMapper.map(user,ClientDto.class)).collect(Collectors.toList());
    }

    @Override
    public ClientDto updateUser(ClientDto clientDto) {
        Client client = clientDao.findById(clientDto.getId()).orElseThrow(() -> new RuntimeException("user " + clientDto.getNominativo() + " not found"));
        return addClient(clientDto);
    }

    @Override
    public List<ClientDto> deleteAllClients() {
        clientDao.deleteAll();
        return  getClients();
    }

    @Override
    public ClientDto deleteClient(Long id) {
        Client client =clientDao.findById(id).orElseThrow(()->new RuntimeException("cliente non trovato"));
        clientDao.delete(client);
        return new ClientDto();
    }
}
