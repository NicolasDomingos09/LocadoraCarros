package br.edu.fateczl.locadoracarros.controller;

import br.edu.fateczl.locadoracarros.model.Locacao;
import br.edu.fateczl.locadoracarros.model.Reparo;
import br.edu.fateczl.locadoracarros.request.DevolucaoRequest;
import br.edu.fateczl.locadoracarros.service.CarroService;
import br.edu.fateczl.locadoracarros.service.LocacaoService;
import br.edu.fateczl.locadoracarros.service.LocatarioService;
import br.edu.fateczl.locadoracarros.service.ReparoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.time.LocalDate;

@Controller
@RequestMapping("/devolucao")
public class DevolucaoController {

    @Autowired
    private LocacaoService locacaoService;

    @Autowired
    private LocatarioService locatarioService;

    @Autowired
    private ReparoService reparoService;

    @GetMapping("/{id}")
    public String getPage(@PathVariable("id") Long id, ModelMap model, RedirectAttributes redirectAttributes) {
        try {
            Locacao locacao = locacaoService.getLocacaoId(id);

            BigDecimal diasLocacao = new BigDecimal(locacao.getDiasLocacao());
            BigDecimal valorDiaria = BigDecimal.valueOf(locacao.getCarro().getCategoria().getValorDiaria());
            locacao.setValorTotal(diasLocacao.multiply(valorDiaria));

            DevolucaoRequest request = new DevolucaoRequest(locacao, new Reparo());
            
            model.addAttribute("devolucaoRequest", request);
            model.addAttribute("locatario", locatarioService.getLocatarioCpf(locacao.getLocatario().getCpf()));
            return "devolucao";
        } catch (EntityNotFoundException e) {
            redirectAttributes.addFlashAttribute("notFound", true);
            return "redirect:/admin";
        }
    }

    @PostMapping("/devolver")
    public String devolverLocacao(@ModelAttribute("devolucaoRequest") DevolucaoRequest devolucaoRequest,
                                  RedirectAttributes redirectAttributes) {
        try {
            Locacao locacao = locacaoService.getLocacaoId(devolucaoRequest.locacao().getId());
            locacao.setDataDevolucao(LocalDate.now());
            locacao.setValorTotal(devolucaoRequest.locacao().getValorTotal());
            locacao.setValorExtra(devolucaoRequest.locacao().getValorExtra());
            locacaoService.atualizarLocacao(locacao);

            Reparo reparo = devolucaoRequest.reparo();
            reparo.setCarro(locacao.getCarro());
            reparoService.salvarReparo(reparo);

            redirectAttributes.addFlashAttribute("mensagem", "Veículo devolvido com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensagem", "Erro ao devolver o veículo. " + e.getMessage());
        }
        return "redirect:/admin";
    }
}