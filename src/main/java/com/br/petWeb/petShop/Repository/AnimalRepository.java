package com.br.petWeb.petShop.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.petWeb.petShop.Entity.Animal;
import com.br.petWeb.petShop.Entity.Tutor;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long>{
    List<Animal> findByTutorIdTutor(Long id);    // ou por ID do tutor
    List<Animal> findByTutorId(Long id);
}   