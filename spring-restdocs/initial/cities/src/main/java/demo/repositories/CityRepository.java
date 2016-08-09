package demo.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import demo.City;

@RepositoryRestResource
public interface CityRepository extends PagingAndSortingRepository<City, Long> {

}
