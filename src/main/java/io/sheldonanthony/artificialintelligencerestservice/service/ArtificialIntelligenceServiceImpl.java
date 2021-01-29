package io.sheldonanthony.artificialintelligencerestservice.service;
import org.opencv.core.Mat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import io.sheldonanthony.artificialintelligencerestservice.computervision.ComputerVisionController;
import io.sheldonanthony.artificialintelligencerestservice.dtos.DetectAndTraceFacesRequest;
import io.sheldonanthony.artificialintelligencerestservice.dtos.DetectAndTraceFacesResponse;
import io.sheldonanthony.artificialintelligencerestservice.dtos.DetectFacesRequest;
import io.sheldonanthony.artificialintelligencerestservice.dtos.DetectFacesResponse;
import io.sheldonanthony.artificialintelligencerestservice.dtos.DetectIfFacesAreWearingMasksRequest;
import io.sheldonanthony.artificialintelligencerestservice.dtos.DetectIfFacesAreWearingMasksResponse;
import io.sheldonanthony.artificialintelligencerestservice.dtos.Ping;

@Service("artificialintelligenceservice")
public class ArtificialIntelligenceServiceImpl implements ArtificialIntelligenceServiceIF{
	
	@Autowired
	@Qualifier("computerVisionController")
	private ComputerVisionController computerVisionController;

	@Override
	public Ping ping(){
		Ping ping = new Ping();
		ping.setAlive(true);
		return ping;
	}

	@Override
	public DetectFacesResponse detectFaces(DetectFacesRequest detectFacesRequest){
		
		Mat matImage = null;
		
		boolean hasDetected = false;
		
		DetectFacesResponse detectFacesResponse = new DetectFacesResponse();
		
		try{
			matImage = computerVisionController.convertBase64ToByteArray(detectFacesRequest.getBase64EncodedImage());
			hasDetected = computerVisionController.detectFaces(matImage);
			detectFacesResponse.setDetectedFaces(hasDetected);
		}
		catch (RuntimeException runtimeException) {
			throw runtimeException;
		}
		
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
