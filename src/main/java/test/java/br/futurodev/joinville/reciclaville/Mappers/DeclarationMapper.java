package test.java.br.futurodev.joinville.reciclaville.Mappers;

import test.java.br.futurodev.joinville.reciclaville.dtos.CustomerRequestDto;
import test.java.br.futurodev.joinville.reciclaville.dtos.DeclarationRequestDto;
import test.java.br.futurodev.joinville.reciclaville.dtos.MaterialRequestDto;
import test.java.br.futurodev.joinville.reciclaville.entities.Customer;
import test.java.br.futurodev.joinville.reciclaville.entities.Declaration;
import test.java.br.futurodev.joinville.reciclaville.entities.DeclarationItem;
import test.java.br.futurodev.joinville.reciclaville.entities.Material;

import java.util.List;

public class DeclarationMapper {
    public Declaration toEntity(Customer customer, List<DeclarationItem> DeclarationItems, DeclarationRequestDto dto){

        Declaration declaration = new Declaration();

        declaration.setCustomer(customer);

        declaration.setPeriodStartDate(dto.periodStartDate());

        declaration.setPeriodEndDate(dto.periodEndDate());

       declaration.setItems(DeclarationItems);

        return declaration;
    }
}
