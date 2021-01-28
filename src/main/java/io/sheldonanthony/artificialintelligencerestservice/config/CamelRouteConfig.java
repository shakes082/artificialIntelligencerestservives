package io.sheldonanthony.artificialintelligencerestservice.config;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import io.sheldonanthony.artificialintelligencerestservice.dtos.Ping;
import static org.apache.camel.model.rest.RestParamType.body;
import static org.apache.camel.model.rest.RestParamType.path;

@Configuration
public class CamelRouteConfig extends RouteBuilder{
	
	@Autowired
    private Environment env;
    
    @Value("${camel.component.servlet.mapping.context-path}")
    private String contextPath;

    @Override
    public void configure() throws Exception {

        // @formatter:off
        
        // this can also be configured in application.properties
        restConfiguration()
            .component("servlet")
            .bindingMode(RestBindingMode.json)
            .dataFormatProperty("prettyPrint", "true")
            .enableCORS(true)
            .port(env.getProperty("server.port", "8080"))
            .contextPath(contextPath.substring(0, contextPath.length() - 2))
            // turn on swagger api-doc
            .apiContextPath("/api-doc")
            .apiProperty("api.title", "Artificial Intelligence Services")
            .apiProperty("api.version", "1.0.0");
        
        rest("/ping").description("Ping Request").produces("application/json")
        .get().description("").outType(Ping[].class).responseMessage().code(200).
        message("Ping").endResponseMessage().to("bean:artificialintelligenceservice?method=ping");
    }
}
