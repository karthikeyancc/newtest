package karthikeyancc.dbstest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * REST web interface to get information about a file /directory
 * @author karthikeyan
 *
 */
@SpringBootApplication
public class DbstestApplication {

	/**
	 * Method to init the web application
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(DbstestApplication.class, args);
	}

}
