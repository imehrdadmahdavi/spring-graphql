package sh.mehrdad.springgraphql.repository;

import sh.mehrdad.springgraphql.entity.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {
}
