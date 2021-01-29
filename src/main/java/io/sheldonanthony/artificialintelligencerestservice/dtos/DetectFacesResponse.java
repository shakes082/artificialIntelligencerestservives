package io.sheldonanthony.artificialintelligencerestservice.dtos;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class DetectFacesResponse{
	
	private boolean detectedFaces;
	
	public DetectFacesResponse(){
	}
	
	public boolean isDetectedFaces() {
		return detectedFaces;
	}
	
	public void setDetectedFaces(boolean detectedFaces) {
		this.detectedFaces = detectedFaces;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
