package com.mirego.dsl.ssml.element

import com.mirego.dsl.ssml.AttributeEnum
import com.mirego.dsl.ssml.SsmlTag
import com.mirego.dsl.ssml.TagWithText

fun SsmlTag.`break`(time: String? = null, strength: Strength? = null) {
    val b = initTag(Break())
    b.time = time
    b.strength = strength
}

class Break : TagWithText("break") {
    var time: String? by attributes
    var strength: Strength?
        get() = Strength.attributeValueOf(attributes["strength"]!!)!!
        set(value) {
            attributes["strength"] = value?.attributeValue
        }
}

enum class Strength(override val attributeValue: String) : AttributeEnum {
    X_WEAK("x-weak"),
    WEAK("weak"),
    MEDIUM("medium"),
    STRONG("strong"),
    X_STRONG("x-strong");

    companion object {
        fun attributeValueOf(value: String): Strength? = Strength.values().find { it.attributeValue == value }
    }
}
