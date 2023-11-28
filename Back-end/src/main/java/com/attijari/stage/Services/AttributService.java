package com.attijari.stage.Services;

import com.attijari.stage.Entity.Attributs;

import java.util.List;

public interface AttributService{
    List<Attributs> findAllWithModule();

    Attributs addAttributsAssociateToModule(Attributs attribut, Long idModule);

    Attributs updateAttribut(Attributs attributs, Long id);

     void deleteAttributs(Long id) ;
}


