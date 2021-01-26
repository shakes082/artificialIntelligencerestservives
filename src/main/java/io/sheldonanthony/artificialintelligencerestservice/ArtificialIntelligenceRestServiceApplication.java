package io.sheldonanthony.artificialintelligencerestservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class ArtificialIntelligenceRestServiceApplication extends SpringBootServletInitializer {


	public static void main(String[] args) {
        SpringApplication.run(ArtificialIntelligenceRestServiceApplication.class, args);
    }
	
    @Bean
    ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean servlet = new ServletRegistrationBean(
            new CamelHttpTransportServlet(), "/camel-rest-jpa/*");
        servlet.setName("CamelServlet");
        return servlet;
    }
	@Component
    class RestApi extends RouteBuilder {

        @Override
        public void configure() {
            restConfiguration()
                .contextPath("/camel-rest-jpa").apiContextPath("/api-doc")
                    .apiProperty("api.title", "Camel REST API")
                    .apiProperty("api.version", "1.0")
                    .apiProperty("cors", "true")
                    .apiContextRouteId("doc-api")
                .component("servlet")
                .bindingMode(RestBindingMode.json);

            rest("/artificialintelligencerestservice").description("A rest service that will provide value by computing, \n"
            		+ "	performing voice or facial recognition, responding to human prompts, \n"
            		+ "	and sense and monitor human activity.");
        }
    }

}
