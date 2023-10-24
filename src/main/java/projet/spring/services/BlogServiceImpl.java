package projet.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.spring.entities.Blog;
import projet.spring.repository.BlogRepository;

@Service
public class BlogServiceImpl implements BlogService{
@Autowired
BlogRepository blogRep;

	@Override
	public Blog AjouterBlog(Blog b) {
		blogRep.save(b);
		return b;
	}

	@Override
	public void DeleteBlog(Blog b) {
		blogRep.delete(b);
		
	}

	@Override
	public void DeleteById(Long id_blog) {
		blogRep.deleteById(id_blog);
		
	}

	@Override
	public List<Blog> getAllBlog() {
		return (List<Blog>) blogRep.findAll();
	}

	@Override
	public Blog UpdateBlog(Blog b) {
		return blogRep.save(b);
	}

	
}
