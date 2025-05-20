package test.java.br.futurodev.joinville.reciclaville.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import test.java.br.futurodev.joinville.reciclaville.dtos.CustomerRequestDto;
import test.java.br.futurodev.joinville.reciclaville.dtos.DeclarationRequestDto;
import test.java.br.futurodev.joinville.reciclaville.entities.Customer;
import test.java.br.futurodev.joinville.reciclaville.entities.Declaration;
import test.java.br.futurodev.joinville.reciclaville.services.CustomerService;
import test.java.br.futurodev.joinville.reciclaville.services.DeclarationService;

import java.util.List;

@RestController
@RequestMapping("declarations")
public class DeclationController {

    @Autowired
    DeclarationService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Declaration post(@RequestBody DeclarationRequestDto dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<?> findAll(){
        return service.findAll();
    }

    
   @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.deleteById(id);
    }


}
