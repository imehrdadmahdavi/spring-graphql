package sh.mehrdad.springgraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import sh.mehrdad.springgraphql.entity.Dog;
import sh.mehrdad.springgraphql.exception.DogNotFoundException;
import sh.mehrdad.springgraphql.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {
    private DogRepository dogRepository;

    public Query(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Iterable<Dog> findAllDogs() {
        return dogRepository.findAll();
    }

    public Dog findDogById(Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if (optionalDog.isPresent()) {
            return optionalDog.get();
        } else {
            throw new DogNotFoundException("Dog Not Found", id);
        }
    }
}
