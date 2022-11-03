package gruppe_12_backend.rest_api_12.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
public @Data class Strain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String title;

    private String description;
    private String image;
    private int rating;
    private String medical;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "type_id")
    private StrainType type;
}
