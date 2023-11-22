package com.cropfield.project.configuration;


import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class CropSwaggerConfiguration {

	   @Bean
	    public Docket postsApi() {
	        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
	                .apiInfo(apiInfo()).select().paths(postPaths()).build();
	    }
	   
	   private Predicate<String> postPaths() {
		   return or(regex("/api/posts.*"), regex("/crop.*"));
	    }
	   

	private ApiInfo apiInfo() {
		   return new ApiInfoBuilder().title("Crop-Deal-Service-Api")
				   .description("Crop-Details-Service Api Reference for developers")
				   .termsOfServiceUrl("http://crop_details_service.com")
				   .contact("crop_details_service@gmail.com").license("Crop-Details-Service License")
				   .licenseUrl("crop_details_service@gmail.com").version("1.0").build();
	   }
}
