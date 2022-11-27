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
    private Long id;

    @Column(unique = true)
    private String title;

    @Length(max = 1024)
    private String description;

    @Column(name = "address")
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
