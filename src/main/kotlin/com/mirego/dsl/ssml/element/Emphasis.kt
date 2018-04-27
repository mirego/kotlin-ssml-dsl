package com.mirego.dsl.ssml.element

import com.mirego.dsl.ssml.AttributeEnum
import com.mirego.dsl.ssml.SsmlTag
import com.mirego.dsl.ssml.TagWithText

fun SsmlTag.emphasis(level: EmphasisLevel? = null, init: Emphasis.() -> Unit) {
    val e = initTag(Emphasis(), init)
    e.level = level
}

class Emphasis : TagWithText("emphasis") {
    var level: EmphasisLevel?
        get() = EmphasisLevel.attributeValueOf(attributes["level"]!!)!!
        set(value) {
            attributes["level"] = value?.attributeValue
        }
}

enum class EmphasisLevel(override val attributeValue: String) : AttributeEnum {
    STRONG("strong"),
    MODERATE("moderate"),
    NONE("none"),
    REDUCED("reduced");

    companion object {
        fun attributeValueOf(value: String): EmphasisLevel? = EmphasisLevel.values().find { it.attributeValue == value }
    }
}
