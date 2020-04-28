package com.api.service;

import com.api.dto.ItensDto;
import com.api.model.Itens;
import com.api.repository.ItensRepository;
import com.api.utils.HandlingImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class SaveItemServiceImpl {

    @Autowired
    private ItensRepository itensRepository;

    public void save(String name, String description, MultipartFile image) throws Exception{
        Itens item = new Itens();
        item.setName(name);
        item.setDescription(description);
        //item.setImage(HandlingImage.compressBytes(image.getBytes()));
        itensRepository.saveAndFlush(item);
    }

    public void save(ItensDto itensDto) {
        Itens item = new Itens();
        item.setName(itensDto.getName());
        item.setDescription(itensDto.getDescription());
        item.setImage(itensDto.getImage());
        itensRepository.saveAndFlush(item);
    }

}
