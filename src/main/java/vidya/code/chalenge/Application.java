package vidya.code.chalenge;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

  /*@Autowired private DataSource dataSource1;

  @Autowired
  @Qualifier("datasource2")
  private DataSource dataSource;

  @PostConstruct
  public void print() {
    System.out.println("Datasource: " + dataSource1.getName());
    System.out.println("Datasource: " + dataSource.getName());
  }*/

  public static void main(String[] args) throws IOException, InterruptedException {
    SpringApplication.run(Application.class, args);
    //System.out.println("Date: " + DateUtil.getCurrentDate());
  }
}
