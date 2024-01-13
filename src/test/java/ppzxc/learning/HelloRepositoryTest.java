package ppzxc.learning;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@HelloBootTest
public class HelloRepositoryTest {

  @Autowired
  private JdbcTemplate jdbcTemplate;
  @Autowired
  private HelloRepository helloRepository;

  @BeforeEach
  void setUp() {
    jdbcTemplate.execute("create table if not exists hello(name varchar(64) primary key, count int)");
  }

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
