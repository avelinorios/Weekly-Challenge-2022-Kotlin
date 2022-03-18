package com.mouredev.weeklychallenge2022

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class Challenge9SolvedTest {

    lateinit var morseTraslator: MorseTranslator

    @Before
    fun setup() {
        morseTraslator = MorseTranslator();
    }


    @Test
    fun traducir_morseToText() {
        val expectedText = "HOLA MUNDO"
        val message = ".... --- .-.. .- / -- ..- -. -.. ---"

        val text = morseTraslator.translate(message)

        Assert.assertEquals(expectedText, text)
    }

    @Test
    fun traducir_textToMorse() {
        val message = "HOLA MUNDO"
        val expectedText = ".... --- .-.. .- / -- ..- -. -.. ---"

        val text = morseTraslator.translate(message)

        Assert.assertEquals(expectedText, text)
    }

    @Test
    fun getKey() {
        val expectedText = "O"
        val message = "---"

        val text = morseTraslator.getKey(message)

        Assert.assertEquals(expectedText, text)
    }




}