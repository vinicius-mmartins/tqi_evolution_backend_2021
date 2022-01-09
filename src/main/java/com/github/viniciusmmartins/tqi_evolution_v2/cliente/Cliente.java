package com.github.viniciusmmartins.tqi_evolution_v2.cliente;

import com.github.viniciusmmartins.tqi_evolution_v2.security.UserRole;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "cliente")
public class Cliente implements UserDetails {

    @Id
    @SequenceGenerator(
            name = "cliente_sequence",
            sequenceName = "cliente_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cliente_sequence"
    )
    private Long clienteId;
    private String nome;
    private String email;
    private String CPF;
    private String RG;
    private String endereço;
    private Long renda;
    private String senha;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    private Boolean locked = false;
    private Boolean enabled = true;

    public Cliente(String nome, String email, String CPF, String RG, String endereço, Long renda, String senha, UserRole userRole) {
        this.nome = nome;
        this.email = email;
        this.CPF = CPF;
        this.RG = RG;
        this.endereço = endereço;
        this.renda = renda;
        this.senha = senha;
        this.userRole = userRole;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.name());
        return Collections.singleton(authority);
    }

    @Override
    public String getPassword() {
        return senha;
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
