package projet.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.spring.entities.Admin;
import projet.spring.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	AdminRepository adminRepo;

		@Override
		public Admin AjouterAdmin(Admin a) {
			adminRepo.save(a);
			return a;
		}

}
