package test.java.br.futurodev.joinville.reciclaville.services;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.java.br.futurodev.joinville.reciclaville.Mappers.CustomerMapper;
import test.java.br.futurodev.joinville.reciclaville.dtos.CustomerRequestDto;
import test.java.br.futurodev.joinville.reciclaville.entities.Customer;
import test.java.br.futurodev.joinville.reciclaville.repositories.CustomerRepository;

import java.util.List;

@Service
@Getter
@Setter
public class CustomerService {

    @Autowired
    private CustomerRepository repository;


    public Customer findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<?> searchByNameOrResponsible(String search){
        return repository.searchByNameOrResponsible(search);
    }

    public List<?> findAll(String search) {
        List<Customer> customers;
        if (search == null || search.isEmpty()) {
            return repository.findAll();
        } else {
            return repository.searchByNameOrResponsible(search);
        }
    }

    public Customer create(CustomerRequestDto dto){
        CustomerMapper mapper = new CustomerMapper();
        return repository.save(mapper.toEntity(dto));
    }

    public void deleteById (Long Id){
        repository.deleteById(Id);
    }

    public Customer update(Long id, CustomerRequestDto dto) {
        Customer customer = findById(id);
            if(customer != null){
                CustomerMapper mapper = new CustomerMapper();
                return repository.save(mapper.toDto(dto, customer));
            }
            return null;
    }


}
