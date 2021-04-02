package es.esdelogica.springframework.course.course;

import java.util.List;

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

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping(path = "/topics")
	public List<Topic> getAllTopics(@RequestParam(required = false) final String name) {
		if (StringUtils.hasLength(name)) {
			return this.topicService.getTopicsByName(name);
		} else {
			return this.topicService.getAllTopics();
		}
	}

	@GetMapping(path = "/topics/{id}")
	public Topic getTopic(@PathVariable final String id) {
		return this.topicService.getTopic(id);
	}

	@PostMapping(path = "/topics")
	public void addTopic(@RequestBody final TopicDTO topicDto) {
		Topic topic = this.modelMapper.map(topicDto, Topic.class);
		this.topicService.addTopic(topic);
	}

	@PutMapping(path = "/topics/{id}")
	public void updateTopic(@PathVariable final String id, @RequestBody final TopicDTO topicDto) {
		Topic topic = this.modelMapper.map(topicDto, Topic.class);
		this.topicService.updateTopic(id, topic);
	}

	@DeleteMapping(path = "/topics/{id}")
	public void removeTopic(@PathVariable final String id) {
		this.topicService.removeTopic(id);
	}
}
