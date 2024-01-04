package ppzxc.learning;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = LearningTobysSpringBootApplication.class)
@TestPropertySource("classpath:/application.properties")
public class DataSourceTest {

  @Autowired
  private DataSource dataSource;

  @Test
  void connect() throws SQLException {
    assertThat(dataSource).isNotNull();
    Connection connection = dataSource.getConnection();
    assertThat(connection).isNotNull();
    connection.close();
  }
}
