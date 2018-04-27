package com.mirego.dsl.ssml.element

import com.mirego.dsl.ssml.SsmlTag

fun SsmlTag.p(init: P.() -> Unit) = initTag(P(), init)

class P : SsmlTag("p")
