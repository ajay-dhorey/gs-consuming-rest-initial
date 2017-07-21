 package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeroController {
	
	@Autowired
	HeroRepository heroRepository;
	
	@RequestMapping(method=RequestMethod.GET, value= "/api/heroes")
	public Iterable<Hero> heroes(){
		return heroRepository.findAll();
	}	
	
	@RequestMapping(method=RequestMethod.GET, value= "/api/heroes/{id}")
	public Hero getHero(@PathVariable("id") Long id){
		if(id != null) {
			return heroRepository.findOne(id);
		} else {
			return null;
		}
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value= "/api/heroes/{id}")
	public void deleteHero(@PathVariable("id") Long id){
		if(id != null) {
			Hero hero = heroRepository.findOne(id);
			if(hero == null) {
				heroRepository.delete(id);
			}
			
		} 
	}
	
	
//	@RequestMapping(method=RequestMethod.GET, value= "/api/heroes/{id}")
//	public Hero addHero(@RequesBody Hero hero){
//		if(id != null) {
//			return heroes.get(id);
//		} else {
//			return null;
//		}
//	}
	
	

}
