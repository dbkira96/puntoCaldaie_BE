package com.debartologiego.puntoCaldaie.data.services.impl;

import com.debartologiego.puntoCaldaie.data.dao.CaldaiaDao;
import com.debartologiego.puntoCaldaie.data.dao.ClientDao;
import com.debartologiego.puntoCaldaie.data.dto.CaldaiaDto;
import com.debartologiego.puntoCaldaie.data.dto.StufaDto;
import com.debartologiego.puntoCaldaie.data.entities.Caldaia;
import com.debartologiego.puntoCaldaie.data.services.CaldaiaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CaldaiaServiceImpl implements CaldaiaService {

    @Autowired
    CaldaiaDao caldaiaDao;

    @Autowired
    ClientDao clientDao;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public CaldaiaDto addCaldaia(CaldaiaDto caldaiaDto) {
        Caldaia caldaia = modelMapper.map(caldaiaDto,Caldaia.class);
        caldaia.setCliente(clientDao.findById(caldaiaDto.getCliente().getId()).orElseThrow(()->new RuntimeException("utente proprietario della caldaia non trovato")));
        return modelMapper.map(caldaiaDao.save(caldaia),CaldaiaDto.class);
    }

    @Override
    public CaldaiaDto getCaldaia(Long id) {
        Caldaia caldaia= caldaiaDao.findById(id).orElseThrow(()->new RuntimeException("Caldaia non trovata"));
        return modelMapper.map(caldaia,CaldaiaDto.class);
    }

    @Override
    public CaldaiaDto updateCaldaia(CaldaiaDto caldaiaDto) {
        Caldaia caldaia = modelMapper.map(caldaiaDto,Caldaia.class);
        Caldaia old=caldaiaDao.findById(caldaia.getId()).orElseThrow(()->new RuntimeException("Caldaia non trovata"));
        caldaia.setCliente(old.getCliente());
        return modelMapper.map(caldaiaDao.save(caldaia),CaldaiaDto.class);
    }

    @Override
    public CaldaiaDto deleteCaldaia(Long id) {
        Caldaia caldaia= caldaiaDao.findById(id).orElseThrow(()->new RuntimeException("Caldaia non trovata"));
        caldaiaDao.delete(caldaia);
        return new CaldaiaDto();
    }
    @Override
    public List<CaldaiaDto> getCaldaie(){
        List<Caldaia> caldaie=caldaiaDao.findAll();
        return caldaie.stream().map(caldaia -> modelMapper.map(caldaia, CaldaiaDto.class)).collect(Collectors.toList());
    }
}
