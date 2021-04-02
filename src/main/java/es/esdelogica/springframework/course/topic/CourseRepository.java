package es.esdelogica.springframework.course.topic;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> {
	public List<Course> findByTopicId(String topicId);

	public List<Course> findByTopicIdAndNameContainsIgnoreCase(String topicId, String name);
}
