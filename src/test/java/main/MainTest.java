package main;

import org.junit.jupiter.api.Test;

import static main.Main.convertDatetimeToMillis;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

  @Test
  void testConvertDatetimeToMillisSuccess() {
    String input = "2020-11-09T19:00:00.000Z";
    String tsMillis = convertDatetimeToMillis(main.Main.ParseISOTimestamp(input, Main.TimeZoneEnum.UTC));
    assertEquals(tsMillis, "1604948400000");
  }

  @Test
  void testConvertDatetimeToMilliswithTimeZoneETC() {
    String input = "2021-02-19T16:42:14-05:00";
    String tsMillis = convertDatetimeToMillis(main.Main.ParseISOTimestamp(input, Main.TimeZoneEnum.OTHER));
    assertEquals(tsMillis, "1613770934000");
  }

  @Test
  void testConvertDatetimeToMillisFail() {
    String input = "2020-11-09T19:00:00.000Z";
    String tsMillis = convertDatetimeToMillis(main.Main.ParseISOTimestamp(input, Main.TimeZoneEnum.UTC));
    assertNotEquals(tsMillis, "16049484");
  }
}