package com.example.Thesis.Models;

import com.example.Thesis.Enums.UserRol;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;


@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "users")
public class User implements UserDetails {
    //UserDetails implements the security methods of the module security
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String identificationNumber;
    private String address;
    private String zipCode;
    private String city;
    private String state;
    private String country;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRol userRol;
    private Boolean locked = false;
    private Boolean enabled = false;


    //Id is auto generated, this is a constructor without the id
    public User(String firstName, String lastName, String identificationNumber, String address, String zipCode,
                String city, String state, String country, String email, String password, UserRol userRol) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.identificationNumber = identificationNumber;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
        this.country = country;
        this.email = email;
        this.password = password;
        this.userRol = userRol;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRol.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}