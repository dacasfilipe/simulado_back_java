package com.App_Service_Back.automoveis;

import com.App_Service_Back.concessionarias.Concessionarias;
import com.App_Service_Back.endereco.Endereco;
import com.App_Service_Back.telefone.Telefone;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "automoveis")
public class Automoveis implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private  String nome;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "concessionaria_id", nullable = false)
    private Concessionarias concessionaria;

}
