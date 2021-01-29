package io.sheldonanthony.artificialintelligencerestservice.computervision;
import org.apache.commons.codec.binary.Base64;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfRect;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.objdetect.Objdetect;
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
		String iBase64Image = base64Image.split(",")[1];
		byte[] base64ImageByte = javax.xml.bind.DatatypeConverter.parseBase64Binary(iBase64Image);
		return Imgcodecs.imdecode(new MatOfByte(base64ImageByte), Imgcodecs.IMREAD_COLOR);
	}
	
	/**
	 * @param imageMat
	 * @return @{link Boolean}
	 */
	public boolean detectFaces(Mat imageMat) {
		
		
		CascadeClassifier faceDetector = new CascadeClassifier(faceDetectorCascadeClassifier);
		
		MatOfRect faceDetections = new MatOfRect();
		Mat grayScaledMat = new Mat();
		
		// convert the frame in gray scale
		Imgproc.cvtColor(imageMat, grayScaledMat, Imgproc.COLOR_RGB2GRAY);
		
		// equalize the frame histogram to improve the result
		Imgproc.equalizeHist(grayScaledMat, grayScaledMat);
		
		int height = grayScaledMat.rows();
		int size = 0;
		if (Math.round(height * 0.2f) > 0)
		{
			size = Math.round(height * 0.2f);
		}
		
		faceDetector.detectMultiScale(grayScaledMat, faceDetections, 1.1, 2, 0 | 
				Objdetect.CASCADE_SCALE_IMAGE, new Size(size, size), new Size());
		
		if(faceDetections.toArray().length >= 1 ) {
			return true;
		}
		else{
			return false;
		}
		
	}
}
