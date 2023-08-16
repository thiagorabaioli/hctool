package tfr.hcTools;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tfr.hcTools.entities.Cliente;
import tfr.hcTools.entities.Endereco;
import tfr.hcTools.entities.Localidade;
import tfr.hcTools.entities.Operador;
import tfr.hcTools.entities.Zona;
import tfr.hcTools.entities.enums.TipoCliente;
import tfr.hcTools.repositories.ClienteRepository;
import tfr.hcTools.repositories.EnderecoRepository;
import tfr.hcTools.repositories.LocalidadeRepository;
import tfr.hcTools.repositories.OperadorRepository;
import tfr.hcTools.repositories.ZonaRepository;

@SpringBootApplication
public class HcToolsApplication implements CommandLineRunner{
	
	@Autowired
	private OperadorRepository operadorRepo;
	
	@Autowired
	private LocalidadeRepository localidadeRepo;
	
	@Autowired
	private ZonaRepository zonaRepo;
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	@Autowired
	private EnderecoRepository enderecoRepo;


	public static void main(String[] args) {
		SpringApplication.run(HcToolsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	  Operador ope1 = new Operador(null, "Operador 1", "operador1@mail.com", "1234567*1");
	  ope1.getTelefones().addAll(Arrays.asList("911112323"));
	  
	  
	  Operador ope2 = new Operador(null, "Operador 2", "operador2@mail.com", "1234567*2");
	  ope2.getTelefones().addAll(Arrays.asList("921112324"));
	  
	  Operador ope3 = new Operador(null, "Operador 3", "operador3@mail.com", "1234567*3");
	  ope3.getTelefones().addAll(Arrays.asList("931112324"));
	  
 
	  operadorRepo.saveAll(Arrays.asList(ope1,ope2,ope3));
	  
	  Zona zona1 = new  Zona(null, "Centro");
	  Zona zona2 = new Zona(null, "Lisboa");
	  
	  Localidade local1 = new Localidade(null, "Leiria", zona1);
	  Localidade local2 = new Localidade(null, "Benfica", zona2);
	  
	  zona1.getLocalidades().addAll(Arrays.asList(local1));
	  zona2.getLocalidades().addAll(Arrays.asList(local2));
	  
	  zonaRepo.saveAll(Arrays.asList(zona1,zona2));
	  localidadeRepo.saveAll(Arrays.asList(local1,local2));
	  
	  
	  Cliente cli1 = new Cliente(null, "Cliente 1", "cliente1@mail.com", "232323231", TipoCliente.PESSOAFISICA);
	  cli1.getTelefone().addAll(Arrays.asList("911111111"));
	  
	  Cliente cli2 = new Cliente(null, "Cliente 2", "cliente2@mail.com", "232323232", TipoCliente.EMPRESARIAL);
	  cli2.getTelefone().addAll(Arrays.asList("911111112"));
	  
	  Cliente cli3 = new Cliente(null, "Cliente 3", "cliente3@mail.com", "232323233", TipoCliente.PUBLICO);
	  cli3.getTelefone().addAll(Arrays.asList("911111113"));
	  
	  Endereco ender1 = new Endereco(null, "Rua morada 1", "N1", "", "2000-000", cli1,local1);
	  local1.getEnderecos().addAll(Arrays.asList(ender1));
	  
	  Endereco ender2 = new Endereco(null, "Rua morada 2", "N2", "", "1000-000", cli2, local2);
	  local2.getEnderecos().addAll(Arrays.asList(ender2));
	  
	  Endereco ender3 = new Endereco(null, "Rua morada 3", "N3", "", "1000-001", cli3, null);
	  
	  cli1.getEnderecos().addAll(Arrays.asList(ender1));
	  cli2.getEnderecos().addAll(Arrays.asList(ender2));
	  cli3.getEnderecos().addAll(Arrays.asList(ender3));
	  
	  clienteRepo.saveAll(Arrays.asList(cli1,cli2, cli3));
	  enderecoRepo.saveAll(Arrays.asList(ender1,ender2,ender3));
	  
		
	}

}
