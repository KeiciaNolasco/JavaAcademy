package academiajava.jpa.model;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DependenteId implements Serializable {

    private Integer cliente;
    private Integer dependente;

}