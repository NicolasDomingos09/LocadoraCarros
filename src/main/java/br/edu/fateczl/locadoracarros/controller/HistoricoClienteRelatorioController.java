/*
 * Aplicacao do SOLID
 * SRP (Single Responsibility Principle) - A classe tem uma única responsabilidade, que é gerar o relatório de histórico do cliente.
 * DIP (Dependency Inversion Principle) - A classe depende de uma abstração (DataSource), e não de uma implementação concreta.
 */
package br.edu.fateczl.locadoracarros.controller;

import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/relatoriohistorico")
public class HistoricoClienteRelatorioController {

    @Autowired
    private DataSource ds;

    @SuppressWarnings({"rawtypes", "unchecked"})
    @PostMapping("/gerar")
    public ResponseEntity relatorio(@RequestParam("cpf") String cpf, ModelMap model) {
        String erro = "";

        Map<String, Object> reportParams = new HashMap<>();
        reportParams.put("CPF", cpf);

        Connection conn = DataSourceUtils.getConnection(ds);

        //Elementos do report
        byte[] bytes = null;
        InputStreamResource resources = null;
        HttpStatus status = null;
        HttpHeaders header = new HttpHeaders();

        try {
            String path = "classpath:reports/HistoricoCliente.jasper";
            File arquivo = ResourceUtils.getFile(path);
            JasperReport report = (JasperReport) JRLoader
                    .loadObjectFromFile(
                            arquivo.getAbsolutePath()
                    );
            bytes = JasperRunManager.runReportToPdf(report, reportParams, conn);
        } catch (Exception e) {
            erro = e.getMessage();
            status = HttpStatus.BAD_REQUEST;
        } finally {
            if (erro.isEmpty()) {
                ByteArrayInputStream stream =
                        new ByteArrayInputStream(bytes);
                resources = new InputStreamResource(stream);
                status = HttpStatus.OK;
                header.setContentLength(bytes.length);
                header.setContentType(MediaType.APPLICATION_PDF);
            }
        }

        return new ResponseEntity(resources, header, status);

    }
}
