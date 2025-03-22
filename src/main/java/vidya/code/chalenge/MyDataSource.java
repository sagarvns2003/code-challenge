package vidya.code.chalenge;

import jakarta.activation.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MyDataSource {

  @Primary
  @Bean(name = "datasource1")
  DataSource getPrimaryDataSource() {
    return new DataSource() {
      @Override
      public InputStream getInputStream() throws IOException {
        return null;
      }

      @Override
      public OutputStream getOutputStream() throws IOException {
        return null;
      }

      @Override
      public String getContentType() {
        return null;
      }

      @Override
      public String getName() {
        return "Primary";
      }
    };
  }

  @Bean(name = "datasource2")
  DataSource getDataSource() {
    return new DataSource() {
      @Override
      public InputStream getInputStream() throws IOException {
        return null;
      }

      @Override
      public OutputStream getOutputStream() throws IOException {
        return null;
      }

      @Override
      public String getContentType() {
        return null;
      }

      @Override
      public String getName() {
        return "Secondary";
      }
    };
  }
}
