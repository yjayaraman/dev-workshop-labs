package lab.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import lab.domain.Movie;
@RepositoryRestResource(collectionResourceRel="movies", path="movies")
public interface MovieRepository extends PagingAndSortingRepository<Movie, Long> {

}