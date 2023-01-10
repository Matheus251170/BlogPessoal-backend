package org.generation.blogPessoal.controladores;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.generation.blogPessoal.model.Usuario;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioControladorTest {
	
	@Autowired
	private TestRestTemplate testTemplate;
	
	private Usuario usuario;
	
	
	@BeforeAll
	public void start() {
		
		usuario = new Usuario("MArcos Matheus", "123654");
	}
	
	@Disabled
	@Test
	void deveSalvarUsuarioRetornaStatus201() {
		
		HttpEntity<Usuario> request = new HttpEntity<Usuario>(usuario);
		
		ResponseEntity<Usuario> resposta = testTemplate.exchange("/usuario/cadastrar", HttpMethod.POST, request, Usuario.class);
		assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
	}
	
	@Disabled
	@Test
	void deveRetornarListaDeUsuariosRetornaStatus200() {
		
		ResponseEntity<String> resposta = testTemplate.withBasicAuth("Marcos Matheus", "123654").exchange("/usuario/todos", HttpMethod.GET, null, String.class);
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}
	

}
