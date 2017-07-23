package IFRL.Dungeon

class Floor {
    val columns: Int = (Math.random() * (8 - 2)).toInt() + 3
    val rows: Int = (Math.random() * (8 - 2)).toInt() + 3
    val rooms: Array<Room> = Array(columns * rows, { Room(it + 1) })

    init {
        println("Creating a $columns x $rows floor")
    }

    fun drawFloor(): Unit {
        for (col in 0..(columns - 1)) {
            for (row in 0..(rows - 1)) {
                print(rooms[(col * rows) + row].description)
            }
            println()
        }
    }
}