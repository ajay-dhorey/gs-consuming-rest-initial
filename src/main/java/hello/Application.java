package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
	
	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Application.class, args);

	}
	
	@Bean
	public CommandLineRunner init(HeroRepository repository) {
		
		return (args) -> {
			
			repository.save(new Hero("Vinay"));
			repository.save(new Hero("Vikas"));
			repository.save(new Hero("Vishesh"));
			repository.save(new Hero("Vinayak"));
			repository.save(new Hero("Vijay"));
			
			logger.info("Heroes found with findAll");
			logger.info("-------------------------");
			for(Hero hero :repository.findAll()) {
				logger.info(hero.toString());
			}
			
			logger.info("");

			// fetch an individual customer by ID
			Hero customer = repository.findOne(1L);
			logger.info("Customer found with findOne(1L):");
			logger.info("--------------------------------");
			logger.info(customer.toString());
			logger.info("");

			// fetch customers by last name
			logger.info("Hero found with findBytName('Vinay'):");
			logger.info("--------------------------------------------");
			for (Hero bauer : repository.findByName("Vinay")) {
				logger.info(bauer.toString());
			}
			logger.info("");
		};
	}

}
