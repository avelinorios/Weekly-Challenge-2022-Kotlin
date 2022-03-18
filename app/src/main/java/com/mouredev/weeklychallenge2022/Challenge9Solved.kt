package com.mouredev.weeklychallenge2022

/*
 * Reto #9
 * CÓDIGO MORSE
 * Fecha publicación enunciado: 02/03/22
 * Fecha publicación resolución: 07/03/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa que sea capaz de transformar texto natural a código morse y viceversa.
 * - Debe detectar automáticamente de qué tipo se trata y realizar la conversión.
 * - En morse se soporta raya "-", punto ".", un espacio " " entre letras o símbolos y dos espacios entre palabras "  ".
 * - El alfabeto morse soportado será el mostrado en https://es.wikipedia.org/wiki/Código_morse.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */
class MorseTranslator {

    val morseAlphabet = mapOf("A" to ".-", "N" to "-.", "0" to "-----",
        "B" to "-...", "Ñ" to "--.--", "1" to ".----",
        "C" to "-.-.", "O" to "---", "2" to "..---",
        "CH" to "----", "P" to ".--.", "3" to "...--",
        "D" to "-..", "Q" to "--.-", "4" to "....-",
        "E" to ".", "R" to ".-.", "5" to ".....",
        "F" to "..-.", "S" to "...", "6" to "-....",
        "G" to "--.", "T" to "-", "7" to "--...",
        "H" to "....", "U" to "..-", "8" to "---..",
        "I" to "..", "V" to "...-", "9" to "----.",
        "J" to ".---", "W" to ".--", "." to ".-.-.-",
        "K" to "-.-", "X" to "-..-", "," to "--..--",
        "L" to ".-..", "Y" to "-.--", "?" to "..--..",
        "M" to "--", "Z" to "--..", "\"" to ".-..-.", "/" to "-..-.")

     fun translate(message: String): String {
         if (isMorse(message)) {
             return morseToText(message)
         }
         return textToMorse(message)
     }

    private fun isMorse(message: String): Boolean {
        return message.contains("-") || message.contains(".")
    }

    fun getKey(target: String): String {
        for ((key, value) in morseAlphabet)
        {
            if (target == value) {
                return key
            }
        }
        return ""
    }

    fun morseToText(message: String): String {
        val morseWords = message.split(" ")

        var translatedWord = ""
        for (element in morseWords) {
            var textElement = getKey(element)
            if (textElement.equals("/")) {
                textElement = " "
            }
             translatedWord += textElement
        }
        return translatedWord
    }

    fun textToMorse(message: String): String {
        val array: Array<String> = message.toCharArray().map { it.toString() }.toTypedArray()
        var translatedText =""

        for (element in array) {
            var letter = ""
            if (" ".equals(element)) {
                letter = "/"
            } else {
                letter = morseAlphabet.get(element.uppercase()).toString()
            }
            if (translatedText.length == 0) {
                translatedText += letter
                continue
            }
            translatedText += " $letter"
        }
        return translatedText
    }
}
