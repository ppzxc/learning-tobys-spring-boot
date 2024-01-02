package ppzxc.learning;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class HelloApiTest {

  private TestRestTemplate rest;

  @BeforeEach
  void setUp() {
    rest = new TestRestTemplate();
  }

  @Test
  void should_return_hello_world() {
    // given
    String given = "Spring";

    // when
    ResponseEntity<String> actual = rest.getForEntity("http://localhost:8080/hello?name={name}", String.class,
      given);

    // then
    assertThat(actual.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
    assertThat(actual.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
    assertThat(actual.getBody()).isEqualTo("Hello %s".formatted(given));
  }

  @Test
  void should_return_exception_when_input_null() {
    // given
    String given = "";

    // when
    ResponseEntity<String> actual = rest.getForEntity("http://localhost:8080/hello?name={name}", String.class,
      given);

    // then
    assertThat(actual.getStatusCode()).isEqualByComparingTo(HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
