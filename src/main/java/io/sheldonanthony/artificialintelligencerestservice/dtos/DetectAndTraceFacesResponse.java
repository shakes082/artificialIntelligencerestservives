package io.sheldonanthony.artificialintelligencerestservice.dtos;

import org.apache.commons.lang3.builder.ToStringBuilder;

public final class DetectAndTraceFacesResponse{
	
	private String base64EncodedImage;
	
	public DetectAndTraceFacesResponse(){
	}

	public DetectAndTraceFacesResponse(String base64EncodedImage) {
		super();
		this.base64EncodedImage = base64EncodedImage;
	}

	public String getBase64EncodedImage() {
		return base64EncodedImage;
	}
	
	public void setBase64EncodedImage(String base64EncodedImage) {
		this.base64EncodedImage = base64EncodedImage;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
