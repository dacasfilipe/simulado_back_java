package com.App_Service_Back.concessionarias;
import com.App_Service_Back.automoveis.Automoveis;
import com.App_Service_Back.funcionarios.Funcionarios;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "concessionarias")
public class Concessionarias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Automoveis> automoveis;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Funcionarios> funcionarios;

}
