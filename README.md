# github-contribution-stats

[![Build Status](https://travis-ci.com/pine/github-contribution-stats.svg?branch=master)](https://travis-ci.com/pine/github-contribution-stats)
[![codecov](https://codecov.io/gh/pine/github-contribution-stats/branch/master/graph/badge.svg)](https://codecov.io/gh/pine/github-contribution-stats)

![](grasses.jpg)<br>
<sup><sup>&copy; PaylessImages/123RF.COM</sup></sup>
<br>
<br>

## Requirements

- Java 8 or later

## Getting started

```gradle
repositories {
    jcenter()
}

depepdencies {
    implementation 'moe.pine:github-contribution-stats:0.1.0'
}
```

## Usage

```java
import moe.pine.github.contribution.stats.ContributionStats;
import moe.pine.github.contribution.stats.ContributionStatsClient;

final ContributionStatsClient client = new ContributionStatsClient();
final ContributionStats stats = client.collect("username");

System.out.println(stats);
```

## Development
### Test

```
$ ./gradlew clean test
```

### Upload Bintray

```
$ export BINTRAY_USER=username
$ export BINTRAY_KEY=apiKey
$ ./gradlew clean assemble bintrayUpload
```

## Thanks
This library is Java port of [moqada/github-contribution-stats](https://github.com/moqada/github-contribution-stats).

## License
MIT &copy; [Pine Mizune](https://profile.pine.moe)
