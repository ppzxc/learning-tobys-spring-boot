package ppzxc.learning;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@Transactional
public class SimpleHelloServiceCountTest {

  @Autowired
  private HelloService helloService;
  @Autowired
  private HelloRepository helloRepository;
  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Test
  public void sayHelloIncreaseCount() {
    IntStream.rangeClosed(1, 10).forEach(count -> {
      helloService.sayHello("Toby");
      assertThat(helloRepository.countOf("Toby")).isEqualTo(count);
    });
  }
}
