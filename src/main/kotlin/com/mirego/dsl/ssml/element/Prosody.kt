package com.mirego.dsl.ssml.element

import com.mirego.dsl.ssml.SsmlTag
import com.mirego.dsl.ssml.TagWithText

fun SsmlTag.prosody(rate: String? = null, pitch: String? = null, contour: String? = null, duration: String? = null, volume: String? = null, range: String? = null, init: Prosody.() -> Unit) {
    val prosody = initTag(Prosody(), init)
    prosody.rate = rate
    prosody.pitch = pitch
    prosody.contour = contour
    prosody.duration = duration
    prosody.volume = volume
    prosody.range = range
}

class Prosody : TagWithText("prosody") {
    var rate: String? by attributes
    var pitch: String? by attributes
    var contour: String? by attributes
    var duration: String? by attributes
    var volume: String? by attributes
    var range: String? by attributes
}
