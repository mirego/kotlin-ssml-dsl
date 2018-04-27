package com.mirego.dsl.ssml

import com.mirego.dsl.ssml.sample.SsmlDslSamplesKt
import spock.lang.Specification

class SsmlDslSpec extends Specification {

    def '''
        Given empty speak
        When converting dsl to string
        Then empty speak tag is created
    '''() {
        given:
        def speak = SsmlDslSamplesKt.emptySpeak()

        when:
        def xml = speak.toString()

        then:
        xml == "<speak/>"
    }

    def '''
        Given few nodes speak
        When converting dsl to string
        Then all nodes are printed out
    '''() {
        given:
        def speak = SsmlDslSamplesKt.fewNodesSpeak()

        when:
        def xml = speak.toString()

        then:
        xml == "<speak><break time=\"1s\"/><p>Hello world. Can have more than one.</p><emphasis level=\"moderate\">Emphasis!</emphasis></speak>"
    }

    def '''
        Given all nodes speak
        When converting dsl to string with pretty print
        Then all nodes are printed out pretty
    '''() {
        given:
        def speak = SsmlDslSamplesKt.allNodesSpeak()

        when:
        def xml = speak.renderToString(true)

        then:
        xml == """\
            <speak>
              <break time="1s"/>
              <p>
                Hello world. 
                Can have more than one.
                <s>
                  Sentence
                </s>
              </p>
              <emphasis level="moderate">
                Emphasis!
              </emphasis>
              <say-as interpret-as="cardinal">
                1234
              </say-as>
              <say-as interpret-as="date" format="dmy" detail="2">
                10-9-1960
              </say-as>
              <prosody duration="duration" volume="volume" rate="rate" range="range" pitch="pitch" contour="contour">
                Test prosody
              </prosody>
              <prosody>
                Empty prosody
              </prosody>
              <audio src="http://www.example.com/audio.mp3"/>
              <audio soundLevel="+6dB" clipEnd="2s" src="http://www.example.com/audio2.mp3" repeatDur="5s" clipBegin="1s" repeatCount="4">
                <desc>
                  a cat purring
                </desc>
                PURR (sound didn't load)
              </audio>
              <sub alias="a lie ass">
                alias
              </sub>
              <par>
                <media>
                  <speak>
                    Yeap
                  </speak>
                </media>
                <media soundLevel="soundLevel" repeatDur="repeatDur" fadeInDur="fadeInDur" xml:id="id" end="end" begin="begin" fadeOutDur="fadeOutDur" repeatCount="repeatCount">
                  <audio src="http://www.example.com/audio.mp3"/>
                </media>
              </par>
              <seq>
                <media>
                  <speak>
                    Speak
                  </speak>
                </media>
                <media>
                  <speak>
                    In a seq
                  </speak>
                </media>
              </seq>
            </speak>
        """.stripIndent()
    }

    def '''
        Given demo speak
        When converting dsl to string with pretty print
        Then all nodes are printed out pretty
    '''() {
        given:
        def speak = SsmlDslSamplesKt.demoSpeak()

        when:
        def xml = speak.toString()

        then:
        xml == """\
            <speak>Here are <say-as interpret-as="characters">SSML</say-as> samples.
            I can pause <break time="3s"/>.
            I can play a sound<audio src="https://www.example.com/MY_MP3_FILE.mp3">didn't get your MP3 audio file</audio>.
            I can speak in cardinals. Your number is <say-as interpret-as="cardinal">10</say-as>.
            Or I can speak in ordinals. You are <say-as interpret-as="ordinal">10</say-as> in line.
            Or I can even speak in digits. The digits for ten are <say-as interpret-as="characters">10</say-as>.
            I can also substitute phrases, like the <sub alias="World Wide Web Consortium">W3C</sub>.
            Finally, I can speak a paragraph with two sentences.
            <p><s>This is sentence one.</s><s>This is sentence two.</s></p>
            </speak>""".stripIndent()
    }
}
