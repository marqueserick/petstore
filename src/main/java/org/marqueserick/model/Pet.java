package org.marqueserick.model;
import lombok.*;
import org.marqueserick.util.pet.PetStatus;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_PET")
public class Pet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id")
    private Long id;
    private String nome;

    @Enumerated(EnumType.STRING)
    private PetStatus status;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
