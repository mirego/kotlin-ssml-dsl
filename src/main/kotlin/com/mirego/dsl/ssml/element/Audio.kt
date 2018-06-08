package com.mirego.dsl.ssml.element

import com.mirego.dsl.ssml.SsmlTag
import com.mirego.dsl.ssml.TagWithText

fun SsmlTag.audio(src: String, clipBegin: String? = null, clipEnd: String? = null, speed: String? = null, repeatCount: String? = null, repeatDur: String? = null, soundLevel: String? = null, init: (Audio.() -> Unit)? = null) {
    val audio = initTag(Audio(), init)
    audio.src = src
    audio.clipBegin = clipBegin
    audio.clipEnd = clipEnd
    audio.speed = speed
    audio.repeatCount = repeatCount
    audio.repeatDur = repeatDur
    audio.soundLevel = soundLevel
}

class Desc : TagWithText("desc")

class Audio : TagWithText("audio") {
    var src: String by attributes
    var clipBegin: String? by attributes
    var clipEnd: String? by attributes
    var speed: String? by attributes
    var repeatCount: String? by attributes
    var repeatDur: String? by attributes
    var soundLevel: String? by attributes

    fun desc(init: Desc.() -> Unit) = initTag(Desc(), init)
}
