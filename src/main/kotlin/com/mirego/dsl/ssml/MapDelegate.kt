package com.mirego.dsl.ssml

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

internal fun <R, T> MutableMap<in String, in T>.alias(key: String) = MapDelegate<R, T>(key, this)

internal inline fun <K, V> Map<K, V>.getOrElseNullable(key: K, defaultValue: () -> V): V {
    val value = get(key)
    if (value == null && !containsKey(key)) {
        return defaultValue()
    } else {
        @Suppress("UNCHECKED_CAST")
        return value as V
    }
}

internal class MapDelegate<in R, T>(
    private val key: String,
    private val map: MutableMap<in String, in T>
) : ReadWriteProperty<R, T> {
    override fun getValue(thisRef: R, property: KProperty<*>): T
        = @Suppress("UNCHECKED_CAST") (map.getOrElseNullable(key, { throw NoSuchElementException("Key $key is missing in the map.") }) as T)

    override fun setValue(thisRef: R, property: KProperty<*>, value: T) {
        map[key] = value
    }
}
