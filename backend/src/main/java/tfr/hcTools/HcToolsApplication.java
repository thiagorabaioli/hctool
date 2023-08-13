package tfr.hcTools;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tfr.hcTools.entities.Operador;
import tfr.hcTools.repositories.OperadorRepository;

@SpringBootApplication
public class HcToolsApplication implements CommandLineRunner{
	
	@Autowired
	private OperadorRepository operadorRepo;

	public static void main(String[] args) {
		SpringApplication.run(HcToolsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	  Operador ope1 = new Operador(null, "Operador 1", "operador1@mail.com", "1234567*1");
	  Operador ope2 = new Operador(null, "Operador 2", "operador2@mail.com", "1234567*2");
	  Operador ope3 = new Operador(null, "Operador 3", "operador3@mail.com", "1234567*3");
	  
	  operadorRepo.saveAll(Arrays.asList(ope1,ope2,ope3));
		
	}

}
