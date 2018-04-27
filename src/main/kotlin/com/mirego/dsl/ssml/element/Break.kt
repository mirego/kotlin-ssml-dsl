package com.mirego.dsl.ssml.element

import com.mirego.dsl.ssml.SsmlTag
import com.mirego.dsl.ssml.TagWithText

fun SsmlTag.`break`(time: String) {
    val b = initTag(Break())
    b.time = time
}

class Break : TagWithText("break") {
    var time: String by attributes
}
