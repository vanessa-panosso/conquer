package br.com.conquer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import br.com.conquer.domain.Despesa;

@SpringBootApplication
@EntityScan(basePackageClasses = Despesa.class)
public class ConquerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConquerApplication.class, args);
	}

}
