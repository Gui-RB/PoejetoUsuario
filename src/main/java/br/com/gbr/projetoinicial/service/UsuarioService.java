package br.com.gbr.projetoinicial.service;


import br.com.gbr.projetoinicial.dto.UsuarioDTO;
import br.com.gbr.projetoinicial.entiy.UsuarioEntity;
import br.com.gbr.projetoinicial.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired //injeta as depedencias necessarias (service precisa de das dependecias de repository para fazer as requicições)
    private UsuarioRepository usuarioRepository;


    public List<UsuarioDTO> listarTodos() {// cria uma lista para exibir todos os usuarios
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();  //procura os usuarios
        return usuarios.stream().map(UsuarioDTO::new).toList();
//      (.stream) Converte a coleção de usuarios em um Stream asssim podendo ser manipulada.
//      (.map) Mapeia cada Usuario para um novo UsuarioDto usando o construtor UsuarioDto(Usuario usuario).
//      (.tolist) Coleta os resultados do Stream em uma nova lista.
    }

    public void inserir(UsuarioDTO usuario) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario); //recebe um usuario dto e o converte com o construtor
        usuarioRepository.save(usuarioEntity);                    //"UsuarioEntity()" para um usario entity
        //(.save) recebe e cria um usuario.
    }

    public UsuarioDTO alterar(UsuarioDTO usuario){
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);        //recebe um usuario dto e o converte com o construtor
        return new UsuarioDTO(usuarioRepository.save(usuarioEntity));    //"UsuarioEntity()" para um usario entity
        //(.save) o metodo save se já exitir um usuario no campo salva o novo por cima
    }

    public void excluir(Long id){
        UsuarioEntity usuarioEntity = usuarioRepository.findById(id).get(); // o usuarioEntity recebe um id
        usuarioRepository.delete(usuarioEntity);  // o metodo delete apaga o id recebido
        //como não retorna nada ao front não se usa um usuarioDTO
    }


    public UsuarioDTO buscarPeloId (Long id){
        return new UsuarioDTO(usuarioRepository.findById(id).get()) ;
    }
}
