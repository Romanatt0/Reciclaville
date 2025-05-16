package test.java.br.futurodev.joinville.reciclaville.dtos;



public record CustomerResponseDto(

        String name,
        String cnpj,
        String economicActivity,
        String responsible
) {
}
