package br.edu.fateczl.locadoracarros.controller;

import br.edu.fateczl.locadoracarros.model.Categoria;
import br.edu.fateczl.locadoracarros.repository.ICategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private ICategoriaRepository repository;


    @GetMapping
    public String getCategoria(ModelMap model){
        model.addAttribute("categoria", new Categoria());
        model.addAttribute("categorias", new ArrayList<Categoria>());
        return "categoria";
    }

    @GetMapping("/listar")
    public ModelAndView listarCategorias(ModelMap model){
        List<Categoria> categorias = repository.findAll();
        model.addAttribute("categorias", categorias);
        model.addAttribute("categoria", new Categoria());
        return new ModelAndView("categoria");
    }


}
