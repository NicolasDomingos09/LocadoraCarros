/*
 * Aplicacao do SOLID
 * SRP (Single Responsibility Principle) - A classe tem uma única responsabilidade, que é controlar a exibição do catálogo de categorias.
 * DIP (Dependency Inversion Principle) - A classe depende de uma abstração (CategoriaService), e não de uma implementação concreta.
 */
package br.edu.fateczl.locadoracarros.controller;

import br.edu.fateczl.locadoracarros.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/catalogo/categorias")
public class CatalogoCategoriasController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String getForm(ModelMap model){
        model.addAttribute("categorias", categoriaService.listarCategorias());
        return "catalogo_categorias";
    }

}
