package IFRL.Dungeon

class Floor {
    private val columns: Int = (Math.random() * (8 - 2)).toInt() + 3
    private val rows: Int = (Math.random() * (8 - 2)).toInt() + 3
    private val rooms: Array<Room> = Array(columns * rows) { Room(it + 1, it / rows, it % rows) }
    private val doors: MutableList<Door> = mutableListOf()

    init {
//        println("Creating a $rows x $columns floor")
        createDoors()
    }

    private fun createDoors() {
        for (row in 0..(rows - 1)) {
            for (col in 0..(columns - 1)) {
                if (col + 1 < columns) {
                    doors.add(Door(rooms[(row * columns) + col], rooms[(row * columns) + col + 1]))
                }
                if (row + 1 < rows) {
                    doors.add(Door(rooms[(row * columns) + col], rooms[((row + 1) * columns) + col]))
                }
            }
        }
//        println("Door count: ${doors.size}, Room Count: ${rooms.size}")
    }

    fun drawFloor() {
        for (row in 0..(rows - 1)) {
            for (col in 0..(columns - 1)) {
                val currentRoomIndex: Int = (row * columns) + col
                print(rooms[currentRoomIndex].description)
                if (col + 1 < columns) {
                    print(doors[currentRoomIndex].description)
                }
            }
            println()
            for (col in 0..(columns - 1)) {
                if (row + 1 < rows) {
                    print("${doors[((row + 1) * columns) + col].description}   ")
                }
            }
            println()
        }
    }
}