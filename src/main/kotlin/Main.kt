var text = ""
var minutes = 0
var seconds = 0
var hours = 0

fun agoToText(seconds:Int):String{
    when(seconds){
        in 0..60-> text = "только что"
        in 61..60*60 -> text = "${convertToMinutes(seconds)} ${printMinutes(minutes)} назад"
        in 60*60+1..24*60*60 -> text ="${convertToHours(seconds)} ${printHours(hours)} назад"
        in 86400..172800-1 -> text = "сегодня"
        in 172800..259200-1 -> text = "вчера"
        else -> text = "давно"
    }
    return text
}

fun convertToMinutes(seconds: Int):Int{
    minutes = seconds/60
    return minutes
}

fun convertToHours(seconds: Int):Int{
    hours = seconds/3600
    return hours
}

fun printMinutes(minutes: Int):String{
    var textMin = ""
    when(minutes){
        1,21,31,41,51 -> textMin = "минуту"
        in 2..4, in 22..24,in 32..34,in 42..44, in 52..54-> textMin = "минуты"
        in 5..20,in 25..30,in 35..40,in 45..50,in 55..60 -> textMin ="минут"
    }
    return textMin
}

fun printHours(hours: Int):String{
    var textHours = ""
    when(hours){
        1,21 -> textHours = "час"
        in 2..4,in 22..23 -> textHours = "часа"
        in 5..20 -> textHours = "часов"
    }
    return textHours
}

fun main(args: Array<String>) {
    println("Введите количество секунд")
    seconds = readLine()!!.toInt()
    println("Был(а) в сети ${agoToText(seconds)}")
}