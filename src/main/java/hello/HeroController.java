 package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	
	@RequestMapping(method=RequestMethod.PUT, value= "/api/heroes")
	public Hero updateHero( @RequestBody Hero hero){
		System.out.println( String.format("in add Heroes %s", hero));
		Long id = hero.getId();
		Hero updateHero = null;
		if(id != null) {
			updateHero = heroRepository.save(hero);
			
		} 
		return updateHero;
	}
	
	@RequestMapping(method=RequestMethod.POST, value= "/api/heroes" )
	public Hero addHero( @RequestBody Hero hero){
		System.out.println( String.format("in add Heroes %s", hero));
		Hero updateHero = null;
		//if(hero != null && hero.getName() != null) {
			updateHero = heroRepository.save(new Hero(hero.getName()));
		//} 
		return updateHero;
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
