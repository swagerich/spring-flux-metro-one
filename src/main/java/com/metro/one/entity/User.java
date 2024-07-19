package com.metro.one.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import reactor.core.publisher.Flux;

import java.util.Collection;
import java.util.stream.Stream;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("users")
public class User  implements UserDetails {

    @Id
    @Column("user_id")
    private Long userId;

    private String name;

    @Column("last_name")
    private String lastName;

    @Column("document_type")
    private String documentType;

    @Column("document_number")
    private String documentNumber;

    private String password;

    private Integer phone;

    private String email;

    @Column("card_number")
    private Long cardNumber;

    private String roles;

    @JsonIgnore
    @Transient
    private Flux<TransportCard> transportCards; //METROPOLITANO LINEA 1,LINEA 2

    @Transient
    @JsonIgnore
    private Flux<BankCard> bankCards; //VISA,MASERCARD,AMEX


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Stream.of(roles.split(", ")).map(SimpleGrantedAuthority::new).toList();
    }

    @Override
    public String getUsername() {
        return this.documentNumber;
    }

    @Override
    public  String getPassword(){
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
