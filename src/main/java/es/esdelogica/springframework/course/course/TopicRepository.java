package es.esdelogica.springframework.course.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {
	public List<Topic> findByNameContainsIgnoreCase(String name);
}
