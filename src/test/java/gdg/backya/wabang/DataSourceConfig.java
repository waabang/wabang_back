package gdg.backya.wabang;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@TestConfiguration
@EnableTransactionManagement
@ComponentScan(basePackages = "gdg.backya")
@PropertySource("classpath:application-test.yml") // 테스트 환경 설정 파일
public class DataSourceConfig {

  @Bean
  public DataSource testDataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost:3306/wabang"); // 테스트용 MySQL URL
    dataSource.setUsername("wabang"); // MySQL 사용자명
    dataSource.setPassword("dhkqkd!"); // MySQL 비밀번호
    return dataSource;
  }
}
