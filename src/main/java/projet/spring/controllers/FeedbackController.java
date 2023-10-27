package projet.spring.controllers;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import projet.spring.entities.Feedback;
import projet.spring.repository.FeedbackRepository;
import projet.spring.services.FeedbackService;

@RestController
@CrossOrigin("*")

@RequestMapping("/feedback")
public class FeedbackController {
	
	@Autowired
    private FeedbackService Feedbacks;
	
	
	 @PostMapping("/addreview")
	    public Feedback createReview(@RequestBody Feedback feedback) {
	        return Feedbacks.AjouterFeedback(feedback);
	    }
	 
	 
	 @GetMapping("/getallfeedbacks")
	    public List<Feedback> getAllReviews() {
	        return Feedbacks.getAllFeedback();
	    }
	 
	  @GetMapping("/average")
	    public double getAverageRating() {
	        return Feedbacks.getAverageRating();
	    }
	 /* @PostMapping("/upload")
	    public String handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
	        // Generate a unique filename
	        String uniqueFileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

	        // Save the file to the specified directory
	        File targetFile = new File("D:/telecharg/Dracoss_front/Dracoss_front/src/assets/images/reviews/" + uniqueFileName);
	        
	        file.transferTo(targetFile);
	        System.out.print(targetFile);
	        // Return the path to the saved image
	        return "D:/telecharg/Dracoss_front/Dracoss_front/src/assets/images/reviews/"+ uniqueFileName;
	    }*/
	  
	  @PostMapping("/upload")
	  public ResponseEntity<Map<String, String>> handleFileUpload(@RequestParam("file") MultipartFile file) {
		
		  String originalFileName = URLDecoder.decode(file.getOriginalFilename(), StandardCharsets.UTF_8);
		    
		    String filePath = "D:/telecharg/Dracoss_front/Dracoss_front/src/assets/images/reviews/" + originalFileName;
 File targetFile = new File("D:/telecharg/Dracoss_front/Dracoss_front/src/assets/images/reviews/" + originalFileName);
	        
	        try {
				file.transferTo(targetFile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    Map<String, String> response = new HashMap<>();
		    response.put("filePath", originalFileName);
		    return ResponseEntity.ok().body(response);
		}


}
