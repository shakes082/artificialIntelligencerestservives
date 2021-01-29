package io.sheldonanthony.artificialintelligencerestservice.dtos;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"detectedFaces"})
public class DetectFacesResponse{
	
	@JsonProperty
	private boolean detectedFaces;
	
	public DetectFacesResponse(){
	}

	public DetectFacesResponse(boolean detectedFaces) {
		super();
		this.detectedFaces = detectedFaces;
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
