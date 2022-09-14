package org.marqueserick.dto;

import lombok.*;
import org.marqueserick.util.compra.CompraStatus;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompraDto {

    @JsonbProperty("compraId")
    private Long id;
    @JsonbProperty("pet")
    private PetDto petDto;
    private Integer quantidade;
    @JsonbDateFormat("dd/MM/uuuu")
    private LocalDate dataCompra;
    @JsonbProperty("statusCompra")
    private CompraStatus status;
    private boolean finalizada;

}
