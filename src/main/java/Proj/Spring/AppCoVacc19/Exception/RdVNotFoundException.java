package Proj.Spring.AppCoVacc19.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RdVNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public RdVNotFoundException (String message) {
		super(message);
	}
	
}