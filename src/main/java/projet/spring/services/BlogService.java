package projet.spring.services;

import java.util.List;

import projet.spring.entities.Blog;



public interface BlogService {

	
	Blog AjouterBlog(Blog b);
	void DeleteBlog(Blog b);
	void DeleteById(Long id_blog);
	List<Blog> getAllBlog();
	Blog UpdateBlog(Blog b);

}
