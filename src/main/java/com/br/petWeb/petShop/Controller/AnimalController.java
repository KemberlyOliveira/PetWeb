package com.br.petWeb.petShop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.br.petWeb.petShop.Entity.Animal;
import com.br.petWeb.petShop.Service.AnimalService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/animalCTR")
public class AnimalController {
  
    @Autowired
    private AnimalService animalService; 

    @GetMapping("/main")
    public String telaMain() {
        
        return "main";
    }


    @GetMapping("/listarAnimal")
    public String telaListarAnimal(Model oModel) {
        oModel.addAttribute("animal", animalService.buscarTodos());
        
        return "listarAnimal";
    }


    @GetMapping("/formCadastrar")
    public String telaCadastraAnimal(Model oModel) {
        oModel.addAttribute("animal", new Animal());
        
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