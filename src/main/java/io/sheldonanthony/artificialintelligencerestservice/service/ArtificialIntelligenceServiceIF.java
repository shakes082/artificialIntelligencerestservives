package io.sheldonanthony.artificialintelligencerestservice.service;
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

public interface ArtificialIntelligenceServiceIF{

	Ping ping();
	
	/**
	 * @param detectFacesRequest
	 * @return {@link DetectFacesResponse}
	 */
	DetectFacesResponse detectFaces(DetectFacesRequest detectFacesRequest);
	
	/**
	 * @param detectAndTraceFacesRequest
	 * @return {@link DetectAndTraceFacesResponse}
	 */
	DetectAndTraceFacesResponse detectAndTraceFaces(DetectAndTraceFacesRequest 
			detectAndTraceFacesRequest);
	
	/**
	 * @param detectIfFacesAreWearingMasksRequest
	 * @return {@link DetectIfFacesAreWearingMasksResponse}
	 */
	DetectIfFacesAreWearingMasksResponse detectIfFaceWearingMask(DetectIfFacesAreWearingMasksRequest 
			detectIfFacesAreWearingMasksRequest); 
}
