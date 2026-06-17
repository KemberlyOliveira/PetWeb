package com.br.petWeb.petShop.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.br.petWeb.petShop.Entity.Animal;
import com.br.petWeb.petShop.Entity.Tutor;
import com.br.petWeb.petShop.Repository.TutorRepository;
import com.br.petWeb.petShop.Service.AnimalService;
import com.br.petWeb.petShop.Service.TutorService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/animalCTR")
public class AnimalController {
  
    @Autowired
    private AnimalService animalService; 



  
@Autowired
    private TutorRepository tutorRepository; 

    // Altere a rota abaixo para a rota real que abre o seu formulário HTML
    @GetMapping("/animal/novo") 
    public String abrirFormularioCadastro(Model model) {
        
        // 1. Envia um objeto Animal vazio para o th:object do formulário
        model.addAttribute("animal", new Animal());
        
        // 2. Busca os tutores e envia para o th:each do <select>
        List<Tutor> listaTutores = tutorRepository.findAll();
        model.addAttribute("todosOsTutores", listaTutores);
        
        return "formularioAnimal"; // Nome do seu arquivo HTML (sem o .html)
    }



    @GetMapping("/listarAnimal")
    public String telaListarAnimal(Model oModel) {
        oModel.addAttribute("animal", animalService.buscarTodos());
        
        return "listarAnimal";
    }
    
    @GetMapping("/formCadastrar")
    public String telaCadastraAnimal(Model oModel) {
        oModel.addAttribute("animal", new Animal());
        
        List<Tutor> listaTutores = tutorRepository.findAll();
        
        // LINHA DEDO-DURO: Vai printar no console do eclipse/VS Code quantos tutores achou
        System.out.println("=== QUANTIDADE DE TUTORES ACHADOS: " + listaTutores.size());
        
        oModel.addAttribute("todosOsTutores", listaTutores);
        return "cadastraAnimal";
    }


    @PostMapping("/salvarAnimal")
    public String cadastraAnimal(@ModelAttribute Animal oAnimal) { 
        animalService.cadastraAnimal(oAnimal);
        
        return "redirect:/animalCTR/listarAnimal";
    }

   

    @GetMapping("/formAlterar/{id}")
    public String telaAlterarAnimal(@PathVariable Long id, Model oModel) {
        Animal oAnimal = animalService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Animal não encontrado"));

        oModel.addAttribute("animal", oAnimal);
        
        return "cadastraAnimal";
    }


    @PostMapping("/alterarAnimal/{id}")
    public String alterarAnimal(@PathVariable Long id, @ModelAttribute Animal oAnimal) {
        animalService.alterarAnimal(oAnimal, id);
        
        return "redirect:/animalCTR/listarAnimal";
    }


    @GetMapping("/deletarAnimal/{id}")
    public String deletarAnimal(@PathVariable Long id) {
        animalService.deletarAnimal(id);
        
        return "redirect:/animalCTR/listarAnimal";
    }
}