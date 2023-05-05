fun main() {
    println(agoToText(20254))

}

fun agoToText(secondsSinceLogin: Int): String = when (secondsSinceLogin) {
    in 1..60 -> "был(а) в сети только что"
    in 61..60 * 60 -> "был(а) в сети ${calculateMinuts(secondsSinceLogin)}"
    in 60 * 60 + 1..24 * 60 * 60 -> "был(а) в сети ${calculateHours(secondsSinceLogin)}"
    in 24 * 60 * 60 + 1..24 * 60 * 60 * 2 -> "был(а) в сети вчера"
    in 24 * 60 * 60 * 2 + 1..24 * 60 * 60 * 3 -> "был(а) в сети позавчера"
    else -> "был(а) в сети давно"
}

fun calculateMinuts(seconds: Int): String {
    var minuts: Int = seconds / 60

    return when {
        minuts % 10 == 1 && minuts != 11 -> "$minuts минуту назад"
        minuts % 10 in 2..4 && minuts !in 12..14 -> "$minuts минуты назад"
        else -> "$minuts минут назад"
    }
}

fun calculateHours(seconds: Int): String {
    var hours: Int = (seconds / 60) / 60

    return when {
        hours % 10 == 1 && hours != 11 -> "$hours час назад"
        hours % 10 in 2..4 && hours !in 12..14 -> "$hours часа назад"
        else -> "$hours часов назад"
    }
}