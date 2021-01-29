package io.sheldonanthony.artificialintelligencerestservice.service;
import org.springframework.stereotype.Service;
import io.sheldonanthony.artificialintelligencerestservice.dtos.DetectFacesRequest;
import io.sheldonanthony.artificialintelligencerestservice.dtos.DetectFacesResponse;
import io.sheldonanthony.artificialintelligencerestservice.dtos.Ping;

@Service("artificialintelligenceservice")
public class ArtificialIntelligenceServiceImpl implements ArtificialIntelligenceServiceIF{

	@Override
	public Ping ping(){
		Ping ping = new Ping();
		ping.setAlive(true);
		return ping;
	}

	@Override
	public DetectFacesResponse detectFaces(DetectFacesRequest detectFacesRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
