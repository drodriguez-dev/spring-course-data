package es.esdelogica.springframework.course.course;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.esdelogica.springframework.course.topic.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable final String topicId, @RequestParam(required = false) final String name) {
		if (StringUtils.hasLength(name)) {
			return this.courseService.getCoursesByName(topicId, name);
		} else {
			return this.courseService.getAllCourses(topicId);
		}
	}

	@GetMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable final String topicId, @PathVariable final String id) throws EntityNotFoundException {
		return this.courseService.getCourse(topicId, id);
	}

	@PostMapping(path = "/topics/{topicId}/courses")
	public void addCourse(@PathVariable final String topicId, @RequestBody final CourseDto courseDto) {
		Course course = this.modelMapper.map(courseDto, Course.class);
		course.setTopic(new Topic(topicId, "", ""));
		this.courseService.insertCourse(course);
	}

	@PutMapping(path = "/topics/{topicId}/courses/{id}")
	public void updateCourse(@PathVariable final String topicId, @RequestBody final CourseDto courseDto) {
		Course course = this.modelMapper.map(courseDto, Course.class);
		course.setTopic(new Topic(topicId, "", ""));
		this.courseService.updatesCourse(course);
	}

	@DeleteMapping(path = "/topics/{topicId}/courses/{id}")
	public void removeCourse(@PathVariable final String topicId, @PathVariable final String id) {
		this.courseService.removeCourse(id);
	}
}
