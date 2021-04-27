package beans;

import org.springframework.context.annotation.Bean;

import service.StudentServiceClient;

public class StudentServiceConfig
{
	@Bean
	public static StudentServiceClient studentServiceClient()
	{
		return new StudentServiceClient();
	}
}
