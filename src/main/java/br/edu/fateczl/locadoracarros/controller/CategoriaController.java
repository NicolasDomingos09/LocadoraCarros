package br.edu.fateczl.locadoracarros.controller;

import br.edu.fateczl.locadoracarros.model.Categoria;
import br.edu.fateczl.locadoracarros.service.CategoriaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public String getCategoria(ModelMap model) {
        model.addAttribute("categoria", new Categoria());
        model.addAttribute("categorias", new ArrayList<Categoria>());
        return "categoria";
    }

    @GetMapping("/listar")
    public String listarCategorias(ModelMap model) {
        model.addAttribute("categorias", service.listarCategorias());
        model.addAttribute("categoria", new Categoria());
        return "categoria";
    }

    @GetMapping("/{id}")
    public String getCategoriaPorId(@PathVariable Long id, ModelMap model) {
        try {
            model.addAttribute("categoria", service.getCategoriaPorId(id));
        } catch (EntityNotFoundException e) {
            model.addAttribute("erro", e.getMessage());
            return "redirect:/categoria";
        }
        model.addAttribute("categorias", new ArrayList<Categoria>());
        return "categoria";
    }

    @PostMapping
    public String postCategoria(@ModelAttribute("categoria") Categoria categoria,
                                @RequestParam("imagem") MultipartFile imagem, ModelMap model) {
        try {
            service.salvarCategoria(categoria, imagem);
        } catch (IOException e) {
            model.addAttribute("erro", e.getMessage());
        }
        return "redirect:/categoria";
    }

    @PutMapping
    public String putCategoria(@ModelAttribute("categoria") Categoria categoria,
                               @RequestParam("imagem") MultipartFile imagem, ModelMap model) {
        try {
            service.atualizarCategoria(categoria, imagem);
        } catch (IOException e) {
            model.addAttribute("erro", e.getMessage());
        }
        return "redirect:/categoria";
    }

    @DeleteMapping("/{id}")
    public String deleteCategoria(@PathVariable Long id, ModelMap model) {
        try {
            service.deletarCategoria(id);
        } catch (IOException e) {
            model.addAttribute("erro", e.getMessage());
        }
        return "redirect:/categoria/listar";
    }
}
