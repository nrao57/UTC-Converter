# UTC-Converter

## Build jar from Maven Project
```
mvn package
```

## To convert from GMT ISO 8601 to UTC Seconds

```
java -jar ./target/GetUTC-bundled-1.0-SNAPSHOT.jar 2021-04-02T11:59:59.000Z UTC
```

## To convert from any Timezone with ISO 8601 format to UTC Seconds

```
java -jar ./target/GetUTC-bundled-1.0-SNAPSHOT.jar 2021-04-02T11:59:59-07:00 OTHER
```
