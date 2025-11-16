package usuario.infraestructure.repository;


import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import usuario.infraestructure.entity.Usuario;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    /*
        faz a ligação com o banco de dados, cada classe tem a sua repository
        nomenclatura
        JpaRepository<Nome da classe, tipo de id>
     */

    boolean existsByEmail(String email);

    Optional<Usuario> findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);

}
