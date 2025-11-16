package usuario.business;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import usuario.business.converter.UsuarioConverter;
import usuario.business.dto.UsuarioDTO;
import usuario.infraestructure.entity.Usuario;
import usuario.infraestructure.repository.UsuarioRepository;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;

    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioConverter.paraUsuario(usuarioDTO);
        return usuarioConverter.paraUsuarioDTO(
                usuarioRepository.save(usuario)
        );
    }


}
