package com.api.service;

import com.api.model.Itens;
import com.api.repository.ItensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SearchItemServiceImpl {

    @Autowired
    private ItensRepository itensRepository;

    public Itens search(Long id) throws Exception {
        Optional<Itens> optionalItens = itensRepository.findById(id);
        Itens item = null;
        if (!optionalItens.isPresent()){
            throw new Exception("Item not found: " + id);
        }else{
            item = optionalItens.get();
        }
        return item;
    }

    public Itens search(String name) throws Exception {
        Optional<Itens> optionalItens = itensRepository.findByName(name);
        Itens item = null;
        if (!optionalItens.isPresent()){
            throw new Exception("Item not found: " + name);
        }else{
            item = optionalItens.get();
        }
        return item;
    }

    public void delete(String name) throws Exception {
        Optional<Itens> optionalItens = itensRepository.findByName(name);
        if (!optionalItens.isPresent()) {
            throw new Exception("Item not found: " + name);
        } else {
            itensRepository.delete(optionalItens.get());
        }
    }

    public List<Itens> searchAll() throws Exception {
        return itensRepository.findAll();
    }

}
