package karthikeyancc.dbstest.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import karthikeyancc.dbstest.dto.FileDto;
import karthikeyancc.dbstest.service.FileSystemService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = FileSystemController.class)
public class FileSystemControllerTest {

	@MockBean
	private FileSystemService fileSystemService;
	
	@Autowired 
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    @Before
     public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
     }
     @Test
     public void testMain() throws Exception{
 		assertNotNull(fileSystemService);
 		Mockito.when(fileSystemService.getFileInfo("test")).thenReturn(new FileDto("test", null,1L,true,true,false));
 		mockMvc.perform(MockMvcRequestBuilders.get("/fs?name=test"))
        .andExpect(status().isOk())
        .andExpect(content().contentType( MediaType.APPLICATION_JSON_VALUE))
        .andExpect(content().json("{\"name\":\"test\",\"size\":1,\"read\":true,\"write\":true,\"execute\":false,\"child\":null}"));
     }
     @Test
     public void testNoFile() throws Exception{
    	 assertNotNull(fileSystemService);
    	 Mockito.when(fileSystemService.getFileInfo("test")).thenThrow(new RuntimeException("Invalid file"));
    	 mockMvc.perform(MockMvcRequestBuilders.get("/fs?name=test"))
    	 .andExpect(status().is(404))
    	 .andExpect(content().string("Invalid file"));
     }
}
