package academiajava.jpa.model;

import lombok.*;
import jakarta.persistence.*;

@Entity
@IdClass(DependenteId.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dependente {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="COD_CLI", nullable=false)
    private Cliente cliente;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="COD_DEP", nullable=false)
    private Cliente dependente;

    @Column(name="Parentesco", nullable=false)
    private String parentesco;

    @Override
    public String toString() {
        return "\n" + cliente +
                "\nDEPENDENTE: " + dependente +
                "\nPARENTESCO: " + parentesco;
    }
}
