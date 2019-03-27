package ch.zhaw.vivi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Main class
 * 
 * @author Yves Kaufmann
 *
 */
@ComponentScan
@SpringBootApplication
public class ViviApplication {

	public static void main(String[] args) {
		SpringApplication.run(ViviApplication.class, args);
	}

}
