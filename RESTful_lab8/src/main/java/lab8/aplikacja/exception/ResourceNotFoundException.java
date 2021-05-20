package lab8.aplikacja.exception;

public class ResourceNotFoundException extends RuntimeException{
		
		public ResourceNotFoundException(Long id) {
		    super("Student o numerze id = "+ id +" nie istnieje!!!");
		}
}
