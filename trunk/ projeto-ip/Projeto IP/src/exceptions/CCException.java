package exceptions;

public class CCException extends Exception {

	public CCException(){
		super("H� um cliente cadastrado com o mesmo cpf.");
	}
}
