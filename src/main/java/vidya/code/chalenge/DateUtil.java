package vidya.code.chalenge;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DateUtil {

  public ZonedDateTime getCurrentDate() {
    return ZonedDateTime.now(ZoneId.of("-05:00"));
  }
}
