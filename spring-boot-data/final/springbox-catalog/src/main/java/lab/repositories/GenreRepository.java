package lab.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import lab.domain.Genre;
import lab.domain.Movie;

public interface GenreRepository extends PagingAndSortingRepository<Genre, Long> {
 
}
