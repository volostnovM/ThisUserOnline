fun main() {
    println(agoToText(100000))

}

fun agoToText(secondsSinceLogin: Int): String = when (secondsSinceLogin) {
    in 1..60 -> "был(а) в сети только что"
    in 61..60 * 60 -> "был(а) в сети ${calculateMinuts(secondsSinceLogin)}"
    in 60 * 60 + 1..24 * 60 * 60 -> "был(а) в сети ${calculateHours(secondsSinceLogin)}"
    in 24 * 60 * 60 + 1 .. 24 * 60 * 60 * 2 -> "был(а) в сети вчера"
    in 24 * 60 * 60 * 2 + 1 .. 24 * 60 * 60 * 3 ->  "был(а) в сети позавчера"
    else -> "был(а) в сети давно"
}

fun calculateMinuts(seconds: Int): String {
    var minuts: Int = seconds / 60
    when(minuts) {
        1 -> return "$minuts минуту назад"
        in 2 .. 4 -> return "$minuts минуты назад"
        in 6 .. 9 -> return "$minuts минут назад"
        5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55 -> return "$minuts минут назад"
        11, 21, 31, 41, 51 -> return "$minuts минут назад"
        in 12 .. 19 -> return "$minuts минут назад"
        in 22 .. 29 -> return "$minuts минут назад"
        in 32 .. 39 -> return "$minuts минут назад"
        in 42 .. 49 -> return "$minuts минут назад"
        in 52 .. 59 -> return "$minuts минут назад"
        else -> return "недавно"
    }
}

fun calculateHours(seconds: Int): String {
    var hours: Int = (seconds / 60) / 60
    when(hours) {
        1 -> return "$hours час назад"
        in 2 .. 4 -> return "$hours часа назад"
        in 6 .. 19 -> return "$hours часов назад"
        5, 10, 15, 20 -> return "$hours часов назад"
        21 -> return "$hours час назад"
        in 22 .. 24 -> return "$hours часа назад"
        else -> return "недавно"
    }
}