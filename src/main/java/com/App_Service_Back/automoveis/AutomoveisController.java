package com.App_Service_Back.automoveis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/automoveis")
public class AutomoveisController {

    @Autowired
    private AutomoveisService automoveisService;

    @Autowired
    private AutomoveisMapper automoveisMapper;

    @GetMapping
    public List<AutomoveisDTO> getAllAutomoveis() {
        return automoveisService.getAllAutomoveis().stream()
                .map(automoveisMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutomoveisDTO> getAutomoveisById(@PathVariable Long id) {
        Automoveis automovel = automoveisService.getAutomoveisById(id);
        if (automovel != null) {
            return ResponseEntity.ok(automoveisMapper.toDTO(automovel));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public AutomoveisDTO createAutomoveis(@RequestBody AutomoveisDTO automovelDTO) {
        Automoveis automovel = automoveisMapper.toEntity(automovelDTO);
        return automoveisMapper.toDTO(automoveisService.saveAutomoveis(automovel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutomoveisDTO> updateAutomoveis(@PathVariable Long id, @RequestBody AutomoveisDTO automovelDTO) {
        Automoveis automovel = automoveisMapper.toEntity(automovelDTO);
        automovel.setId(id);
        Automoveis updatedAutomovel = automoveisService.updateAutomoveis(automovel);
        if (updatedAutomovel != null) {
            return ResponseEntity.ok(automoveisMapper.toDTO(updatedAutomovel));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutomoveis(@PathVariable Long id) {
        boolean isDeleted = automoveisService.deleteAutomoveis(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}