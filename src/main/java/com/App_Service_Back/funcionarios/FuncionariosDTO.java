package com.App_Service_Back.funcionarios;

import com.App_Service_Back.concessionarias.ConcessionariasDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionariosDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate data_nascimento;
    private String email;
    private String senha;
    private String celular;
    private ConcessionariasDTO concessionarias;
}