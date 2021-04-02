package es.esdelogica.springframework.course.course;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getAllCourses(final String topicId) {
		return this.courseRepository.findByTopicId(topicId);
	}

	public List<Course> getCoursesByName(final String topicId, final String name) {
		return this.courseRepository.findByTopicIdAndNameContainsIgnoreCase(topicId, name);
	}

	public Course getCourse(final String topicId, final String id) throws EntityNotFoundException, IllegalArgumentException {
		Course course = this.courseRepository
				.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(String.format("Course %s not found", id)));

		if (!course.getTopic().getId().equals(topicId)) {
			throw new IllegalArgumentException(String.format("Course %s not topic of %s.", id, topicId));
		}

		return course;
	}

	public void insertCourse(final Course course) {
		Optional<Course> curCourse = this.courseRepository.findById(course.getId());
		if (curCourse.isPresent()) {
			throw new IllegalArgumentException(String.format("Course %s already exists.", course.getId()));
		}

		this.courseRepository.save(course);
	}

	public void updatesCourse(final Course course) {
		Optional<Course> curCourse = this.courseRepository.findById(course.getId());
		if (!curCourse.isPresent()) {
			throw new IllegalArgumentException(String.format("Course %s not exists.", course.getId()));
		}

		this.courseRepository.save(course);
	}

	public void removeCourse(final String id) {
		Optional<Course> curCourse = this.courseRepository.findById(id);
		if (!curCourse.isPresent()) {
			throw new IllegalArgumentException(String.format("Course %s not exists.", id));
		}

		this.courseRepository.deleteById(id);
	}
}
