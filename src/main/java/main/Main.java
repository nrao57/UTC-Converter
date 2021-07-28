package main;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.util.TimeZone;

/**
 * Converts UTC Datetime String to Long Milliseconds since Epoch
 */
public class Main {
    enum TimeZoneEnum {
        UTC,
        OTHER
    }

  public static void main(String[] args) {

        TimeZoneEnum tz = TimeZoneEnum.valueOf(args[1]);

    Long tsSeconds = convertMillisToSeconds(convertDatetimeToMillis(ParseISOTimestamp(args[0], tz)));

    System.out.println(tsSeconds);

  }

  public static Long convertDatetimeToMillis(DateTime dt){
      return dt.getMillis();
  }

  public static Long convertMillisToSeconds(Long millis){
        return millis / 1000;
  }


  public static DateTime ParseISOTimestamp(String ISOTimeString, TimeZoneEnum tz) {
    /*
     * Parses the given ISO 8601 UTC timestamp string and
     * returns DateTime
     */

      DateTimeFormatter fmt;

    switch (tz) {
      case UTC:
        try {
          fmt = ISODateTimeFormat.dateTime();
          return fmt.parseDateTime(ISOTimeString);
        } catch (Exception e) {
          throw e;
        }
        case OTHER:
            try {
                // parse with timezone in string
                fmt = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZ");
                return fmt.parseDateTime(ISOTimeString);
            } catch (Exception e){
                throw e;
            }}
            return new DateTime();
        }
}
