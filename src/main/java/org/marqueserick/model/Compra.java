package org.marqueserick.model;
import lombok.*;
import org.marqueserick.util.compra.CompraStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_COMPRA")
public class Compra implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "compra_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    private Integer quantidade;

    @Column(name = "dt_compra")
    private LocalDate dataCompra;

    @Enumerated(EnumType.STRING)
    private CompraStatus status;

    private boolean finalizada;

}
