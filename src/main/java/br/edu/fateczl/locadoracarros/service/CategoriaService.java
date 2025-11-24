/*
 * Aplicacao do SOLID
 * SRP (Single Responsibility Principle) - A classe tem uma única responsabilidade, que é gerenciar as regras de negócio de Categoria.
 * DIP (Dependency Inversion Principle) - A classe depende de abstrações (ICategoriaRepository, UploadService), e não de implementações concretas.
 */
package br.edu.fateczl.locadoracarros.service;

import br.edu.fateczl.locadoracarros.model.Categoria;
import br.edu.fateczl.locadoracarros.repository.ICategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private ICategoriaRepository repository;

    @Autowired
    private UploadService uploadService;

    @Transactional(readOnly = true)
    public List<Categoria> listarCategorias() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Categoria getCategoriaPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada"));
    }

    @Transactional
    public void salvarCategoria(Categoria categoria, MultipartFile imagem) throws IOException {
        String path = uploadService.salvarImagemCategoria(imagem);
        if (path != null) {
            categoria.setImagemPath(path);
        }
        repository.save(categoria);
    }

    @Transactional
    public void atualizarCategoria(Categoria categoria, MultipartFile imagem) throws IOException {
        String path = uploadService.salvarImagemCategoria(imagem);
        if (path != null) {
            categoria.setImagemPath(path);
        } else {
            Categoria atual = repository.findById(categoria.getId()).orElseThrow();
            categoria.setImagemPath(atual.getImagemPath());
        }
        repository.save(categoria);
    }

    @Transactional
    public void deletarCategoria(Long id) throws IOException {
        Categoria categoria = getCategoriaPorId(id);
        if (categoria.getImagemPath() != null) {
            uploadService.deletarImagem(categoria.getImagemPath());
        }
        repository.deleteById(id);
    }
}
