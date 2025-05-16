package test.java.br.futurodev.joinville.reciclaville.services;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.java.br.futurodev.joinville.reciclaville.Mappers.CustomerMapper;
import test.java.br.futurodev.joinville.reciclaville.dtos.CustomerResponseDto;
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

    public Customer create(CustomerResponseDto dto){

        CustomerMapper mapper = new CustomerMapper();

        return repository.save(mapper.toEntity(dto));
    }

    public void deleteById (Long Id){
        repository.deleteById(Id);
    }


    public Customer update(Long id, CustomerResponseDto dto) {
        Customer customer = findById(id);
            if(customer != null){
                CustomerMapper mapper = new CustomerMapper();
                return repository.save(mapper.toDto(dto, customer));
            }
            return null;
    }


}
