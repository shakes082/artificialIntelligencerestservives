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

/*
 * Copyright (c) 2020, Sheldon Anthony
 * All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the Apache License, Version 2.0 only, as
 * published by the Free Software Foundation.  
 * 
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the Apache License, Version 2.0
 * for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the Apache License, Version 2.0
 * along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Sheldon Anthony, PostNet Suite 129,
 * Private Bag X 1510, Glenvista, 2058, Johannesburg, South Africa
 * or visit https://shakes082.github.io/sheldonanthonyio.github.io/
 * if you need additional information
 *  or have any questions.
 */

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
		
		DetectAndTraceFacesResponse detectAndTraceFacesResponse = new DetectAndTraceFacesResponse();
	
		try{
			Mat matImage = computerVisionController.convertBase64ToByteArray(detectAndTraceFacesRequest.getBase64EncodedImage());
			Mat tracedImage = computerVisionController.detectAndTraceFaces(matImage);
			String base64String = computerVisionController.convertMatToBase64(tracedImage); 
			detectAndTraceFacesResponse.setBase64EncodedImage(base64String);
		}
		catch (RuntimeException runtimeException) {
			throw runtimeException;
		}
		
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
