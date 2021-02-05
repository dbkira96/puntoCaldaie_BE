package com.debartologiego.puntoCaldaie.controllers;

import com.debartologiego.puntoCaldaie.data.dto.StufaDto;
import com.debartologiego.puntoCaldaie.data.services.StufaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("puntocaldaie")
public class StufaController {
    @Autowired
    StufaService stufaService;


    @GetMapping("/stufe/get")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<StufaDto> get(@RequestParam(name="id",defaultValue = "0") Long id){
        return ResponseEntity.ok(stufaService.getStufa(id));
    }
    @GetMapping("/stufe/getAll")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<StufaDto>> all(){
        return ResponseEntity.ok(stufaService.getStufe());
    }
    @PostMapping("/stufe/update")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<StufaDto> updateStufa(@RequestBody StufaDto userDto){
        return ResponseEntity.ok(stufaService.updateStufa(userDto));
    }
    @PostMapping("/stufe/add")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<StufaDto> addStufa(@RequestBody StufaDto stufaDto){
        return ResponseEntity.ok(stufaService.addStufa(stufaDto));
    }
    @PostMapping("/stufe/addAll")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<StufaDto>> loadStufe(@RequestBody List<StufaDto> usersDto){
        return ResponseEntity.ok(stufaService.loadStufe(usersDto));
    }
    @DeleteMapping("/stufe/delete")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<StufaDto> delete(@RequestParam(name="id",defaultValue = "0") Long id) {
        return ResponseEntity.ok(stufaService.deleteStufa(id));
    }
}
