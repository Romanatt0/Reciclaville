package test.java.br.futurodev.joinville.reciclaville.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import test.java.br.futurodev.joinville.reciclaville.entities.Customer;

import java.time.LocalDate;
import java.util.List;

public record DeclarationRequestDto(
        Long idCustomer,
        LocalDate periodStartDate,
        LocalDate periodEndDate,
        List<DeclarationItemRequestDto> declarationItemRequestDto

) {
}
