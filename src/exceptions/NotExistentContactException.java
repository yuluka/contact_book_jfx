package exceptions;

public class NotExistentContactException extends RuntimeException{

	public NotExistentContactException(String phone) {
		super("El contacto " + phone + " no existe, por lo que no se puede eliminar.");
	}
}
