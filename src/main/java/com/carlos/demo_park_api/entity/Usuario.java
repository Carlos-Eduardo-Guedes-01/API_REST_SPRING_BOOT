package com.carlos.demo_park_api.entity;

//Para mapeamento correto da data de criação e de atualização de informações
import java.time.LocalDateTime;

//Importação para serialização da classe
import java.io.Serializable;

//Importação para diferenciação entre usuários e ADMs
import javax.management.relation.Role;

//Importação da Entity
import jakarta.persistence.*;

//Importação de lombok para get and set
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    // Abaixo ID da tabela usuario
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // Column acompanha cada atributo para mapeamento na hora de criar o banco de
    // dados
    @Column(name = "password", nullable = false, unique = false, length = 200)
    private String password;
    @Column(name = "role", nullable = false, length = 25)
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(name = "data_criacao")
    private LocalDateTime dataCriação;
    @Column(name = "data_alteracao")
    private LocalDateTime dataAlteração;
    @Column(name = "criado_por")
    private String criadoPor;
    @Column(name = "alterado_por")
    private String alteradoPor;

    @Override
    public String toString() {
        return "Usuario [id=" + id + "]";
    }

    @Column(name = "username", nullable = false, unique = true, length = 100)
    private String username;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public enum Role {
        ROLE_ADMIN, ROLE_CLIENTE
    }

}
