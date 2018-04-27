[![Build Status](https://travis-ci.org/mirego/kotlin-ssml-dsl.svg?branch=master)](https://travis-ci.org/mirego/kotlin-ssml-dsl)

# kotlin-ssml-dsl

A kotlin library that provides DSL to build SSML. Supports Actions on Google elements.

# Get started

This goes into your `build.gradle`.
```groovy
repositories {
  maven { url("https://mirego.bintray.com/public") }
}

dependencies {
  compile 'com.mirego.dsl:ssml:1.0'
}
```

# Usage


```kotlin
val ssml = speak {
  +"Here are "; sayAs(interpretAs = CHARACTERS) { +"SSML" }; +" samples.\n"
  +"I can pause "; `break`(time = "3s"); +".\n"
  +"I can play a sound"; audio(src = "https://www.example.com/MY_MP3_FILE.mp3") { +"didn't get your MP3 audio file" }; +".\n"
  +"I can speak in cardinals. Your number is "; sayAs(interpretAs = CARDINAL) { +"10" };+".\n"
  +"Or I can speak in ordinals. You are "; sayAs(interpretAs = ORDINAL) { +"10" }; +" in line.\n"
  +"Or I can even speak in digits. The digits for ten are "; sayAs(interpretAs = CHARACTERS) { +"10" }; +".\n"
  +"I can also substitute phrases, like the "; sub(alias = "World Wide Web Consortium") { +"W3C" }; +".\n"
  +"Finally, I can speak a paragraph with two sentences.\n"
  p { s { +"This is sentence one." }; s { +"This is sentence two." } }; +"\n"
}
println(ssml.toString())
```

## About Mirego

[Mirego](https://www.mirego.com) is a team of passionate people who believe that work is a place where you can innovate and have fun. We’re a team of [talented people](https://life.mirego.com) who imagine and build beautiful Web and mobile applications. We come together to share ideas and [change the world](http://www.mirego.org).

We also [love open-source software](https://open.mirego.com) and we try to give back to the community as much as we can.
