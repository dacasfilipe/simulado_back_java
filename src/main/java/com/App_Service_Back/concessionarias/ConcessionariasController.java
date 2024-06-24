package com.App_Service_Back.concessionarias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/concessionarias")
public class ConcessionariasController {

    @Autowired
    private ConcessionariasService concessionariasService;

    @Autowired
    private ConcessionariasMapper concessionariasMapper;

    @GetMapping
    public List<ConcessionariasDTO> getAllConcessionarias() {
        return concessionariasService.getAllConcessionarias().stream()
                .map(concessionariasMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConcessionariasDTO> getConcessionariaById(@PathVariable Long id) {
        Concessionarias concessionaria = concessionariasService.getConcessionariaById(id);
        if (concessionaria != null) {
            return ResponseEntity.ok(concessionariasMapper.toDTO(concessionaria));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ConcessionariasDTO createConcessionaria(@RequestBody ConcessionariasDTO concessionariaDTO) {
        Concessionarias concessionaria = concessionariasMapper.toEntity(concessionariaDTO);
        return concessionariasMapper.toDTO(concessionariasService.saveConcessionaria(concessionaria));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConcessionariasDTO> updateConcessionaria(@PathVariable Long id, @RequestBody ConcessionariasDTO concessionariaDTO) {
        Concessionarias concessionaria = concessionariasMapper.toEntity(concessionariaDTO);
        concessionaria.setId(id);
        Concessionarias updatedConcessionaria = concessionariasService.updateConcessionaria(concessionaria);
        if (updatedConcessionaria != null) {
            return ResponseEntity.ok(concessionariasMapper.toDTO(updatedConcessionaria));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConcessionaria(@PathVariable Long id) {
        boolean isDeleted = concessionariasService.deleteConcessionaria(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}