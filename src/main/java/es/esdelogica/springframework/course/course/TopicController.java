package es.esdelogica.springframework.course.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;

	@RequestMapping(method = RequestMethod.GET, path = "/topics")
	public List<Topic> getAllTopics(@RequestParam(required = false) final String name) {
		if (StringUtils.hasLength(name)) {
			return this.topicService.getTopicsByName(name);
		} else {
			return this.topicService.getAllTopics();
		}
	}

	@RequestMapping(method = RequestMethod.GET, path = "/topics/{id}")
	public Topic getTopic(@PathVariable final String id) {
		return this.topicService.getTopic(id);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/topics")
	public void addTopic(@RequestBody final Topic topic) {
		this.topicService.addTopic(topic);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/topics/{id}")
	public void updateTopic(@PathVariable final String id, @RequestBody final Topic topic) {
		this.topicService.updateTopic(id, topic);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/topics/{id}")
	public void removeTopic(@PathVariable final String id) {
		this.topicService.removeTopic(id);
	}
}
