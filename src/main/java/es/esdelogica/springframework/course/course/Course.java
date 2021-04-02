package es.esdelogica.springframework.course.course;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import es.esdelogica.springframework.course.topic.Topic;

@Entity
public class Course {

	@Id
	private String id;
	private String name;
	private String description;
	private LocalDateTime modificationDateTime;

	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Topic topic;

	public Course() {
		super();
		this.modificationDateTime = LocalDateTime.now();
	}

	public Course(final String id, final String name, final String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.modificationDateTime = LocalDateTime.now();
	}

	public String getId() {
		return this.id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public LocalDateTime getModificationDateTime() {
		return this.modificationDateTime;
	}

	public void setModificationDateTime(final LocalDateTime modificationDateTime) {
		this.modificationDateTime = modificationDateTime;
	}

	public Topic getTopic() {
		return this.topic;
	}

	public void setTopic(final Topic topic) {
		this.topic = topic;
	}
}
