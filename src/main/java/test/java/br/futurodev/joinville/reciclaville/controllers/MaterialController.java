package test.java.br.futurodev.joinville.reciclaville.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import test.java.br.futurodev.joinville.reciclaville.dtos.MaterialRequestDto;
import test.java.br.futurodev.joinville.reciclaville.entities.Customer;
import test.java.br.futurodev.joinville.reciclaville.entities.Material;
import test.java.br.futurodev.joinville.reciclaville.services.MaterialService;

import java.util.List;

@RestController
@RequestMapping("customers")
public class MaterialController {

    @Autowired
    MaterialService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Material post(@RequestBody MaterialRequestDto dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<?> findAll(){
        return service.findAll();
    }

    @GetMapping("{id}")
    public List<Material> get(@PathVariable String name){
        return service.findByNameIgnoreCase(name);
    }

    @PutMapping("{id}")
    public Material put(@PathVariable Long id,@RequestBody MaterialRequestDto dto ){

        return service.update(id, dto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.deleteById(id);
    }


}
