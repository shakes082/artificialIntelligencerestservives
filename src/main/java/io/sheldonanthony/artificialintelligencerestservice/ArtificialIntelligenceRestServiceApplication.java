package io.sheldonanthony.artificialintelligencerestservice;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArtificialIntelligenceRestServiceApplication{

	private static Logger LOGGER = 
			LogManager.getLogger(ArtificialIntelligenceRestServiceApplication.class);
	
	public static void main(String[] args){
		LOGGER.info("Initialized ArtificialIntelligenceRestServiceApplication->main()");
        SpringApplication.run(ArtificialIntelligenceRestServiceApplication.class, args);
        LOGGER.info("Exited ArtificialIntelligenceRestServiceApplication->main()");
    }
}
