package com.mouredev.weeklychallenge2022

/*
 * Reto #7
 * CONTANDO PALABRAS
 * Fecha publicación enunciado: 14/02/22
 * Fecha publicación resolución: 21/02/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa que cuente cuantas veces se repite cada palabra y que muestre el recuento final de todas ellas.
 * - Los signos de puntuación no forman parte de la palabra.
 * - Una palabra es la misma aunque aparezca en mayúsculas y minúsculas.
 * - No se pueden utilizar funciones propias del lenguaje que lo resuelvan automáticamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */


fun main() {
    val text = "Esto es una prueba Prueba prueba prueba."
    println(countNumOcurrences(text))
}

private fun countNumOcurrences(text: String): String {
    val wordOcurrences : HashMap<String, Int> = HashMap<String, Int> ()
    for (element in text.split(" ")) {
        countWord(wordOcurrences, element)
    }
    return wordOcurrences.toString();
}

private fun countWord(wordOcurrences: HashMap<String, Int>, element: String) {
    val cleanWord = cleanWord(element)
    if (wordOcurrences.containsKey(cleanWord)) {
        val value = wordOcurrences.get(cleanWord)
        if (value != null) {
            wordOcurrences[cleanWord.lowercase()] = value.plus(1)
        }
    } else {
        wordOcurrences.put(cleanWord, 1)
    }
}

fun cleanWord(word: String): String {
    val regex = Regex("[^A-Za-z0-9 ]")
    return regex.replace(word, "").lowercase()
}
