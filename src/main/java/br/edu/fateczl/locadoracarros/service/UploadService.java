package br.edu.fateczl.locadoracarros.service;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class UploadService {

    public String salvarImagemCategoria(MultipartFile imagem) throws IOException {

        if (imagem.isEmpty()) {
            return null;
        }

        String nomeArquivo = UUID.randomUUID() + "_" + imagem.getOriginalFilename();

        Path destino = Paths.get("src/main/resources/static/uploads/categorias/" + nomeArquivo);
        Files.createDirectories(destino.getParent());
        Files.copy(imagem.getInputStream(), destino);

        return "/uploads/categorias/" + nomeArquivo;
    }

    public String salvarImagemCarro(MultipartFile imagem) throws IOException {

        if (imagem.isEmpty()) {
            return null;
        }

        String nomeArquivo = UUID.randomUUID() + "_" + imagem.getOriginalFilename();

        Path destino = Paths.get("src/main/resources/static/uploads/carros/" + nomeArquivo);
        Files.createDirectories(destino.getParent());
        Files.copy(imagem.getInputStream(), destino);

        return "/uploads/carros/" + nomeArquivo;
    }

    public void deletarImagem(String imagemPath) throws IOException {
        Path path = Paths.get("src/main/resources/static" + imagemPath);
        Files.deleteIfExists(path);
    }
}
