package org.marqueserick.service;

import org.marqueserick.dto.CompraDto;
import org.marqueserick.factory.CompraFactory;
import org.marqueserick.model.Compra;
import org.marqueserick.repository.CompraRepository;
import org.marqueserick.util.compra.CompraStatus;
import org.marqueserick.util.pet.PetStatus;
import org.marqueserick.util.pet.PetUtils;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.marqueserick.util.pet.PetValidador.isPetDisponivel;

@Transactional
@ApplicationScoped
public class CompraService {

    @Inject
    private CompraRepository repository;

    @Inject
    private PetService petService;

    @Inject
    private CompraFactory factory;

    public List<CompraDto> listarTodas(){
        return factory.listartodosDto(repository.listAll());
    }

    public CompraDto listarPorId(Long id) {
        Compra compra = buscarPorId(id, "Compra não localizada");
        return factory.toDto(compra);
    }

    public CompraDto adicionar(CompraDto compraDto) {
        validarPetDisponivel(compraDto);
        Compra compra = factory.toCompra(compraDto);
        novaCompra(compra);
        repository.persist(compra);
        return factory.toDto(compra);
    }

    public void deletar(Long id) {
        Compra compra = buscarPorId(id,"Compra não localizada com ID informado");
        repository.deleteById(id);
    }
    public Map<String, Long> retornaInventario() {
        return PetUtils.retornaInventario();
    }

    private Compra buscarPorId(Long id, String mensagem) {
        Optional<Compra> compra = repository.findByIdOptional(id);
        if(compra.isEmpty())throw new RuntimeException(mensagem);
        return compra.get();
    }
    private void novaCompra(Compra compra){
        compra.setDataCompra(LocalDate.now());
        compra.setFinalizada(false);
        compra.setStatus(CompraStatus.SOLICITADA);
    }

    private void validarPetDisponivel(CompraDto compraDto){
        Compra compra = factory.toCompra(compraDto);
        Long id = compra.getPet().getId();
        if(!isPetDisponivel(id)) throw new RuntimeException("Pet não disponível");
    }
}
