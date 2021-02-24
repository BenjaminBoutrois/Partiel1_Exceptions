package exceptions;

public class UserNotFoundException extends ServiceException
{
	public UserNotFoundException()
	{
		super("Login et/ou mot de passe incorrect(s).");
	}
	
	public UserNotFoundException(Throwable throwable)
	{
		super("Login et/ou mot de passe incorrect(s).", throwable);
	}
	
	public UserNotFoundException(String message)
	{
		super(message);
	}
	
	public UserNotFoundException(String message, Throwable throwable)
	{
		super(message, throwable);
	}
}
