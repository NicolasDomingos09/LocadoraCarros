package br.edu.fateczl.locadoracarros.service;

import br.edu.fateczl.locadoracarros.model.Carro;
import br.edu.fateczl.locadoracarros.repository.ICarroRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CarroService {
    @Autowired
    private ICarroRepository repository;

    @Autowired
    private UploadService uploadService;

    public List<Carro> listarCarros() {
        return repository.findAll();
    }

    public Carro getCarroPorPlaca(String placa) {
        return repository.findById(placa)
                .orElseThrow(() -> new EntityNotFoundException("Carro não encontrado"));
    }

    public void salvarCarro(Carro carro, MultipartFile imagem) throws IOException {
        String path = uploadService.salvarImagemCarro(imagem);
        if (path != null) {
            carro.setImagemPath(path);
        }
        repository.save(carro);
    }

    public void atualizarCarro(Carro carro, MultipartFile imagem) throws IOException {
        String path = uploadService.salvarImagemCarro(imagem);
        if (path != null) {
            carro.setImagemPath(path);
        } else {
            Carro atual = repository.findById(carro.getPlaca()).orElseThrow();
            carro.setImagemPath(atual.getImagemPath());
        }
        repository.save(carro);
    }

    public void deletarCarro(String placa) throws IOException {
        Carro carro = getCarroPorPlaca(placa);
        if (carro.getImagemPath() != null) {
            uploadService.deletarImagem(carro.getImagemPath());
        }
        repository.deleteById(placa);
    }
}
