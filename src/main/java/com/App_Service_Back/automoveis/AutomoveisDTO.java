package com.App_Service_Back.automoveis;

import com.App_Service_Back.concessionarias.ConcessionariasDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutomoveisDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String nome;
    private ConcessionariasDTO concessionaria;
}