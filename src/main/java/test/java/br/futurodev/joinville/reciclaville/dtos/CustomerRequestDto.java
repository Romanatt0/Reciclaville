package test.java.br.futurodev.joinville.reciclaville.dtos;



public record CustomerRequestDto(

        String name,
        String cnpj,
        String economicActivity,
        String responsible
) {
}
