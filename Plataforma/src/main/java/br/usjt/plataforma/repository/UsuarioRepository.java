package br.usjt.plataforma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.usjt.plataforma.model.bean.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	@Query("SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha")
	public Usuario get(String email, String senha);
}
