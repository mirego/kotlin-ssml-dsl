package com.mirego.dsl.ssml.element

import com.mirego.dsl.ssml.SsmlTag

fun SsmlTag.s(init: S.() -> Unit) = initTag(S(), init)

class S : SsmlTag("s")
