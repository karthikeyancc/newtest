package karthikeyancc.dbstest.service;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import karthikeyancc.dbstest.dto.FileDto;
@RunWith(SpringRunner.class)
public class FileSystemServiceTest {

	private FileSystemService fileSystemService=new FileSystemService();
	
     @Test
     public void testFile() throws Exception{
 		 FileDto fs=fileSystemService.getFileInfo(".gitignore");
 		 Assert.assertNull(fs.getChild());
 		 Assert.assertTrue(fs.getRead());
     }
     @Test
     public void testDirectory() throws Exception{
 		 FileDto fs=fileSystemService.getFileInfo("src");
 		 Assert.assertEquals(2,fs.getChild().size());
 		 Assert.assertTrue(fs.getRead());
     }
}
