package com.br.petWeb.petShop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.br.petWeb.petShop.Entity.Tutor;
import com.br.petWeb.petShop.Service.TutorService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/tutorCTR")
public class TutorController {
  
    @Autowired
    private TutorService tutorService; 


    @GetMapping("/main")
    public String telaMain() {
        return "main";
    }


    @GetMapping("/listarTutores")
    public String telalistarTutores(Model oModel) {
        oModel.addAttribute("tutores", tutorService.buscarTodos());
        
        return "listarTutores";
    }



    @GetMapping("/formCadastrar")
    public String telaCadastraTutor(Model oModel) {

        oModel.addAttribute("tutor", new Tutor());
        
        return "cadastraTutor";
    }

    @PostMapping("/salvarTutor")
    public String cadastraTutor(@ModelAttribute Tutor oTutor) { 

        tutorService.cadastraTutor(oTutor);

        return "redirect:/tutorCTR/listarTutores";
    }


    @GetMapping("/formAlterar/{id}")
    public String telaAlterarTutor(@PathVariable Long id, Model oModel) {
        Tutor oTutor = tutorService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Tutor não encontrado"));

        oModel.addAttribute("tutor", oTutor);

        return "cadastraTutor";
    }


    @PostMapping("/alterarTutor/{id}")
    public String alterarTutor(@PathVariable Long id, @ModelAttribute Tutor oTutor) {
        tutorService.alterarTutor(oTutor, id);

        return "redirect:/tutorCTR/listarTutores";
    }


    @GetMapping("/deletarTutor/{id}")
    public String deletarTutor(@PathVariable Long id) {
        tutorService.deletarTutor(id);

        return "redirect:/tutorCTR/listarTutores";
    }
}