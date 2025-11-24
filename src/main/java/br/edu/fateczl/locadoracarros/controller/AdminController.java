package br.edu.fateczl.locadoracarros.controller;

import br.edu.fateczl.locadoracarros.model.Locacao;
import br.edu.fateczl.locadoracarros.service.LocacaoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private LocacaoService locacaoService;

    @GetMapping
    public String getPage(Model model) {
        model.addAttribute("locacoes", locacaoService.listarLocacoesEmAberto());
        model.addAttribute("mensagem", null);
        return "locacoes";
    }

    @PostMapping("/locacao/buscar")
    public String buscarLocacao(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            locacaoService.getLocacaoId(id);
            return "redirect:/devolucao/" + id;
        } catch (EntityNotFoundException e) {
            redirectAttributes.addFlashAttribute("mensagem", e.getMessage());
            return "redirect:/admin";
        }
    }
}