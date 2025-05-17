package test.java.br.futurodev.joinville.reciclaville.services;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.java.br.futurodev.joinville.reciclaville.Mappers.CustomerMapper;
import test.java.br.futurodev.joinville.reciclaville.Mappers.MaterialMapper;
import test.java.br.futurodev.joinville.reciclaville.dtos.CustomerRequestDto;
import test.java.br.futurodev.joinville.reciclaville.dtos.MaterialRequestDto;
import test.java.br.futurodev.joinville.reciclaville.entities.Customer;
import test.java.br.futurodev.joinville.reciclaville.entities.Material;
import test.java.br.futurodev.joinville.reciclaville.repositories.CustomerRepository;
import test.java.br.futurodev.joinville.reciclaville.repositories.MaterialRepository;

import java.util.List;

@Service
@Getter
@Setter
public class MaterialService {

    @Autowired
    private MaterialRepository repository;


    public Material findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<Material> findByNameIgnoreCase(String search){
        return repository.findByNameIgnoreCase(search);
    }

    public List<Material> findAll() {

        return repository.findAll();
    }

    public Material create(MaterialRequestDto dto){
        MaterialMapper mapper = new MaterialMapper();
        return repository.save(mapper.toEntity(dto));
    }

    public void deleteById (Long Id){
        repository.deleteById(Id);
    }

    public Material update(Long id, MaterialRequestDto dto) {
        Material material = findById(id);
            if(material != null){
                MaterialMapper mapper = new MaterialMapper();
                return repository.save(mapper.toDto(dto, material));
            }
            return null;
    }


}
