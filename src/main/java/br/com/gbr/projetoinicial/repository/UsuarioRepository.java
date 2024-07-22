package br.com.gbr.projetoinicial.repository;

import br.com.gbr.projetoinicial.entiy.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity , Long> {
}
