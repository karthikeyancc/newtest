package karthikeyancc.dbstest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import karthikeyancc.dbstest.controller.FileSystemController;
import karthikeyancc.dbstest.service.FileSystemService;

@SpringBootTest
public class DbstestApplicationTests {

	@Autowired
	FileSystemController fileSystemController;
	@Autowired
	FileSystemService fileSystemService;
	@Test
	void contextLoads() {
		assertNotNull(fileSystemController);
		assertNotNull(fileSystemService);
	}

}
