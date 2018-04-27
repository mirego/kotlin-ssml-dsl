package com.mirego.dsl.ssml.element

import com.mirego.dsl.ssml.AttributeEnum
import com.mirego.dsl.ssml.SsmlTag
import com.mirego.dsl.ssml.TagWithText

fun SsmlTag.sayAs(interpretAs: InterpretAs, format: String? = null, detail: String? = null, init: SayAs.() -> Unit) {
    val sayAs = initTag(SayAs(), init)
    sayAs.interpretAs = interpretAs
    format?.let { sayAs.format = it }
    detail?.let { sayAs.detail = it }
}

class SayAs : TagWithText("say-as") {
    var interpretAs: InterpretAs
        get() = InterpretAs.attributeValueOf(attributes["interpret-as"]!!)!!
        set(value) {
            attributes["interpret-as"] = value.attributeValue
        }
    var format: String by attributes
    var detail: String by attributes
}


enum class InterpretAs(override val attributeValue: String) : AttributeEnum {
    CARDINAL("cardinal"),
    ORDINAL("ordinal"),
    CHARACTERS("characters"),
    FRACTION("fraction"),
    EXPLETIVE("expletive"),
    BEEP("beep"),
    UNIT("unit"),
    VERBATIM("verbatim"),
    SPELL_OUT("spell-out"),
    DATE("date"),
    TIME("time"),
    TELEPHONE("telephone");


    companion object {
        fun attributeValueOf(value: String): InterpretAs? = InterpretAs.values().find { it.attributeValue == value }
    }
}

