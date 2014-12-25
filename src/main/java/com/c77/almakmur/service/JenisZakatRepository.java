package com.c77.almakmur.service;

import com.c77.almakmur.domain.JenisZakat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JenisZakatRepository extends CrudRepository<JenisZakat, Long> {
    
}
