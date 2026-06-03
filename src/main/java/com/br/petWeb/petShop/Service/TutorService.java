package com.br.petWeb.petShop.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.petWeb.petShop.Entity.Tutor;
import com.br.petWeb.petShop.Repository.TutorRepository;

@Service
public class TutorService {

    //Produto
    
    @Autowired
    private TutorRepository tutorRepository;

    public List<Tutor> buscarTodos() {
        return tutorRepository.findAll();
    }

    public Optional<Tutor> buscarPorId(Long id) { 
        return tutorRepository.findById(id);
    }

    public Tutor cadastraTutor(Tutor oTutor) { 
        return tutorRepository.save(oTutor);
    }

    public Tutor alterarTutor(Tutor dadosAtualizar, Long id) { 

        Tutor tutorBuscado = buscarPorId(id).orElseThrow( 
                () -> new IllegalArgumentException("Tutor Não Encontrado"));

                tutorBuscado.setNome_tutor(dadosAtualizar.getNome_tutor());
                tutorBuscado.setTelefone(dadosAtualizar.getTelefone());
                tutorBuscado.setEndereco(dadosAtualizar.getEndereco());

        return tutorRepository.save(tutorBuscado);
    }


    public void deletarTutor(Long id) {
        tutorRepository.deleteById(id);
    }
}