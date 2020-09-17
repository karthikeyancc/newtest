package karthikeyancc.dbstest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import karthikeyancc.dbstest.dto.FileDto;
import karthikeyancc.dbstest.service.FileSystemService;
/**
 * REST controller to get information about files and directories
 * @author karthikeyan
 *
 */
@RestController
@RequestMapping("/fs")
public class FileSystemController {
	private FileSystemService fileSystemService;
	/*
	 * FileSystemService which queries files and directories from the underlying file system is given as input for this constructor
	 */
	@Autowired
	public FileSystemController(FileSystemService fileSystemService) {
		this.fileSystemService=fileSystemService;
	}
	/**
	 * Fetches the information of file or directory which include full path, size, read, write, execute access , list of child files/directories
	 * @param fname Name of the file
	 * @return FileDto that has information about full path, size, read, write, execute access , list of child files/directories 
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FileDto> getFileInfo(@RequestParam("name") String fname){
        return new ResponseEntity<FileDto>(fileSystemService.getFileInfo(fname), HttpStatus.OK);
    }
}
