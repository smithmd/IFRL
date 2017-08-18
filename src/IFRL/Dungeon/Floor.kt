package IFRL.Dungeon

class Floor {
    private val columns: Int = (Math.random() * (8 - 2)).toInt() + 3
    private val rows: Int = (Math.random() * (8 - 2)).toInt() + 3
    val rooms: Array<Room> = Array(columns * rows) { Room(it + 1, it / rows, it % rows) }

    init {
//        println("Creating a $rows x $columns floor")
        createDoors()
    }

    private fun createDoors(): Unit {
        for (row in 0..(rows - 1)) {
            for (col in 0..(columns - 1)) {

            }
        }
    }

    fun drawFloor(): Unit {
        for (row in 0..(rows - 1)) {
            for (col in 0..(columns - 1)) {
                print(rooms[(row * columns) + col].description)
            }
            println()
        }
    }
}