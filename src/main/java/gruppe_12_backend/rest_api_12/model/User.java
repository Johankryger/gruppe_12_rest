package gruppe_12_backend.rest_api_12.model;


import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "user_table") //is for hibernate.
public class User {
    
    
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "user_sequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birthday")
    private Date birthday;

    public User() {
    }

    public User(String username, String first_name, String last_name, String email, String password, String gender, Date birthday) {
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
    }

//    public User(String first_name, String last_name, String email, String password) {
//        this.first_name = first_name;
//        this.last_name = last_name;
//        this.email = email;
//        this.password = password;
//    }
//
//    public User(Long id, String first_name, String last_name, String email, String password) {
//        this.id = id;
//        this.first_name = first_name;
//        this.last_name = last_name;
//        this.email = email;
//        this.password = password;
//    }

//    public String getFirst_name() {
//        return first_name;
//    }
//
//    public void setFirst_name(String firstName) {
//        this.first_name = firstName;
//    }
//
//    public String getLast_name() {
//        return last_name;
//    }
//
//    public void setLast_name(String sureName) {
//        this.last_name = sureName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", firstName='" + first_name + '\'' +
//                ", sureName='" + last_name + '\'' +
//                ", email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                '}';
//    }
}
