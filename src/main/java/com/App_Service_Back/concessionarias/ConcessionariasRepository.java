package com.App_Service_Back.concessionarias;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcessionariasRepository extends JpaRepository<Concessionarias, Long> {
}