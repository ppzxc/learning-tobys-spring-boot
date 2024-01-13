package ppzxc.configuration.auto;

import com.zaxxer.hikari.HikariDataSource;
import java.sql.Driver;
import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ppzxc.configuration.ConditionalMyOnClass;
import ppzxc.configuration.EnableMyConfigurationProperties;
import ppzxc.configuration.MyAutoConfiguration;

@MyAutoConfiguration
@ConditionalMyOnClass("org.springframework.jdbc.core.JdbcOperations")
@EnableMyConfigurationProperties(MyDataSourceProperties.class)
@EnableTransactionManagement
public class DataSourceConfiguration {

  @Bean
  @ConditionalMyOnClass("com.zaxxer.hikari.HikariDataSource")
  @ConditionalOnMissingBean
  public DataSource hikariDataSource(MyDataSourceProperties myDataSourceProperties) {
    HikariDataSource dataSource = new HikariDataSource();
    dataSource.setDriverClassName(myDataSourceProperties.getDriverClassName());
    dataSource.setJdbcUrl(myDataSourceProperties.getUrl());
    dataSource.setUsername(myDataSourceProperties.getUsername());
    dataSource.setPassword(myDataSourceProperties.getPassword());
    return dataSource;
  }

  @Bean
  @ConditionalOnMissingBean
  public DataSource dataSource(MyDataSourceProperties myDataSourceProperties) throws ClassNotFoundException {
    SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
    dataSource.setDriverClass((Class<? extends Driver>) Class.forName(
      myDataSourceProperties.getDriverClassName()));
    dataSource.setUrl(myDataSourceProperties.getUrl());
    dataSource.setUsername(myDataSourceProperties.getUsername());
    dataSource.setPassword(myDataSourceProperties.getPassword());
    return dataSource;
  }

  @Bean
  @ConditionalOnSingleCandidate(DataSource.class)
  @ConditionalOnMissingBean
  public JdbcTemplate jdbcTemplate(DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }

  @Bean
  @ConditionalOnSingleCandidate(DataSource.class)
  @ConditionalOnMissingBean
  public JdbcTransactionManager jdbcTransactionManager(DataSource dataSource) {
    return new JdbcTransactionManager(dataSource);
  }
}
