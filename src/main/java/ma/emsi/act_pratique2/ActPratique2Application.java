package ma.emsi.act_pratique2;

import ma.emsi.act_pratique2.Entities.*;
import ma.emsi.act_pratique2.repository.MedecinRepository;
import ma.emsi.act_pratique2.repository.PatientRepository;
import ma.emsi.act_pratique2.repository.ProductRepository;
import ma.emsi.act_pratique2.repository.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class ActPratique2Application implements CommandLineRunner {

@Autowired
private ProductRepository productRepository;
	public static void main(String[] args) {

		SpringApplication.run(ActPratique2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	/*productRepository.save(new Product(null,"computer",4003,2));
	productRepository.save(new Product(null,"Printer",1200,4));
	productRepository.save(new Product(null,"smart phone",3200,32));*/
		List<Product> products = productRepository.findAll();
		products.forEach(p -> {
			System.out.println(p.toString());
		});
		Product product = productRepository.findById(Long.valueOf(1)).get();
		System.out.println("******************************");
		System.out.println(product.getId());
		System.out.println(product.getName());
		System.out.println(product.getPrice());
		System.out.println(product.getQuantity());
		System.out.println("******************************");
		System.out.println("-------------------------------");
		List<Product> productList = productRepository.findByNameContains("c");

		productList.forEach(p -> {
			System.out.println(p);
		});
		System.out.println("+++++++++++++++++++++++++");
		List<Product> productList2 = productRepository.search("%c%");

		productList2.forEach(p -> {
			System.out.println(p);
		});

		System.out.println("|||||||||||||||||||||||||||||");
		List<Product> productList3 = productRepository.findByPriceGreaterThan(3000);

		productList3.forEach(p -> {
			System.out.println(p);
		});

		System.out.println("//////////////////////////");
		List<Product> productList4 = productRepository.searchByPrice(3000);

		productList4.forEach(p -> {
			System.out.println(p);
		});
	}
		/* Deuxieme Partie du deuxieme activite */

		@Bean
		CommandLineRunner start(PatientRepository patientRepository ,
								MedecinRepository medecinRepository,
								RendezVousRepository rendezVousRepository) {
			return args-> {
				Stream.of("Mohammed","Hassan","Najat")
						.forEach(name->{
									Patient patient = new Patient();
									patient.setNom(name);
									patient.setDateNaissance(new Date());
									patient.setMalade(false);
									patientRepository.save(patient);
								});

				Stream.of("Aymen","Hanane","Yassmine")
						.forEach(name->{
							Medecin medecin = new Medecin();
							medecin.setNom(name);
							medecin.setEmail(name+"@gmail.com");
							medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
							medecinRepository.save(medecin);
						});

				Patient patient =patientRepository.findById(1L).orElse(null);
				Patient patient1=patientRepository.findByNom("Mohammed");

				Medecin	medecin=medecinRepository.findByNom("Yassmine");

				RendezVous rendezVous= new RendezVous();
				rendezVous.setDate(new Date());
				rendezVous.setStatus(StatusRDV.PENDING);
				rendezVous.setMedecin(medecin);
				rendezVous.setPatient(patient);
				rendezVousRepository.save(rendezVous);
				RendezVous rendezVous1= rendezVousRepository.findById(1L).orElse(null);
				};


		}
}
