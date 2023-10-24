package projet.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import projet.spring.entities.Blog;

import projet.spring.services.BlogService;

@RestController
@CrossOrigin("*")
public class BlogController {
	@Autowired
	BlogService blogservice;

	//Affichage
	@GetMapping("/Blogs")
	@ResponseBody
	public List<Blog> getAllBlog(){
		List<Blog> list=blogservice.getAllBlog();
		return list;
	}

	
	
	//Ajout
	@PostMapping("/AjouterBlog")
	@ResponseBody
	//Kif yabda aandou barsha paramètres naaml @RequestBody
	public Blog AjouterBlog(@RequestBody Blog b) {
		return blogservice.AjouterBlog(b);
	}

	//Suppression
	@DeleteMapping("DeleteBlog/{id}")
	@ResponseBody
	//Kif yabda aana paramètres barka naaml @PathVariable
	public void DeleteBlog(@PathVariable("id") Long id_blog) {
		blogservice.DeleteById(id_blog);
	}

	//Modifier 
	@PutMapping("/UpdateBlog")
	@ResponseBody
	public Blog UpdateBlog(@RequestBody Blog b) {
	return blogservice.UpdateBlog(b);
			}
		

}
