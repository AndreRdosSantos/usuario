package usuario.infraestructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity //identifica a Classe como uma Tabela (BD)
@Table(name = "usuario") //nomeia a tabela, caso contrario o nome padrão é o nome da classe
public class Usuario implements UserDetails { //implementa interface do spring security

//UserDetails é um gerenciador de acesso

    @Id //identifica o atributo como id unico
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gera o id automaticamente
    private Long id;
    @Column(name = "nome", length = 100) //identifica o atributo como uma coluna e limita o seu tamanho
    private String nome;
    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "senha")
    private String senha;
    @OneToMany(cascade = CascadeType.ALL) //um para muitos, cascade significa que apaga em cascata
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private List<Endereco> enderecos;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private List<Telefone> telefones;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
