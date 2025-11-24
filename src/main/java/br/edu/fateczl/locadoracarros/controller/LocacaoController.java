package br.edu.fateczl.locadoracarros.controller;

import br.edu.fateczl.locadoracarros.model.Carro;
import br.edu.fateczl.locadoracarros.model.Locacao;
import br.edu.fateczl.locadoracarros.model.Locatario;
import br.edu.fateczl.locadoracarros.request.LocacaoRequest;
import br.edu.fateczl.locadoracarros.service.CarroService;
import br.edu.fateczl.locadoracarros.service.LocacaoService;
import br.edu.fateczl.locadoracarros.service.LocatarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/locacao")
public class LocacaoController {

    @Autowired
    private CarroService carroService;

    @Autowired
    private LocatarioService locatarioService;

    @Autowired
    private LocacaoService locacaoService;

    @GetMapping("/{placa}")
    public String getPage(@PathVariable String placa, ModelMap model) {
        Carro carro = carroService.getCarroPorPlaca(placa);
        model.addAttribute("carro", carro);
        model.addAttribute("locacaoRequest", new LocacaoRequest(new Locacao(), new Locatario(), carro));
        return "locacao";
    }

    @PostMapping("/{placa}")
    public String postLocacao(@ModelAttribute("locacaoRequest") LocacaoRequest locacaoRequest,
                              @PathVariable("placa") String placa,
                              ModelMap model) {
        Locacao locacao = locacaoRequest.locacao();
        Locatario locatario = locacaoRequest.locatario();
        Carro carro = carroService.getCarroPorPlaca(placa);

        locacao.setCarro(carro);
        locacao.setLocatario(locatario);

        locatarioService.salvarLocatario(locatario);
        locacaoService.salvarLocacao(locacao);

        model.addAttribute("sucesso", true);
        model.addAttribute("carro", carro);
        model.addAttribute("locacaoRequest", locacaoRequest);

        locacao = locacaoService.buscarPorDataCarroELocatario(locacao.getDataRetirada(), placa, locatario.getCpf());
        model.addAttribute("protocolo", locacao.getId());
        return "locacao";
    }

}
