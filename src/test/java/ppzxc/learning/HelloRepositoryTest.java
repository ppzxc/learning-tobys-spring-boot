package ppzxc.learning;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@Transactional
public class HelloRepositoryTest {

  @Autowired
  private JdbcTemplate jdbcTemplate;
  @Autowired
  private HelloRepository helloRepository;

  @Test
  void findHelloFailed() {
    assertThat(helloRepository.findHello("Toby")).isNull();
  }

  @Test
  void increaseCount() {
    assertThat(helloRepository.countOf("Toby")).isEqualTo(0);
    helloRepository.increase("Toby");
    assertThat(helloRepository.countOf("Toby")).isEqualTo(1);
    helloRepository.increase("Toby");
    assertThat(helloRepository.countOf("Toby")).isEqualTo(2);
  }
}
