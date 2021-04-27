package beans;

import org.springframework.context.annotation.Bean;

import service.CoursServiceClient;

public class CoursServiceConfig
{
	@Bean
	public static CoursServiceClient coursServiceClient()
	{
		return new CoursServiceClient();
	}
}
