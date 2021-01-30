package io.sheldonanthony.artificialintelligencerestservice;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
@SpringBootApplication
public class ArtificialIntelligenceRestServiceApplication{

	private static Logger LOGGER = 
			LogManager.getLogger(ArtificialIntelligenceRestServiceApplication.class);
	
	public static void main(String[] args){
		LOGGER.info("Initialized ArtificialIntelligenceRestServiceApplication->main()");
        SpringApplication.run(ArtificialIntelligenceRestServiceApplication.class, args);
        LOGGER.info("Exited ArtificialIntelligenceRestServiceApplication->main()");
    }
}
