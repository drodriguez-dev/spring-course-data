package es.esdelogica.springframework.course.topic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

class TopicDtoTest {

	private final ModelMapper modelMapper = new ModelMapper();

	@Test
	void whenConvertTopicEntityToTopicDto_thenAreEqual() {
		Topic topic = new Topic();
		topic.setId("acb123");
		topic.setName("abcde123456");
		topic.setDescription("abcdefghijklmnopqrstuvwxyz1234567890");

		TopicDto topicDto = this.modelMapper.map(topic, TopicDto.class);
		Assertions.assertEquals(topic.getId(), topicDto.getId());
		Assertions.assertEquals(topic.getName(), topicDto.getName());
		Assertions.assertEquals(topic.getDescription(), topicDto.getDescription());
	}

	@Test
	void whenConvertTopicDtoToTopicEntity_thenAreEqual() {
		TopicDto topicDto = new TopicDto();
		topicDto.setId("acb123");
		topicDto.setName("abcde123456");
		topicDto.setDescription("abcdefghijklmnopqrstuvwxyz1234567890");

		Topic topic = this.modelMapper.map(topicDto, Topic.class);
		Assertions.assertEquals(topicDto.getId(), topic.getId());
		Assertions.assertEquals(topicDto.getName(), topic.getName());
		Assertions.assertEquals(topicDto.getDescription(), topic.getDescription());
	}
}
