/*
 * Aplicacao do SOLID
 * SRP (Single Responsibility Principle) - A classe tem uma única responsabilidade, que é controlar a página inicial.
 * DIP (Dependency Inversion Principle) - A classe depende de abstrações (CatalogoCarrosService, CategoriaService), e não de implementações concretas.
 */
package br.edu.fateczl.locadoracarros.controller;

import br.edu.fateczl.locadoracarros.service.CatalogoCarrosService;
import br.edu.fateczl.locadoracarros.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private CatalogoCarrosService catalogoCarrosService;

    @GetMapping
    public String getPage(ModelMap model){
        model.addAttribute("carros", catalogoCarrosService.listarCarrosDisponiveis());
        model.addAttribute("categoria", "Todos os carros");
        return "catalogo_carros";
    }
}
