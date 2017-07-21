package hello;

import java.util.Collection;


import org.springframework.data.repository.CrudRepository;

public interface HeroRepository extends CrudRepository<Hero, Long> {

	Collection<Hero> findByName(String name);
	
	Collection<Hero> findById(long id);
}
