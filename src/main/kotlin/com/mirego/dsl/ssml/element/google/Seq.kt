package com.mirego.dsl.ssml.element.google

import com.mirego.dsl.ssml.SsmlTag

fun SsmlTag.seq(init: Seq.() -> Unit) = initTag(Seq(), init)

class Seq : SsmlTag("seq")
