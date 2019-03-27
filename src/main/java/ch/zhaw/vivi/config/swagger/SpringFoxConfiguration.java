package ch.zhaw.vivi.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This class handles the SpringFox/Swagger configuration.
 * 
 * TODO apiInfo() Text anpassen
 *
 * @author Yves Kaufmann
 */
@Configuration
@EnableSwagger2
public class SpringFoxConfiguration {
	
	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("ch.zhaw.vivi.webContext.domain")).paths(PathSelectors.any())
				.build().apiInfo(apiInfo());
		
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Prototype Rest API - Multiple Choice Test").description("Vivi - The Multiple Choice Test-REST API")
				.termsOfServiceUrl("").contact(new Contact("ZHAW Group", "Lorem Ipsum1", "your.email@here.ch")).license("")
				.licenseUrl("").version("1.0").build();
	}
	
}