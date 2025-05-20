package test.java.br.futurodev.joinville.reciclaville.services;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.java.br.futurodev.joinville.reciclaville.Mappers.CustomerMapper;
import test.java.br.futurodev.joinville.reciclaville.Mappers.DeclarationMapper;
import test.java.br.futurodev.joinville.reciclaville.dtos.CustomerRequestDto;
import test.java.br.futurodev.joinville.reciclaville.dtos.DeclarationItemRequestDto;
import test.java.br.futurodev.joinville.reciclaville.dtos.DeclarationRequestDto;
import test.java.br.futurodev.joinville.reciclaville.entities.Customer;
import test.java.br.futurodev.joinville.reciclaville.entities.Declaration;
import test.java.br.futurodev.joinville.reciclaville.entities.DeclarationItem;
import test.java.br.futurodev.joinville.reciclaville.entities.Material;
import test.java.br.futurodev.joinville.reciclaville.repositories.DeclarationRepository;
import test.java.br.futurodev.joinville.reciclaville.repositories.MaterialRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Getter
@Setter
public class DeclarationService {

    @Autowired
    private DeclarationRepository repository;
    @Autowired
    private MaterialService materialService;

    @Autowired
    private CustomerService customerService;


    public Declaration findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<?> findAll() {

            return repository.findAll();

    }

    public Declaration create(DeclarationRequestDto dto){

        Customer customer = customerService.findById(dto.idCustomer());
        if (customer == null) {
            throw new IllegalArgumentException("Cliente não encontrado com id " + dto.idCustomer());
        }

        DeclarationMapper mapper = new DeclarationMapper();

        Declaration declaration = mapper.toEntity(customer, new ArrayList<>(), dto);

        List<DeclarationItem> itens = new ArrayList<>();

        for(DeclarationItemRequestDto itemDto : dto.declarationItemRequestDto()){

            Material material = materialService.findById(itemDto.materialId());
            if (material == null) {
                throw new IllegalArgumentException("Material com id " + itemDto.materialId() + " não encontrado.");
            }

            DeclarationItem declarationItem = new DeclarationItem(material, itemDto.declaredTonnage());


            declarationItem.setDeclaration(declaration);

            itens.add(declarationItem);
        }


        declaration.setItems(itens);


        return repository.save(declaration);
    }

    public void deleteById (Long Id){
        repository.deleteById(Id);
    }



}
