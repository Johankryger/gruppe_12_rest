package gruppe_12_backend.rest_api_12.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.geo.Point;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public @Data class Distributor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String title;

    @Length(max = 1024)
    private String description;

    @Column(columnDefinition = "point")
    private Point coordinate;

}
