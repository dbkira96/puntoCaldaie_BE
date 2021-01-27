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
    private ModelMapper modelMapper;

    @Override
    public StufaDto addStufa(StufaDto stufaDto) {
        Stufa stufa = modelMapper.map(stufaDto,Stufa.class);
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
        return stufe.stream().map(stufa -> modelMapper.map(stufa,StufaDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<StufaDto> loadStufe(List<StufaDto> stufeDto) {
        List<Stufa> stufe = stufeDto.stream().map(stufaDto -> modelMapper.map(stufaDto,Stufa.class)).collect(Collectors.toList());
        return stufaDao.saveAll(stufe).stream().map(stufa -> modelMapper.map(stufa,StufaDto.class)).collect(Collectors.toList());
    }

    @Override
    public StufaDto updateStufa(StufaDto stufaDto) {
        if (stufaDao.existsById(stufaDto.getId()))  return addStufa(stufaDto);
        else  return  new StufaDto();
    }

    

}
