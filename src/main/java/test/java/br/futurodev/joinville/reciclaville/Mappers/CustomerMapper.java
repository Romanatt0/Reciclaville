package test.java.br.futurodev.joinville.reciclaville.Mappers;

import lombok.Getter;
import lombok.Setter;
import test.java.br.futurodev.joinville.reciclaville.dtos.CustomerResponseDto;
import test.java.br.futurodev.joinville.reciclaville.entities.Customer;

public class CustomerMapper {

    public Customer toEntity(CustomerResponseDto dto){

        Customer customer = new Customer();

        customer.setName(dto.name());

        customer.setCnpj(dto.cnpj());

        customer.setEconomicActivity(dto.economicActivity());

        customer.setResponsible(dto.responsible());

        return customer;
    }

    public Customer toDto (CustomerResponseDto dto, Customer customer ){

        customer.setName(dto.name());
        customer.setCnpj(dto.cnpj());
        customer.setEconomicActivity(dto.economicActivity());
        customer.setResponsible(dto.responsible());

        return customer;
    }
}
