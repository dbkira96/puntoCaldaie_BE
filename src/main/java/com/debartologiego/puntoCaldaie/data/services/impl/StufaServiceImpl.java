package com.debartologiego.puntoCaldaie.data.services.impl;

import com.debartologiego.puntoCaldaie.data.dao.ClientDao;
import com.debartologiego.puntoCaldaie.data.dao.StufaDao;
import com.debartologiego.puntoCaldaie.data.dto.ClientDto;
import com.debartologiego.puntoCaldaie.data.dto.StufaDto;
import com.debartologiego.puntoCaldaie.data.entities.Client;
import com.debartologiego.puntoCaldaie.data.entities.Stufa;
import com.debartologiego.puntoCaldaie.data.services.StufaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StufaServiceImpl implements StufaService {
    @Autowired
    private StufaDao stufaDao;

    @Autowired
    private ClientDao clientDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StufaDto addStufa(StufaDto stufaDto) {
        Stufa stufa = modelMapper.map(stufaDto,Stufa.class);
        stufa.setCliente(clientDao.findById(stufaDto.getCliente().getId()).orElseThrow(()->new RuntimeException("utente non trovato")));
        return modelMapper.map(stufaDao.save(stufa),StufaDto.class);
    }

    @Override
    public StufaDto getStufa(long id) {
        Stufa stufa =stufaDao.findById(id).orElseThrow(()->new RuntimeException("Stufa non trovata"));
        return modelMapper.map(stufa,StufaDto.class);
    }

    @Override
    public List<StufaDto> getStufe() {
        List<Stufa> stufe = stufaDao.findAll();
        return stufe.stream().map(stufa -> {
            StufaDto stufaDto= modelMapper.map(stufa,StufaDto.class);
            ClientDto client=modelMapper.map(stufa.getCliente(),ClientDto.class);
            client.setStufe(null);
            client.setCaldaie(null);
            stufaDto.setCliente(client);
            return stufaDto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<StufaDto> loadStufe(List<StufaDto> stufeDto) {
        List<Stufa> stufe = stufeDto.stream().map(stufaDto -> modelMapper.map(stufaDto,Stufa.class)).collect(Collectors.toList());
        return stufaDao.saveAll(stufe).stream().map(stufa -> modelMapper.map(stufa,StufaDto.class)).collect(Collectors.toList());
    }

    @Override
    public StufaDto updateStufa(StufaDto stufaDto) {
        /*
        *  Stufa stufa = modelMapper.map(stufaDto,Stufa.class);
        Stufa old=stufaDao.findById(stufa.getId()).orElseThrow(()->new RuntimeException("Stufa non trovata"));
        stufa.setCliente(old.getCliente());
        return modelMapper.map(stufaDao.save(stufa),StufaDto.class);*/
        Stufa stufa=modelMapper.map(stufaDto,Stufa.class);
        Stufa old=stufaDao.findById(stufa.getId()).orElseThrow(()->new RuntimeException("Stufa non trovata"));
        stufa.setCliente(old.getCliente());
        return modelMapper.map(stufaDao.save(stufa),StufaDto.class);
    }

    /*
    * public StufaDto deleteStufa(Long id) {
        Stufa stufa= stufaDao.findById(id).orElseThrow(()->new RuntimeException("Stufa non trovata"));
        stufaDao.delete(stufa);
        return new StufaDto();
    }*/
    public StufaDto deleteStufa(Long id) {
        Stufa stufa = stufaDao.findById(id).orElseThrow(() -> new RuntimeException("Stufa non trovata"));
        stufaDao.delete(stufa);
        return new StufaDto();
    }

}
