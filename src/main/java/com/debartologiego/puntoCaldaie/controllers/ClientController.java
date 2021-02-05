package com.debartologiego.puntoCaldaie.controllers;

import com.debartologiego.puntoCaldaie.data.dto.ClientDto;
import com.debartologiego.puntoCaldaie.data.entities.Client;
import com.debartologiego.puntoCaldaie.data.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("puntocaldaie")
public class ClientController {
    @Autowired
    ClientService clientservice;

    @GetMapping("/clienti/get")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ClientDto> get(@RequestParam(name="id",defaultValue = "0") Long id){
        return ResponseEntity.ok(clientservice.getClient(id));
    }
    @DeleteMapping("/clienti/delete")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ClientDto> delete(@RequestParam(name="id",defaultValue = "0") Long id){
        return ResponseEntity.ok(clientservice.deleteClient(id));
    }
    @GetMapping("/clienti/getAll")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<ClientDto>> all(){
        return ResponseEntity.ok(clientservice.getClients());
    }
    @PostMapping("/clienti/update")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ClientDto> updateUser(@RequestBody ClientDto userDto){
        return ResponseEntity.ok(clientservice.updateUser(userDto));
    }
    @PostMapping("/clienti/add")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ClientDto> addUser(@RequestBody ClientDto userDto){

        return ResponseEntity.ok(clientservice.addClient(userDto));
    }
    @PostMapping("/clienti/addAll")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<ClientDto>> loadUsers(@RequestBody List<ClientDto> usersDto){
        return ResponseEntity.ok(clientservice.loadUsers(usersDto));
    }
    @GetMapping("/clienti/deleteAll")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<ClientDto>> deleteAll(){
        return ResponseEntity.ok(clientservice.deleteAllClients());
    }
}
