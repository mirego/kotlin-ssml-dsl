package com.mirego.dsl.ssml.sample

import com.mirego.dsl.ssml.element.*
import com.mirego.dsl.ssml.element.InterpretAs.*
import com.mirego.dsl.ssml.element.google.media
import com.mirego.dsl.ssml.element.google.par
import com.mirego.dsl.ssml.element.google.seq

fun emptySpeak() = speak { }

fun fewNodesSpeak() = speak {
    `break`(time = "1s")
    p {
        +"Hello world. "
        +"Can have more than one."
    }
    emphasis(level = EmphasisLevel.MODERATE) {
        +"Emphasis!"
    }
}

fun allNodesSpeak() = speak {
    `break`(time = "1s", strength = Strength.X_STRONG)
    p {
        +"Hello world. "
        +"Can have more than one."
        s { +"Sentence" }
    }
    emphasis(level = EmphasisLevel.MODERATE) {
        +"Emphasis!"
    }
    sayAs(interpretAs = CARDINAL) {
        +"1234"
    }
    sayAs(interpretAs = InterpretAs.DATE, format = "dmy", detail = "2") {
        +"10-9-1960"
    }
    prosody(rate = "rate", pitch = "pitch", contour = "contour", duration = "duration", volume = "volume", range = "range") {
        +"Test prosody"
    }
    prosody {
        +"Empty prosody"
    }
    audio(src = "http://www.example.com/audio.mp3")
    audio(src = "http://www.example.com/audio2.mp3", clipBegin = "1s", clipEnd = "2s", repeatCount = "4", repeatDur = "5s", soundLevel = "+6dB") {
        desc { +"a cat purring" }
        +"PURR (sound didn't load)"
    }
    sub(alias = "a lie ass") {
        +"alias"
    }
    par {
        media {
            speak { +"Yeap" }
        }
        media(id = "id", begin = "begin", end = "end", repeatCount = "repeatCount", repeatDur = "repeatDur", soundLevel = "soundLevel", fadeInDur = "fadeInDur", fadeOutDur = "fadeOutDur") {
            audio(src = "http://www.example.com/audio.mp3")
        }
    }
    seq {
        media {
            speak { +"Speak" }
        }
        media {
            speak { +"In a seq" }
        }
    }
}

fun demoSpeak() = speak {
    +"Here are "; sayAs(interpretAs = CHARACTERS) { +"SSML" }; +" samples.\n"
    +"I can pause "; `break`(time = "3s"); +".\n"
    +"I can play a sound"; audio(src = "https://www.example.com/MY_MP3_FILE.mp3") { +"didn't get your MP3 audio file" }; +".\n"
    +"I can speak in cardinals. Your number is "; sayAs(interpretAs = CARDINAL) { +"10" };+".\n"
    +"Or I can speak in ordinals. You are "; sayAs(interpretAs = ORDINAL) { +"10" }; +" in line.\n"
    +"Or I can even speak in digits. The digits for ten are "; sayAs(interpretAs = CHARACTERS) { +"10" }; +".\n"
    +"I can also substitute phrases, like the "; sub(alias = "World Wide Web Consortium") { +"W3C" }; +".\n"
    +"Finally, I can speak a paragraph with two sentences.\n"
    p { s { +"This is sentence one." }; s { +"This is sentence two." } }; +"\n"
}
