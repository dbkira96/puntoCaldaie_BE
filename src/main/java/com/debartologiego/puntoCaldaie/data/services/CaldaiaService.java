package com.debartologiego.puntoCaldaie.data.services;

import com.debartologiego.puntoCaldaie.data.dto.CaldaiaDto;
import com.debartologiego.puntoCaldaie.data.entities.Caldaia;

import java.util.List;

public interface CaldaiaService {
    CaldaiaDto addCaldaia(CaldaiaDto caldaia);
    CaldaiaDto getCaldaia(Long id);
    CaldaiaDto updateCaldaia(CaldaiaDto caldaia);
    CaldaiaDto deleteCaldaia(Long id);
    List<CaldaiaDto> getCaldaie();
}
