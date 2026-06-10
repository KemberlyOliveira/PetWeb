package com.br.petWeb.petShop.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.petWeb.petShop.Entity.Animal;
import com.br.petWeb.petShop.Entity.Tutor;
import com.br.petWeb.petShop.Repository.AnimalRepository;

@Service
public class AnimalService {
    
    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> buscarTodos() {
        return animalRepository.findAll();
    }

    public Optional<Animal> buscarPorId(Long id) { 
        return animalRepository.findById(id);
    }


    @Transactional
    public Animal cadastraAnimal(Animal oAnimal) { 
        return animalRepository.save(oAnimal);
    }

    @Transactional
    public Animal alterarAnimal(Animal dadosAtualizar, Long id) { 

        Animal animalBuscado = buscarPorId(id).orElseThrow( 
                () -> new IllegalArgumentException("Animal não encontrado"));

        animalBuscado.setNome_animal(dadosAtualizar.getNome_animal());
        animalBuscado.setIdade(dadosAtualizar.getIdade());
        animalBuscado.setRaca(dadosAtualizar.getRaca());
        animalBuscado.setTutor(dadosAtualizar.getTutor());

        return animalRepository.save(animalBuscado);
    }

    @Transactional
    public void deletarAnimal(Long id) {
        animalRepository.deleteById(id);
    }


    public List<Animal> buscarPorTutor(Tutor tutor) {
        return animalRepository.findByTutor(tutor);
    }
}