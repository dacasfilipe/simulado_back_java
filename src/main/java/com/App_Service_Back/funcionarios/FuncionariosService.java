package com.App_Service_Back.funcionarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionariosService {

    @Autowired
    private FuncionariosRepository funcionariosRepository;

    public List<Funcionarios> getAllFuncionarios() {
        return funcionariosRepository.findAll();
    }

    public Funcionarios getFuncionarioById(Long id) {
        Optional<Funcionarios> funcionario = funcionariosRepository.findById(id);
        return funcionario.orElse(null);
    }

    public Funcionarios saveFuncionario(Funcionarios funcionario) {
        return funcionariosRepository.save(funcionario);
    }

    public Funcionarios updateFuncionario(Funcionarios funcionario) {
        if (funcionariosRepository.existsById(funcionario.getId())) {
            return funcionariosRepository.save(funcionario);
        } else {
            return null;
        }
    }

    public boolean deleteFuncionario(Long id) {
        if (funcionariosRepository.existsById(id)) {
            funcionariosRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}