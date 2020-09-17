package karthikeyancc.dbstest.exception;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;
/**
 * Http Error handler to provide customized error messages.
 * @author karthikeyan
 *
 */
@ControllerAdvice
@RestController
public class FileNotFoundExceptionController implements ErrorController {
	/**
	 * Any runtime exception is sent out as HTTP NOT FOUND.
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(value = RuntimeException.class)
	   public ResponseEntity<Object> exception(RuntimeException exception) {
	      return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	   }
	/**
	 * Any request with unknown path pattern will be sent out as Invalid Request
	 * @param t
	 * @return
	 */
	@ExceptionHandler(value = NoHandlerFoundException.class)
	public ResponseEntity<Object> noHandler(Throwable t) {
		return new ResponseEntity<>("Invalid request", HttpStatus.BAD_REQUEST);
	}
	/**
	 * Any internal errors raised will be sent out as Invalid Request
	 * @param t
	 * @return
	 */
	@ExceptionHandler(value = Throwable.class)
	public ResponseEntity<Object> throwable(Throwable t) {
		return new ResponseEntity<>("Invalid request", HttpStatus.BAD_REQUEST);
	}
	private static final String PATH="/error";
	/**
	 * "/error" is sent as error path 
	 */
	@Override
	public String getErrorPath() {
		return PATH;
	}
	
	/**
	 * 4xx and 5xx internal errors raised will be sent out as Invalid Request
	 * @param t
	 * @return
	 */
	@RequestMapping(value = PATH,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> general() {
		return new ResponseEntity<>("Invalid request", HttpStatus.BAD_REQUEST);
	}

}
