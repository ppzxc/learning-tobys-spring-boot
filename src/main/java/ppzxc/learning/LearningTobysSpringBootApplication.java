package ppzxc.learning;

import javax.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import ppzxc.configuration.MySpringBootApplication;

@MySpringBootApplication
public class LearningTobysSpringBootApplication {

  private final JdbcTemplate jdbcTemplate;

  public LearningTobysSpringBootApplication(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @PostConstruct
  void init() {
    jdbcTemplate.execute("create table if not exists hello(name varchar(64) primary key, count int)");
  }

  public static void main(String[] args) {
    SpringApplication.run(LearningTobysSpringBootApplication.class, args);
  }
}
