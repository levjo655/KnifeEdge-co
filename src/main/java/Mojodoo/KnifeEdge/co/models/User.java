package Mojodoo.KnifeEdge.co.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.management.relation.Role;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Document(collection= "user")
public class User {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Id
    private String id;

    @NotBlank
    @Size(max= 50)
    private String username;

    @NotBlank
    @Email
    @Indexed(unique = true)
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;

    @CreatedDate
    private Date createdAt;

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @DBRef
    private Set<Role> roles = new HashSet<>();
    @DBRef
    private Set<Knife> knives = new HashSet<>();


    public User (String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password= password;
    }

    public User (){

    }
    public Set<Knife> getKnives() {
        return knives;
    }

    public void setKnives(Set<Knife> knives) {
        this.knives = knives;
    }

    // Add knife to user
    public void addKnife(Knife knife) {
        this.knives.add(knife);
    }


}
