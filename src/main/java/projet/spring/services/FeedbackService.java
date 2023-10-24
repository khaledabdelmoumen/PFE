package projet.spring.services;

import java.util.List;

import projet.spring.entities.Customers;
import projet.spring.entities.Feedback;

public interface FeedbackService {
	Feedback AjouterFeedback(Feedback f);
	void DeleteFeedback(Feedback f);
	void DeleteById(Long id_feedback);
	List<Feedback> getAllFeedback();
	double getAverageRating();

}
