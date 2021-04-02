package es.esdelogica.springframework.course.course;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

public class TopicDTOTest {

	private final ModelMapper modelMapper = new ModelMapper();

	@Test
	public void whenConvertTopicEntityToTopicDto_thenAreEqual() {
		Topic topic = new Topic();
		topic.setId("acb123");
		topic.setName("abcde123456");
		topic.setDescription("abcdefghijklmnopqrstuvwxyz1234567890");

		TopicDTO topicDto = this.modelMapper.map(topic, TopicDTO.class);
		Assertions.assertEquals(topic.getId(), topicDto.getId());
		Assertions.assertEquals(topic.getName(), topicDto.getName());
		Assertions.assertEquals(topic.getDescription(), topicDto.getDescription());
	}

	@Test
	public void whenConvertTopicDtoToTopicEntity_thenAreEqual() {
		TopicDTO topicDto = new TopicDTO();
		topicDto.setId("acb123");
		topicDto.setName("abcde123456");
		topicDto.setDescription("abcdefghijklmnopqrstuvwxyz1234567890");

		Topic topic = this.modelMapper.map(topicDto, Topic.class);
		Assertions.assertEquals(topicDto.getId(), topic.getId());
		Assertions.assertEquals(topicDto.getName(), topic.getName());
		Assertions.assertEquals(topicDto.getDescription(), topic.getDescription());
	}
}
