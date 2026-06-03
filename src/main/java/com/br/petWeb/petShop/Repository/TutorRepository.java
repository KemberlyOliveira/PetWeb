package com.br.petWeb.petShop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.petWeb.petShop.Entity.Tutor;

@Repository
public interface TutorRepository  extends JpaRepository<Tutor, Long>{
    
}
