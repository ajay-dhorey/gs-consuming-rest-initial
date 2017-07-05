package hello;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeroController {
	
	
	private static Map<Long, Hero>  heroes = new HashMap<Long, Hero>();
	
	static {
		Hero hero1= new Hero(1,"Vishesh");
		Hero hero2 = new Hero(2,"Vijay");
		Hero hero3 = new Hero(3,"Vikas");
		Hero hero4 = new Hero(4,"Vinayak");
		heroes.put(hero1.getId(), hero1);
		heroes.put(hero2.getId(), hero2);
		heroes.put(hero3.getId(), hero3);
		heroes.put(hero4.getId(), hero4);
	}
	
	@RequestMapping(method=RequestMethod.GET, value= "/api/heroes")
	public Hero[] heroes(){
		return heroes.values().toArray(new Hero[heroes.size()]);
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value= "/api/heroes/{id}")
	public Hero getHero(@PathVariable("id") Long id){
		if(id != null) {
			return heroes.get(id);
		} else {
			return null;
		}
	}
	

}
