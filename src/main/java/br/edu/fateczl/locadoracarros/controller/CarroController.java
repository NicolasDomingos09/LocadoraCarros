package br.edu.fateczl.locadoracarros.controller;

import br.edu.fateczl.locadoracarros.model.Carro;
import br.edu.fateczl.locadoracarros.service.CarroService;
import br.edu.fateczl.locadoracarros.service.CategoriaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.ArrayList;

@Controller
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    private CarroService service;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String getForm(ModelMap model) {
        model.addAttribute("carro", new Carro());
        model.addAttribute("carros", new ArrayList<Carro>());
        model.addAttribute("categorias", categoriaService.listarCategorias());
        return "carro";
    }

    @GetMapping("/listar")
    public String listarCarros(ModelMap model) {
        model.addAttribute("carros", service.listarCarros());
        model.addAttribute("categorias", categoriaService.listarCategorias());
        model.addAttribute("carro", new Carro());
        return "carro";
    }

    @GetMapping("/{placa}")
    public String getCarroPorPlaca(@PathVariable String placa, ModelMap model, RedirectAttributes redirectAttributes) {
        try {
            model.addAttribute("carro", service.getCarroPorPlaca(placa));
        } catch (EntityNotFoundException e) {
            redirectAttributes.addFlashAttribute("mensagem", e.getMessage());
            return "redirect:/carro";
        }
        model.addAttribute("categorias", categoriaService.listarCategorias());
        model.addAttribute("carros", new ArrayList<Carro>());
        return "carro";
    }

    @PostMapping
    public String postCarro(@ModelAttribute("carro") Carro carro,
                            @RequestParam("imagem") MultipartFile imagem, RedirectAttributes redirectAttributes) {

        try {
            service.salvarCarro(carro, imagem);
            redirectAttributes.addFlashAttribute("mensagem", "Carro salvo com sucesso!");
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("mensagem", e.getMessage());
        }
        return "redirect:/carro";
    }

    @PutMapping
    public String putCarro(@ModelAttribute("carro") Carro carro,
                           @RequestParam("imagem") MultipartFile imagem, RedirectAttributes redirectAttributes) {
        try {
            service.atualizarCarro(carro, imagem);
            redirectAttributes.addFlashAttribute("mensagem", "Carro atualizado com sucesso!");
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("mensagem", e.getMessage());
        }
        return "redirect:/carro";
    }

    @DeleteMapping("/{placa}")
    public String deleteCarro(@PathVariable String placa, RedirectAttributes redirectAttributes) {
        try {
            service.deletarCarro(placa);
            redirectAttributes.addFlashAttribute("mensagem", "Carro excluído com sucesso!");
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("mensagem", e.getMessage());
        }
        return "redirect:/carro/listar";
    }
}
