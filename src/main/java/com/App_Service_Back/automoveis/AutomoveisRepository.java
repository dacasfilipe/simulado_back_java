package com.App_Service_Back.automoveis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomoveisRepository extends JpaRepository<Automoveis, Long> {
}