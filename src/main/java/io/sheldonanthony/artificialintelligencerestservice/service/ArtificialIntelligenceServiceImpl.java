package io.sheldonanthony.artificialintelligencerestservice.service;
import org.springframework.stereotype.Service;
import io.sheldonanthony.artificialintelligencerestservice.dtos.DetectAndTraceFacesRequest;
import io.sheldonanthony.artificialintelligencerestservice.dtos.DetectAndTraceFacesResponse;
import io.sheldonanthony.artificialintelligencerestservice.dtos.DetectFacesRequest;
import io.sheldonanthony.artificialintelligencerestservice.dtos.DetectFacesResponse;
import io.sheldonanthony.artificialintelligencerestservice.dtos.DetectIfFacesAreWearingMasksRequest;
import io.sheldonanthony.artificialintelligencerestservice.dtos.DetectIfFacesAreWearingMasksResponse;
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
	public DetectFacesResponse detectFaces(DetectFacesRequest detectFacesRequest){
		DetectFacesResponse detectFacesResponse = new DetectFacesResponse();
		detectFacesResponse.setDetectedFaces(true);
		return detectFacesResponse;
	}

	@Override
	public DetectAndTraceFacesResponse detectAndTraceFaces(DetectAndTraceFacesRequest 
			detectAndTraceFacesRequest){
		DetectAndTraceFacesResponse detectAndTraceFacesResponse = 
				new DetectAndTraceFacesResponse();
		detectAndTraceFacesResponse.setBase64EncodedImage("");
		return detectAndTraceFacesResponse;
	}

	@Override
	public DetectIfFacesAreWearingMasksResponse detectIfFaceWearingMask(
			DetectIfFacesAreWearingMasksRequest detectIfFacesAreWearingMasksRequest){
		DetectIfFacesAreWearingMasksResponse detectIfFacesAreWearingMasksResponse = 
				new DetectIfFacesAreWearingMasksResponse();
		detectIfFacesAreWearingMasksResponse.setWearingMask(true);
		return detectIfFacesAreWearingMasksResponse;
	}
	
}
