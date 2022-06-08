package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.Usuario;
import com.educandoweb.course.entities.enums.OrderStatus;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UsuarioRepository;
/*Para fazer com que execute a associação da instancia usuarioRepository com a 
 * a Classe TestConfig, é necessário implementar a interface CommandLineRunner*/
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	/*Classe TestConfig serve para fazer o database seeding
	 *Dependencia deve ser fraca
	 *Para que o spring consiga resolver a dependencia
	 * associar uma instancia do usuarioRepository com a Classe TestConfig 
	 * basta colocar em cima do atributo o anotation @Autowired
	 * com essa anotação o proprio spring vai resolver a dependencia e associar
	 * 
	 */
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {

		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "98888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "9777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.WAITING_PAYMENT, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.PAID, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.PAID, u1);
		
		/*Para salvar os usuários no banco de dados, vou chamar o usuarioRepository*/
		usuarioRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
		
	}
}
