package lab.repositories;

import org.springframework.data.repository.CrudRepository;

import lab.domain.Genre;

public interface GenreRepository extends CrudRepository<Genre, Long> {
    Genre findByMlId(String mlId);
}
