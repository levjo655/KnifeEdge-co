package Mojodoo.KnifeEdge.co.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Set;

public class SingUpRequest {
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    @NotBlank//message= "Username can't be blank"
    @Size(min = 4, max = 25)
    private String userName;

    @NotBlank//message= "Email can't be blank"
    @Size(min = 4, max = 25)
    private String email;

    @NotBlank//message= "Password can't be blank"
    @Size(min = 4, max = 25)
    private String password;

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    private Set<String> roles;
}



