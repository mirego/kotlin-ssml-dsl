package com.mirego.dsl.ssml.element

import com.mirego.dsl.ssml.Element
import com.mirego.dsl.ssml.SsmlTag

fun SsmlTag.speak(init: Speak.() -> Unit) = initTag(Speak(), init)

fun speak(init: Speak.() -> Unit): Speak {
    val speak = Speak()
    speak.init()
    return speak
}

fun String.toSpeak() = speak {
    p { +this@toSpeak }
}

class Speak(list: MutableList<Element> = mutableListOf()) : SsmlTag("speak", list) {
    operator fun plus(speak: Speak): Speak {
        val list: MutableList<Element> = mutableListOf()
        list.addAll(children)
        list.addAll(speak.children)
        return Speak(list)
    }
}
