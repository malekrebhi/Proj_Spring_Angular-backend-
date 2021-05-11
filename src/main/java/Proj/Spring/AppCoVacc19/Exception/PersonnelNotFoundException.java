package Proj.Spring.AppCoVacc19.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PersonnelNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public PersonnelNotFoundException (String message) {
		super(message);
	}
	
}