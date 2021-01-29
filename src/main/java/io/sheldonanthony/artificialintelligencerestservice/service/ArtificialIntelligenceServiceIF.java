package io.sheldonanthony.artificialintelligencerestservice.service;
import io.sheldonanthony.artificialintelligencerestservice.dtos.DetectFacesRequest;
import io.sheldonanthony.artificialintelligencerestservice.dtos.DetectFacesResponse;
import io.sheldonanthony.artificialintelligencerestservice.dtos.Ping;

public interface ArtificialIntelligenceServiceIF {

	Ping ping();
	
	DetectFacesResponse detectFaces(DetectFacesRequest detectFacesRequest);
	
}
