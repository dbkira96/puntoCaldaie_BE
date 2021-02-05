package com.debartologiego.puntoCaldaie.controllers;

import com.debartologiego.puntoCaldaie.data.dto.CaldaiaDto;
import com.debartologiego.puntoCaldaie.data.services.CaldaiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("puntocaldaie")
public class CaldaiaController {
    @Autowired
    CaldaiaService caldaiaService;


    @GetMapping("/caldaie/get")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<CaldaiaDto> get(@RequestParam(name="id",defaultValue = "0") Long id){
        return ResponseEntity.ok(caldaiaService.getCaldaia(id));
    }

    @PostMapping("/caldaie/update")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<CaldaiaDto> updateCaldaia(@RequestBody CaldaiaDto userDto){
        return ResponseEntity.ok(caldaiaService.updateCaldaia(userDto));
    }
    @PostMapping("/caldaie/add")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<CaldaiaDto> addCaldaia(@RequestBody CaldaiaDto caldaiaDto){
        System.err.println(caldaiaDto.toString());
        return ResponseEntity.ok(caldaiaService.addCaldaia(caldaiaDto));
    }
    /*
    @DeleteMapping("/stufe/delete")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<StufaDto> delete(@RequestParam(name="id",defaultValue = "0") Long id){
        return ResponseEntity.ok(stufaService.deleteStufa(id));
    }*/
    @DeleteMapping("/caldaie/delete")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<CaldaiaDto> delete(@RequestParam(name="id",defaultValue = "0") Long id){
        return ResponseEntity.ok(caldaiaService.deleteCaldaia(id));
    }


}

