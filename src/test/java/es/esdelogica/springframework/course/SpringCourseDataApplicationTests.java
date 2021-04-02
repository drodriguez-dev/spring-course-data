package es.esdelogica.springframework.course;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringCourseDataApplicationTests {

	@Autowired
	private SpringCourseDataApplication application;

	@Test
	void contextLoads() {
		Assertions.assertThat(this.application).isNotNull();
	}
}
