package com.br.petWeb.petShop.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.br.petWeb.petShop.Entity.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    // Esta query manual ignora as regras mágicas de nomes de métodos do Spring
    @Query("SELECT a FROM Animal a WHERE a.tutor.id_tutor = :idTutor")
    List<Animal> buscarAnimaisPorIdDoTutor(@Param("idTutor") Long idTutor);
}