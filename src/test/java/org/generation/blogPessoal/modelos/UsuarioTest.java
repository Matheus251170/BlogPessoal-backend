package org.generation.blogPessoal.modelos;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.generation.blogPessoal.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UsuarioTest {
	
	public Usuario usuario;
	
	@Autowired
	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	Validator validator = factory.getValidator();
	
	@BeforeEach
	public void start() {
		
		usuario = new Usuario("Marcos Matheus", "123654");

	}
	
	@Test
	void testValidaAtributos() {
		
		Set<ConstraintViolation<Usuario>> violacao = validator.validate(usuario);
		System.out.println(violacao.toString());
		assertTrue(violacao.isEmpty());
	}
	
	@Test
	void testValidaAtributosNulos() {
		
		Usuario usuarioErro = new Usuario();
		usuarioErro.setUsuario("Dante Alighieri");
		Set<ConstraintViolation<Usuario>> violacao = validator.validate(usuarioErro);
		System.out.println(violacao.toString());
		assertFalse(violacao.isEmpty());
	}

}
