package test.java.br.futurodev.joinville.reciclaville.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import test.java.br.futurodev.joinville.reciclaville.dtos.CustomerResponseDto;
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
    public Customer post(@RequestBody CustomerResponseDto dto) {
        return service.create(dto);

    }

    @GetMapping
    public List<Customer> findAll(){
        return service.findAll();
    }

    @GetMapping("{id}")
    public Customer findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PutMapping("{id}")
    public Customer put(@PathVariable Long id,@RequestBody CustomerResponseDto dto ){
        return service.update(id, dto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.deleteById(id);
    }
}
