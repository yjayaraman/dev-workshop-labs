package lab.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import lab.domain.Movie;

public interface MovieRepository extends PagingAndSortingRepository<Movie, Long> {
	
}