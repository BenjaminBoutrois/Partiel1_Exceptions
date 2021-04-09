package exceptions;

public class InternalServerException extends ServiceException
{
	private static final long serialVersionUID = 1L;

	public InternalServerException()
	{
		super("Une erreur technique est survenue au niveau du serveur.");
	}
	
	public InternalServerException(Throwable throwable)
	{
		super("Une erreur technique est survenue au niveau du serveur.", throwable);
	}

	public InternalServerException(String message)
	{
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InternalServerException(String message, Throwable throwable)
	{
		super(message, throwable);
		// TODO Auto-generated constructor stub
	}
}
