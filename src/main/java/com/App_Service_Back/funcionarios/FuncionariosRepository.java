package com.App_Service_Back.funcionarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionariosRepository extends JpaRepository<Funcionarios,Long> {
    //cria uma interface para ser implementada
}
