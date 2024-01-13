package ppzxc.learning;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.SQLException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@HelloBootTest
public class JdbcTemplateTest {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @BeforeEach
  void setUp() {
    jdbcTemplate.execute("create table if not exists hello(name varchar(64) primary key, count int)");
  }

  @Test
  void insertAndQuery() throws SQLException {
    jdbcTemplate.update("insert into hello values(?, ?)", "Toby", 3);
    jdbcTemplate.update("insert into hello values(?, ?)", "Spring", 1);

    Long count = jdbcTemplate.queryForObject("select count(*) from hello", Long.class);
    assertThat(count).isEqualTo(2);
  }

  @Test
  void insertAndQuery2() throws SQLException {
    jdbcTemplate.update("insert into hello values(?, ?)", "Toby", 3);
    jdbcTemplate.update("insert into hello values(?, ?)", "Spring", 1);

    Long count = jdbcTemplate.queryForObject("select count(*) from hello", Long.class);
    assertThat(count).isEqualTo(2);
  }
}
