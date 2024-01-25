package model

enum class Position(val rusName: String = "") {
    GOALKEEPER("Вр"),
    DEFENDER("Защ"),
    MIDFIELD("Пз"),
    FORWARD("Нап"),
    OTHER;

    companion object {
        fun getByValue(position: String): Position = entries.find { it.name == position } ?: OTHER
    }
}