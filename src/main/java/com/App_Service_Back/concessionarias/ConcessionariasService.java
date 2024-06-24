package com.App_Service_Back.concessionarias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConcessionariasService {

    @Autowired
    private ConcessionariasRepository concessionariasRepository;

    public List<Concessionarias> getAllConcessionarias() {
        return concessionariasRepository.findAll();
    }

    public Concessionarias getConcessionariaById(Long id) {
        Optional<Concessionarias> concessionaria = concessionariasRepository.findById(id);
        return concessionaria.orElse(null);
    }

    public Concessionarias saveConcessionaria(Concessionarias concessionaria) {
        return concessionariasRepository.save(concessionaria);
    }

    public Concessionarias updateConcessionaria(Concessionarias concessionaria) {
        if (concessionariasRepository.existsById(concessionaria.getId())) {
            return concessionariasRepository.save(concessionaria);
        } else {
            return null;
        }
    }

    public boolean deleteConcessionaria(Long id) {
        if (concessionariasRepository.existsById(id)) {
            concessionariasRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}