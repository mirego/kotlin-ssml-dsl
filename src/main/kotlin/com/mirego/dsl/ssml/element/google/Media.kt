package com.mirego.dsl.ssml.element.google

import com.mirego.dsl.ssml.SsmlTag
import com.mirego.dsl.ssml.alias

fun SsmlTag.media(id: String? = null, begin: String? = null, end: String? = null, repeatCount: String? = null, repeatDur: String? = null, soundLevel: String? = null, fadeInDur: String? = null, fadeOutDur: String? = null, init: Media.() -> Unit) {
    val media = initTag(Media(), init)
    media.id = id
    media.begin = begin
    media.end = end
    media.repeatCount = repeatCount
    media.repeatDur = repeatDur
    media.soundLevel = soundLevel
    media.fadeInDur = fadeInDur
    media.fadeOutDur = fadeOutDur
}

class Media : SsmlTag("media") {
    var id: String? by attributes.alias("xml:id")
    var begin: String? by attributes
    var end: String? by attributes
    var repeatCount: String? by attributes
    var repeatDur: String? by attributes
    var soundLevel: String? by attributes
    var fadeInDur: String? by attributes
    var fadeOutDur: String? by attributes
}
