package com.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;


@Configuration
public class SwaggerConfig {

	public static final String AUTHORIZATION_HEADER = "Authorization";
	
	private SecurityScheme createAPIKeyScheme() {
	    return new SecurityScheme().type(SecurityScheme.Type.HTTP)
	        .bearerFormat("JWT")
	        .scheme("bearer");
	}

	@Bean
	public OpenAPI openAPI() {
	    return new OpenAPI().addSecurityItem(new SecurityRequirement().
	            addList("Bearer Authentication"))
	        .components(new Components().addSecuritySchemes
	            ("Bearer Authentication", createAPIKeyScheme()))
	        .info(new Info().title("BLOG APPLICATION API")
	            .description("Some custom description of API.")
	            .version("1.0").license(new License().name("License of API")
	                .url("API license URL")));
	}

	/*
	 * 
	 * private ApiKey apiKeys() { return new ApiKey("JWT", AUTHORIZATION_HEADER,
	 * "header"); }
	 * 
	 * private List<SecurityContext> securityContexts() { return
	 * Arrays.asList(SecurityContext.builder().securityReferences(sf()).build()); }
	 * 
	 * private List<SecurityReference> sf() {
	 * 
	 * AuthorizationScope scope = new AuthorizationScope("global",
	 * "accessEverything");
	 * 
	 * return Arrays.asList(new SecurityReference("JWT", new AuthorizationScope[] {
	 * scope })); }
	 * 
	 * @Bean public Docket api() {
	 * 
	 * return new
	 * Docket(DocumentationType.SWAGGER_2).apiInfo(getInfo()).securityContexts(
	 * securityContexts()) .securitySchemes(Arrays.asList(apiKeys())).select().apis(
	 * RequestHandlerSelectors.any()) .paths(PathSelectors.any()).build();
	 * 
	 * }
	 * 
	 * private ApiInfo getInfo() {
	 * 
	 * return new ApiInfo("Blogging Application : Backend Course",
	 * "This project is developed by Learn Code With Durgesh", "1.0",
	 * "Terms of Service", new Contact("Durgesh",
	 * "https://learncodewithdurgesh.com", "learncodewithdurgesh@gmail.com"),
	 * "License of APIS", "API license URL", Collections.emptyList()); };
	 */
}
