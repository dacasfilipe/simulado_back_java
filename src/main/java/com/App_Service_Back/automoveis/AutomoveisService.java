package com.App_Service_Back.automoveis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutomoveisService {

    @Autowired
    private AutomoveisRepository automoveisRepository;

    public List<Automoveis> getAllAutomoveis() {
        return automoveisRepository.findAll();
    }

    public Automoveis getAutomoveisById(Long id) {
        Optional<Automoveis> automovel = automoveisRepository.findById(id);
        return automovel.orElse(null);
    }

    public Automoveis saveAutomoveis(Automoveis automovel) {
        return automoveisRepository.save(automovel);
    }

    public Automoveis updateAutomoveis(Automoveis automovel) {
        if (automoveisRepository.existsById(automovel.getId())) {
            return automoveisRepository.save(automovel);
        } else {
            return null;
        }
    }

    public boolean deleteAutomoveis(Long id) {
        if (automoveisRepository.existsById(id)) {
            automoveisRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}