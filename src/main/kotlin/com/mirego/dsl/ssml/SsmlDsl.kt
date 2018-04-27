package com.mirego.dsl.ssml

private fun endOfLine(prettyPrint: Boolean) = if (prettyPrint) "\n" else ""
private fun additionalIndent(prettyPrint: Boolean) = if (prettyPrint) "  " else ""

interface Element {
    fun render(builder: StringBuilder, indent: String, prettyPrint: Boolean)
}

class TextElement(val text: String) : Element {
    override fun render(builder: StringBuilder, indent: String, prettyPrint: Boolean) {
        builder.append("$indent$text${endOfLine(prettyPrint)}")
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TextElement

        if (text != other.text) return false

        return true
    }

    override fun hashCode(): Int {
        return text.hashCode()
    }
}

@DslMarker
annotation class SsmlTagMarker

@SsmlTagMarker
abstract class Tag(val name: String, val children: MutableList<Element> = arrayListOf()) : Element {
    val attributes = hashMapOf<String, String?>()

    internal fun <T : Element> initTag(tag: T, init: (T.() -> Unit)? = null): T {
        if (init != null) {
            tag.init()
        }
        children.add(tag)
        return tag
    }

    override fun render(builder: StringBuilder, indent: String, prettyPrint: Boolean) {
        if (children.isEmpty()) {
            builder.append("$indent<$name${renderAttributes()}/>")
        } else {
            builder.append("$indent<$name${renderAttributes()}>${endOfLine(prettyPrint)}")
            for (c in children) {
                c.render(builder, "$indent${additionalIndent(prettyPrint)}", prettyPrint)
            }
            builder.append("$indent</$name>")
        }
        builder.append(endOfLine(prettyPrint))
    }

    private fun renderAttributes(): String {
        val builder = StringBuilder()
        for ((attr, value) in attributes) {
            if (value != null) {
                builder.append(" $attr=\"$value\"")
            }
        }
        return builder.toString()
    }

    override fun toString(): String {
        return renderToString()
    }

    fun renderToString(prettyPrint: Boolean = false): String {
        val builder = StringBuilder()
        render(builder, "", prettyPrint)
        return builder.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Tag

        if (name != other.name) return false
        if (children != other.children) return false
        if (attributes != other.attributes) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + children.hashCode()
        result = 31 * result + attributes.hashCode()
        return result
    }
}

abstract class TagWithText(name: String, children: MutableList<Element> = arrayListOf()) : Tag(name, children) {
    operator fun String.unaryPlus() {
        children.add(TextElement(this))
    }
}

abstract class SsmlTag(name: String, children: MutableList<Element> = arrayListOf()) : TagWithText(name, children)

interface AttributeEnum {
    val attributeValue: String
}
