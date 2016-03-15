package ibm.com.bluemix.telstra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@SpringBootApplication
public class TelstraBluemixApiApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(TelstraBluemixApiApplication.class, args);
	}

	@Bean
	public Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("telstraapis")
				.apiInfo(apiInfo())
				.select()
				.paths(regex("/apis.*"))
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Telstra Bluemix API Demo with Swagger")
				.description("Telstra Bluemix API Demo with Swagger")
				.version("1.0")
				.contact("Pas Apicella")
				.license("Apache License Version 2.0")
				.build();
	}
}
