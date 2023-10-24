package projet.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
