package gruppe_12_backend.rest_api_12.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity
public @Data
class Strain {
    private int id;
    private String title;
    private String description;
    private String image;
    private int rating;
    private String medical;
    private String type;
}
