package com.mirego.dsl.ssml.element.google

import com.mirego.dsl.ssml.SsmlTag

fun SsmlTag.par(init: Par.() -> Unit) = initTag(Par(), init)

class Par : SsmlTag("par")
