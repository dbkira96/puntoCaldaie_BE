package com.debartologiego.puntoCaldaie.data.services;

import com.debartologiego.puntoCaldaie.data.dto.StufaDto;

import java.util.List;

public interface StufaService {
    StufaDto addStufa(StufaDto Stufa);
    StufaDto getStufa(long id);
    List<StufaDto> getStufe();
    List<StufaDto> loadStufe(List<StufaDto> Stufe);
    StufaDto updateStufa(StufaDto stufa);
}
