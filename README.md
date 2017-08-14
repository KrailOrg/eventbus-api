# eventbus-api

[ ![Download](https://api.bintray.com/packages/dsowerby/maven/eventbus-api/images/download.svg) ](https://bintray.com/dsowerby/maven/eventbus-api/_latestVersion)

Provides a simple "wrapper" API to enable implementation-independent use of an event bus.  An implementation using [MBassador](https://github.com/bennidi/mbassador) is [provided](https://github.com/davidsowerby/eventbus-mbassador).


# Limitations

Provides a standardised API for the publishing and subscribing, but implementation of handlers is implementation specific.

 
### Build configuration

Available from JCenter only

**Gradle**

```
compile 'uk.q3c.krail:eventbus-api:x.x.x.x'
```

**Maven**

```
<dependency>
  <groupId>uk.q3c.krail</groupId>
  <artifactId>eventbus-api</artifactId>
  <version>x.x.x.x</version>
  <type>pom</type>
</dependency>
```

### Build from source

```
./gradlew build
```