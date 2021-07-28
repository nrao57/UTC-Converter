package main;

import org.junit.jupiter.api.Test;

import static main.Main.convertDatetimeToMillis;
import static main.Main.convertMillisToSeconds;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

  @Test
  void testConvertDatetimeToMillisSuccess() {
    String input = "2020-11-09T19:00:00.000Z";
    Long tsMillis = convertDatetimeToMillis(main.Main.ParseISOTimestamp(input, Main.TimeZoneEnum.UTC));
    assertEquals(tsMillis.toString(), "1604948400000");
  }

  @Test
  void testConvertDatetimeToMilliswithTimeZoneETC() {
    String input = "2021-02-19T16:42:14-05:00";
    Long tsMillis = convertDatetimeToMillis(main.Main.ParseISOTimestamp(input, Main.TimeZoneEnum.OTHER));
    assertEquals(tsMillis.toString(), "1613770934000");
  }

  @Test
  void testConvertDatetimeToMillisFail() {
    String input = "2020-11-09T19:00:00.000Z";
    Long tsMillis = convertDatetimeToMillis(main.Main.ParseISOTimestamp(input, Main.TimeZoneEnum.UTC));
    assertNotEquals(tsMillis.toString(), "16049484");
  }

  @Test
  void testConvertDatetimeToSecondsSuccess() {
    String input = "2020-11-09T19:00:00.000Z";
    Long ts = convertMillisToSeconds(convertDatetimeToMillis(main.Main.ParseISOTimestamp(input, Main.TimeZoneEnum.UTC)));
    assertEquals(ts.toString(), "1604948400");
  }

  @Test
  void testConvertDatetimeToSecondswithTimeZoneETC() {
    String input = "2021-02-19T16:42:14-05:00";
    Long ts = convertMillisToSeconds(convertDatetimeToMillis(main.Main.ParseISOTimestamp(input, Main.TimeZoneEnum.OTHER)));
    assertEquals(ts.toString(), "1613770934");
  }
}