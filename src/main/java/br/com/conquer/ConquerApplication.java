package br.com.conquer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import br.com.conquer.domain.Despesa;

@SpringBootApplication(exclude={HibernateJpaAutoConfiguration.class})
@EntityScan(basePackageClasses = Despesa.class)
public class ConquerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConquerApplication.class, args);
	}

}
