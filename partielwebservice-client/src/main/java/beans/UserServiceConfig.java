package beans;

import org.springframework.context.annotation.Bean;

import service.UserServiceClient;

public class UserServiceConfig
{
	@Bean
	public static UserServiceClient userServiceClient()
	{
		return new UserServiceClient();
	}
}
