package lab.repositories;

import org.springframework.data.repository.CrudRepository;

import lab.domain.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long> {
    public Movie findByMlId(String mlId);
}
