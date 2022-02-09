package exceptions;

public class ExistentContactException extends RuntimeException{
	
	public ExistentContactException(String phone) {
		super("El contacto " + phone + " ya ha sido agregado. No puede agregarlo nuevamente");
	}
}
