package test.java.br.futurodev.joinville.reciclaville.Mappers;


import test.java.br.futurodev.joinville.reciclaville.dtos.CustomerRequestDto;
import test.java.br.futurodev.joinville.reciclaville.dtos.MaterialRequestDto;
import test.java.br.futurodev.joinville.reciclaville.entities.Customer;
import test.java.br.futurodev.joinville.reciclaville.entities.Material;

public class MaterialMapper {

    public Material toEntity(MaterialRequestDto dto){

        Material material = new Material();

        material.setName(dto.name());

        material.setCompensationPercentage(dto.compensationPercentage());

        return material;
    }

    public Material toDto (MaterialRequestDto dto, Material material ){

        material.setName(dto.name());
        material.setCompensationPercentage(dto.compensationPercentage());

        return material;
    }
}
