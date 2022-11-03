package gruppe_12_backend.rest_api_12.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public @Data class StrainType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String src;
    private String origin;
    private String description;
    private String ratio;
    private String effects;
}
