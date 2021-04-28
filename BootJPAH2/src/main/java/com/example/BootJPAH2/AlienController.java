package com.example.BootJPAH2;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.BootJPAH2.model.Alien;
import com.example.BootJPAH2.repo.AlienRepo;

@RestController
public class AlienController {
	@Autowired
	AlienRepo arepo;
	@RequestMapping("/")
	public String home() {
		System.out.println("calling ");
		return "home.jsp";
	}
	
	@DeleteMapping(path="/alien/{id}")
	public String deleteAlien(@PathVariable("id") int aid) {
		Alien a = arepo.getOne(aid);
		arepo.delete(a);
		return "Deleted";
	}
	
	@PutMapping(path="/alien",consumes= {"application/json"})
	public Alien updateAlien(@RequestBody Alien alien) {
		arepo.save(alien);
		return alien;
	}
	
	@PostMapping(path="/alien",consumes= {"application/json"})
	public Alien addAlien(@RequestBody Alien alien) {
		arepo.save(alien);
		fetchAlien();
		return alien;
	}
	

	@RequestMapping("/aliens")
	@ResponseBody
	public  List<Alien> fetchAlien() {
		List<Alien> list =(List<Alien>) arepo.findAll();
		for(Alien a:list) {
			System.out.println(a);
		}
		return list;
	}
	@RequestMapping("/alien/{id}")
	@ResponseBody
	public  Optional<Alien> fetchAlienByID(@PathVariable("id")Integer aid) {
		Alien a = arepo.findById(aid).orElse(new Alien());
			System.out.println(a);
		
		return arepo.findById(aid);
	}
	@RequestMapping("/getAlien")
	public ModelAndView fetchAlienById( @RequestParam Integer aid) {
		Alien alien =arepo.findById(aid).get();
		//for(Alien a:list) {
			System.out.println(aid);
		//}
		//	System.out.println(arepo.findByTech("Java"));
		//	System.out.println(arepo.findByTechSorted("Java"));
			ModelAndView mv= new ModelAndView();
			mv.addObject( alien);
			mv.setViewName("test.jsp");
			return mv;
	}

}
