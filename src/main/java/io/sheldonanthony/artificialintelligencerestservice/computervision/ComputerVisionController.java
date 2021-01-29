package io.sheldonanthony.artificialintelligencerestservice.computervision;
import java.util.Base64;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfRect;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.objdetect.CascadeClassifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import nu.pattern.OpenCV;

@Controller
public class ComputerVisionController{
	
	@Value("${opencv.faceDetectorCascadeClassifier}")
	private String faceDetectorCascadeClassifier;
	
	static{
		OpenCV.loadLocally();
	}
	
	public ComputerVisionController(){
	}
	
	public Mat convertBase64ToByteArray(String base64Image) {
		byte[] base64ImageByte = Base64.getDecoder().decode(base64Image);
		return Imgcodecs.imdecode(new MatOfByte(base64ImageByte), Imgcodecs.IMREAD_UNCHANGED);
	}
	
	/**
	 * @param imageMat
	 * @return @{link Boolean}
	 */
	public boolean detectFaces(Mat imageMat) {
		CascadeClassifier faceDetector = new CascadeClassifier(faceDetectorCascadeClassifier);
		MatOfRect faceDetections = new MatOfRect();
		faceDetector.detectMultiScale(imageMat, faceDetections);
		
		if(faceDetections != null && !faceDetections.empty() && faceDetections.toArray().length > 0 ) {
			return true;
		}
		else{
			return false;
		}
		
	}
}
