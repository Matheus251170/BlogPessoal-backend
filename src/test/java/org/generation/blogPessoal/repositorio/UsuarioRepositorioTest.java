package org.generation.blogPessoal.repositorio;

import org.generation.blogPessoal.model.Usuario;
import org.generation.blogPessoal.reposiroy.UsuarioRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositorioTest{
	
	@Autowired
	private  UsuarioRepository repositorio;
	
	@BeforeAll
	void start() {
		
		Usuario usuario = new Usuario("Marcos Matheus", "123654");
		usuario = new Usuario("Hajime Isayama", "134652");
		usuario = new Usuario("Dante Alighieri", "123456");
	}
	
	@Test
	public void findByUsuarioRetornaUsuario() throws Exception{
		
		Usuario usuario = repositorio.findByUsuario("Marcos Matheus").get();
		
	}
	
	@AfterAll
	public void end() {
		
		repositorio.deleteAll();
	}
	
	

}
