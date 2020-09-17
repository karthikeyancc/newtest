package karthikeyancc.dbstest.service;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import karthikeyancc.dbstest.dto.FileDto;
/**
 * @author karthikeyan
 * Service that will fetch file system information. 
 */
@Service
public class FileSystemService {
	//Logger instance to print out debug messages
	Logger log=LoggerFactory.getLogger(FileSystemService.class);
	/**
	 * Fetches directory or file information. Description will have full path, size, read, write, execute access , list of child files/directories
	 * @param fname Name of file
	 * @return FileDto that has information about full path, size, read, write, execute access , list of child files/directories 
	 */
	public FileDto getFileInfo(String fname) {
		Path p= Paths.get(fname);
		File file=p.toFile();
		FileDto fd= getFileInfo(file);
		return fd;
	}

	//Recursively this will be called in case of directories
	private FileDto getFileInfo(File file) throws RuntimeException {
		if(file.isFile()) {
			return new FileDto(file.getAbsolutePath(), null,file.length(),file.canRead(),file.canWrite(),file.canExecute());
		}else if(file.isDirectory()) {
			return new FileDto(file.getAbsolutePath(),Arrays.asList(file.listFiles()).stream().map(f->getFileInfo(f)).collect(Collectors.toList()),file.length(),
					file.canRead(),file.canWrite(),file.canExecute());
		}
		throw new RuntimeException(file.getAbsolutePath()+" is invalid");
	}
}

