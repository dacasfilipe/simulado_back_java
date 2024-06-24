package com.App_Service_Back.funcionarios;

import com.App_Service_Back.concessionarias.Concessionarias;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "funcionarios")
public class Funcionarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate data_nascimento;
    private String email;
    private String senha;
    private String celular;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "concessionarias_id", nullable = false)
    private Concessionarias concessionarias;
}
