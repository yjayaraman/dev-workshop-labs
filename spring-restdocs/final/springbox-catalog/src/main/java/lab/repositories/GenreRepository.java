package lab.repositories;


import org.springframework.data.repository.PagingAndSortingRepository;

import lab.domain.Genre;

public interface GenreRepository extends PagingAndSortingRepository<Genre, Long> {
}
