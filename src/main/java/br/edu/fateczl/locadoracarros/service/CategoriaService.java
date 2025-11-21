package br.edu.fateczl.locadoracarros.service;

import br.edu.fateczl.locadoracarros.model.Categoria;
import br.edu.fateczl.locadoracarros.repository.ICategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private ICategoriaRepository repository;

    @Autowired
    private UploadService uploadService;

    public List<Categoria> listarCategorias() {
        return repository.findAll();
    }

    public Categoria getCategoriaPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada"));
    }

    public void salvarCategoria(Categoria categoria, MultipartFile imagem) throws IOException {
        String path = uploadService.salvarImagem(imagem);
        if (path != null) {
            categoria.setImagemPath(path);
        }
        repository.save(categoria);
    }

    public void atualizarCategoria(Categoria categoria, MultipartFile imagem) throws IOException {
        String path = uploadService.salvarImagem(imagem);
        if (path != null) {
            categoria.setImagemPath(path);
        } else {
            Categoria atual = repository.findById(categoria.getId()).orElseThrow();
            categoria.setImagemPath(atual.getImagemPath());
        }
        repository.save(categoria);
    }

    public void deletarCategoria(Long id) throws IOException {
        Categoria categoria = getCategoriaPorId(id);
        if (categoria.getImagemPath() != null) {
            Path imagePath = Paths.get("src/main/resources/static" + categoria.getImagemPath());
            Files.deleteIfExists(imagePath);
        }
        repository.deleteById(id);
    }
}
