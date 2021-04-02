package es.esdelogica.springframework.course.topic;

import java.time.LocalDateTime;

public class TopicDTO {

	private String id;
	private String name;
	private String description;
	private LocalDateTime modificationDateTime;

	public TopicDTO() {
		super();
		this.modificationDateTime = LocalDateTime.now();
	}

	public TopicDTO(final String id, final String name, final String description) {
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
}
