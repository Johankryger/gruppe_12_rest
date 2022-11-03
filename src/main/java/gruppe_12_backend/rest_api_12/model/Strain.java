package gruppe_12_backend.rest_api_12.model;

import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
public @Data class Strain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String title;

    @Length(max = 1024)
    private String description;
    private String src;
    private int rating;
    private String medical;
    private int energy;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "type_id")
    private StrainType type;
}
