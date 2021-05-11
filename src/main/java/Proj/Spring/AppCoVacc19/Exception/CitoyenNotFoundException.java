package Proj.Spring.AppCoVacc19.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CitoyenNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public CitoyenNotFoundException (String message) {
		super(message);
	}
	
}