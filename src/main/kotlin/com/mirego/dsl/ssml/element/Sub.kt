package com.mirego.dsl.ssml.element

import com.mirego.dsl.ssml.SsmlTag
import com.mirego.dsl.ssml.TagWithText

fun SsmlTag.sub(alias: String, init: Sub.() -> Unit) {
    val sub = initTag(Sub(), init)
    sub.alias = alias
}

class Sub : TagWithText("sub") {
    var alias: String by attributes
}
