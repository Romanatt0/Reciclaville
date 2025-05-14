package test.java.br.futurodev.joinville.reciclaville.services;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.java.br.futurodev.joinville.reciclaville.entities.Customer;
import test.java.br.futurodev.joinville.reciclaville.repositories.CustomerRepository;

import java.util.List;

@Service
@Getter
@Setter
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public List<Customer> findAll(){
        return repository.findAll();
    }

    public Customer findById(Long id){
        return repository.findById(id).orElse(null);
    }



}
