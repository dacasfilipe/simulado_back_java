package com.App_Service_Back.funcionarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/funcionarios")
public class FuncionariosController {

    @Autowired
    private FuncionariosService funcionariosService;

    @Autowired
    private FuncionariosMapper funcionariosMapper;

    @GetMapping
    public List<FuncionariosDTO> getAllFuncionarios() {
        return funcionariosService.getAllFuncionarios().stream()
                .map(funcionariosMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionariosDTO> getFuncionarioById(@PathVariable Long id) {
        Funcionarios funcionario = funcionariosService.getFuncionarioById(id);
        if (funcionario != null) {
            return ResponseEntity.ok(funcionariosMapper.toDTO(funcionario));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public FuncionariosDTO createFuncionario(@RequestBody FuncionariosDTO funcionarioDTO) {
        Funcionarios funcionario = funcionariosMapper.toEntity(funcionarioDTO);
        return funcionariosMapper.toDTO(funcionariosService.saveFuncionario(funcionario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionariosDTO> updateFuncionario(@PathVariable Long id, @RequestBody FuncionariosDTO funcionarioDTO) {
        Funcionarios funcionario = funcionariosMapper.toEntity(funcionarioDTO);
        funcionario.setId(id);
        Funcionarios updatedFuncionario = funcionariosService.updateFuncionario(funcionario);
        if (updatedFuncionario != null) {
            return ResponseEntity.ok(funcionariosMapper.toDTO(updatedFuncionario));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable Long id) {
        boolean isDeleted = funcionariosService.deleteFuncionario(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}