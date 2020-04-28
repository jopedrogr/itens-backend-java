package com.api.controller;

import com.api.dto.ItensDto;
import com.api.model.Itens;
import com.api.repository.ItensRepository;
import com.api.service.SaveItemServiceImpl;
import com.api.service.SearchItemServiceImpl;
import com.api.utils.HandlingImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/item")
public class ItensController {

    @Autowired
    ItensRepository itensRepository;

    @Autowired
    SaveItemServiceImpl saveItemService;

    @Autowired
    SearchItemServiceImpl searchItemService;

    @PostMapping(value = "/upload", consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity receiveData(@RequestBody ItensDto itensDto) throws Exception {
        try {
            saveItemService.save(itensDto);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(path = "/list/{name}")
    public Itens getItem(@PathVariable(value = "name", required = true) String name) throws Exception {
        return searchItemService.search(name);
    }

    @GetMapping(path = "/list/delete/{name}")
    public ResponseEntity deleteItem(@PathVariable(value = "name", required = true) String name) throws Exception {
        try {
            searchItemService.delete(name);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(path = "/list")
    public List<Itens> getItem() throws Exception {
        return searchItemService.searchAll();
    }

}
