package br.usjt.plataforma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import br.usjt.plataforma.model.bean.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	public List <Usuario> findByEmailAndSenha(String email, String senha);
}
