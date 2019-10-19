# github-contribution-stats

[![Build Status](https://travis-ci.com/pine/github-contribution-stats.svg?branch=master)](https://travis-ci.com/pine/github-contribution-stats)
[![codecov](https://codecov.io/gh/pine/github-contribution-stats/branch/master/graph/badge.svg)](https://codecov.io/gh/pine/github-contribution-stats)
[![Download](https://api.bintray.com/packages/pinemz/maven/github-contribution-stats/images/download.svg)](https://bintray.com/pinemz/maven/github-contribution-stats)

:octocat: GitHub contribution stat utilities.

![](pr/readme.jpg)<br>
<sup><sup>&copy; PaylessImages/123RF.COM</sup></sup>
<br>
<br>

## Requirements

- Java 8 or later

## Getting started
The library is published to [jcenter](https://bintray.com/pinemz/maven/github-contribution-stats).

```gradle
repositories {
    jcenter()
}

depepdencies {
    implementation 'moe.pine:github-contribution-stats:0.2.0'
}
```

## Usage

```java
import moe.pine.github.contribution.stats.ContributionStats;
import moe.pine.github.contribution.stats.ContributionStatsClient;

class Main {
    public static void main(String ...args) {
        final ContributionStatsClient client = ContributionStatsClient.create();
        final ContributionStats stats = client.collect("username");

        System.out.println(stats);
        // => ContributionStats{
        //      contributions=[
        //        Contribution{ date=2018-10-14, count=3 },
        //        Contribution{ date=2018-10-15, count=3 }
        //        Contribution{ date=2018-10-16, count=1 },
        //        ...
        //      ],
        //      currentStreak=Streak{ days=27, start=2019-09-23, end=2019-10-19, unmeasurable=false }, 
        //      longestStreak=Streak{ days=40, start=2019-07-26, end=2019-09-03, unmeasurable=false },
        //      summary=Summary{
        //        start=2018-10-14,
        //        end=2019-10-19,
        //        total=2888,
        //        busiestDay=Contribution{ date=2019-07-07, count=108 }
        //      }
        //    })
    }
}
```

## Development
### Test

```bash
$ ./gradlew clean test
```

### Upload Bintray

```bash
$ export BINTRAY_USER=username
$ export BINTRAY_KEY=apiKey
$ ./gradlew clean assemble bintrayUpload
```

## Thanks
This library is Java port of [moqada/github-contribution-stats](https://github.com/moqada/github-contribution-stats).

## License
MIT &copy; [Pine Mizune](https://profile.pine.moe)
