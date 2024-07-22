package br.com.gbr.projetoinicial.controller;

import br.com.gbr.projetoinicial.dto.UsuarioDTO;
import br.com.gbr.projetoinicial.entiy.UsuarioEntity;
import br.com.gbr.projetoinicial.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//diz ao spring que essa classe é responsavel pelas requisições https
@RequestMapping(value = "/usuario") //  diz ao spring que todo protocolo de requisição q tiver /usuario é direcioanado a essa classe
public class UsuarioController {

    @Autowired //injeta as dependecias necessarias (controller recebe de service para usar os metodos CRUDS)
    private UsuarioService usuarioService;

    @GetMapping //mapea a requisição get http
    public List<UsuarioDTO> listarTodos(){
       return usuarioService.listarTodos();
    }

    @PostMapping // mapea a requisição post do http
    public void inserir (@RequestBody UsuarioDTO usuario){  //@RequestBody diz que o corpo da reuisção também deve ser lido
        usuarioService.inserir(usuario);
    }

    @PutMapping
    public UsuarioDTO altera(@RequestBody UsuarioDTO usuario){
        return usuarioService.alterar(usuario);
    }

    // a requisição de exclusão vem na url '/{id}' vem para dizer que quermos buscar o id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){ //Reponse entity é o responsavel por dizer se a
        usuarioService.excluir(id);                                   //requisição foi feita com sucesso ou não
        return ResponseEntity.ok().build(); // ok comunica que sim e .build constroi a resposta
    }
}
