package test.java.br.futurodev.joinville.reciclaville.Mappers;


import test.java.br.futurodev.joinville.reciclaville.dtos.CustomerRequestDto;
import test.java.br.futurodev.joinville.reciclaville.entities.Customer;

public class CustomerMapper {

    public Customer toEntity(CustomerRequestDto dto){

        Customer customer = new Customer();

        customer.setName(dto.name());

        customer.setCnpj(dto.cnpj());

        customer.setEconomicActivity(dto.economicActivity());

        customer.setResponsible(dto.responsible());

        return customer;
    }

    public Customer toDto (CustomerRequestDto dto, Customer customer ){

        customer.setName(dto.name());
        customer.setCnpj(dto.cnpj());
        customer.setEconomicActivity(dto.economicActivity());
        customer.setResponsible(dto.responsible());

        return customer;
    }
}
