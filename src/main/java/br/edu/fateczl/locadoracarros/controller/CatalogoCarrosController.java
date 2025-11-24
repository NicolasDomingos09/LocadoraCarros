package br.edu.fateczl.locadoracarros.controller;

import br.edu.fateczl.locadoracarros.model.Categoria;
import br.edu.fateczl.locadoracarros.service.CatalogoCarrosService;
import br.edu.fateczl.locadoracarros.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/catalogo/carros")
public class CatalogoCarrosController {

    @Autowired
    private CatalogoCarrosService catalogoCarrosService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String getPage(ModelMap model){
        model.addAttribute("carros", catalogoCarrosService.listarCarrosDisponiveis());
        model.addAttribute("categoria", "Todos os carros");
        return "catalogo_carros";
    }

    @GetMapping("/{id}")
    public String getCarrosCategoria(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("carros", catalogoCarrosService.listarCarrosDisponiveisPorCategoria(id));
        model.addAttribute("categoria", "Categoria: " + categoriaService.getCategoriaPorId(id).getDescricao());
        return "catalogo_carros";
    }

    @GetMapping("/carro/{placa}")
    public String getCarro(@PathVariable("placa") String placa, ModelMap model){
        model.addAttribute("carro", catalogoCarrosService.getCarroPorPlaca(placa));
        return "redirect:/locacao/{placa}";
    }
}
