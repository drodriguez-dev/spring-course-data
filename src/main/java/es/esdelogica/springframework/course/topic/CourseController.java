package es.esdelogica.springframework.course.topic;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.esdelogica.springframework.course.course.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable final String topicId, @RequestParam(required = false) final String name) {
		if (StringUtils.hasLength(name)) {
			return this.courseService.getCoursesByName(topicId, name);
		} else {
			return this.courseService.getAllCourses(topicId);
		}
	}

	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable final String topicId, @PathVariable final String id) throws EntityNotFoundException {
		return this.courseService.getCourse(topicId, id);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/topics/{topicId}/courses")
	public void addCourse(@PathVariable final String topicId, @RequestBody final Course course) {
		course.setTopic(new Topic(topicId, "", ""));
		this.courseService.insertCourse(course);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/topics/{topicId}/courses/{id}")
	public void updateCourse(@PathVariable final String topicId, @RequestBody final Course course) {
		course.setTopic(new Topic(topicId, "", ""));
		this.courseService.updatesCourse(course);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/topics/{topicId}/courses/{id}")
	public void removeCourse(@PathVariable final String topicId, @PathVariable final String id) {
		this.courseService.removeCourse(id);
	}
}
