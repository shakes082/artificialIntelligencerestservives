package io.sheldonanthony.artificialintelligencerestservice.config;
import org.springframework.stereotype.Service;
import io.sheldonanthony.artificialintelligencerestservice.dtos.Ping;

@Service("artificialintelligenceservice")
public class ArtificialIntelligenceServiceImpl implements ArtificialIntelligenceServiceIF{

	@Override
	public Ping ping(){
		Ping ping = new Ping();
		ping.setAlive(true);
		return ping;
	}

}
