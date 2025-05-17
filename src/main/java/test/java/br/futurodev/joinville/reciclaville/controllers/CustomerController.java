package test.java.br.futurodev.joinville.reciclaville.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import test.java.br.futurodev.joinville.reciclaville.dtos.CustomerRequestDto;
import test.java.br.futurodev.joinville.reciclaville.entities.Customer;
import test.java.br.futurodev.joinville.reciclaville.services.CustomerService;

import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    CustomerService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer post(@RequestBody CustomerRequestDto dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<?> findAll(String search){
        return service.findAll( search);
    }
    @GetMapping("{id}")
    public Customer get(@PathVariable Long id){
        return service.findById(id);
    }

    @PutMapping("{id}")
    public Customer put(@PathVariable Long id,@RequestBody CustomerRequestDto dto ){
        return service.update(id, dto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.deleteById(id);
    }


}
