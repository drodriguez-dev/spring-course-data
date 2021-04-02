package es.esdelogica.springframework.course.topic;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;

	public List<Topic> getAllTopics() {
		List<Topic> result = new ArrayList<Topic>();
		this.topicRepository.findAll().forEach(result::add);

		return result;
	}

	public Topic getTopic(final String id) {
		return this.topicRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(String.format("Topic %s not found", id)));
	}

	public List<Topic> getTopicsByName(final String name) {
		return this.topicRepository.findByNameContainsIgnoreCase(name);
	}

	public void addTopic(final Topic topic) {
		if (this.topicRepository.existsById(topic.getId())) {
			throw new IllegalArgumentException(String.format("Topic %s already exists.", topic.getId()));
		}

		this.topicRepository.save(topic);
	}

	public void updateTopic(final String id, final Topic topic) {
		if (!this.topicRepository.existsById(id)) {
			throw new IllegalArgumentException(String.format("Topic %s not exists.", id));
		}

		if (!id.equals(topic.getId())) {
			this.topicRepository.delete(topic);
		}

		this.topicRepository.save(topic);
	}

	public void removeTopic(final String id) {
		if (!this.topicRepository.existsById(id)) {
			throw new IllegalArgumentException(String.format("Topic %s not exists.", id));
		}

		this.topicRepository.deleteById(id);
	}
}
