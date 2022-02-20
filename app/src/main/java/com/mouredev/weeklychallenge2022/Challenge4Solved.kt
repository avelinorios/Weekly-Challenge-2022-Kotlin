package com.mouredev.weeklychallenge2022

/*
 * Reto #4
 * ÁREA DE UN POLÍGONO
 * Fecha publicación enunciado: 24/01/22
 * Fecha publicación resolución: 31/01/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea UNA ÚNICA FUNCIÓN (importante que sólo sea una) que sea capaz de calcular y retornar el área de un polígono.
 * - La función recibirá por parámetro sólo UN polígono a la vez.
 * - Los polígonos soportados serán Triángulo, Cuadrado y Rectángulo.
 * - Imprime el cálculo del área de un polígono de cada tipo.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */
const val MENSAJE_AREA = "El área es: "

fun main() {
    calcularArea(Triangulo(2, 3))
    calcularArea(Rectangulo(2, 3))
    calcularArea(Cuadrado(2))
}

fun calcularArea(poligono: Poligono) {
    return poligono.imprimirArea()
}

interface Poligono {
    fun calcularArea(): Int
    fun imprimirArea() {
        return println(MENSAJE_AREA + "${calcularArea()}")
    }
}

data class Triangulo(val base: Int, val altura: Int): Poligono {
    override fun calcularArea(): Int {
        return (base * altura) / 2
    }
}

data class Rectangulo(val base: Int, val altura: Int): Poligono {
    override fun calcularArea(): Int {
        return base * altura
    }
}

data class Cuadrado(val lado: Int): Poligono {
    override fun calcularArea(): Int {
        return lado * lado
    }
}

