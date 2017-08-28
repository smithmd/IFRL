package IFRL.Dungeon

class Floor {
    private val columns: Int = (Math.random() * (8 - 2)).toInt() + 3
    private val rows: Int = (Math.random() * (8 - 2)).toInt() + 3
    private val rooms: Array<Room> = Array(columns * rows) { Room(it + 1, it / rows, it % rows) }
    private val doors: MutableMap<Pair<Int,Int>, Door> = mutableMapOf()

    init {
//        println("Creating a $rows x $columns floor")
        createDoors()
    }

    private fun createDoors() {
        for (row in 0..(rows - 1)) {
            for (col in 0..(columns - 1)) {
                val currentRoom = getCurrentRoomIndex(row,col)

                if (col + 1 < columns) {
                    val eastRoom = getEastRoomIndex(row,col)
                    doors.put(Pair(currentRoom,eastRoom),Door(rooms[currentRoom], rooms[eastRoom]))
                }
                if (row + 1 < rows) {
                    val southRoom = getSouthRoomIndex(row,col)
                    doors.put(Pair(currentRoom,southRoom),Door(rooms[currentRoom], rooms[southRoom]))
                }
            }
        }
//        println("Door count: ${doors.size}, Room Count: ${rooms.size}")
    }

    fun drawFloor() {
        for (row in 0..(rows - 1)) {
            for (col in 0..(columns - 1)) {
                val currentRoom: Int = getCurrentRoomIndex(row,col)
                print(rooms[currentRoom].description)
                if (col + 1 < columns) {
                    val eastRoom: Int = getEastRoomIndex(row,col)
                    print(doors[Pair(currentRoom, eastRoom)]?.description ?: "   ")
                }
            }
            println()
            for (col in 0..(columns - 1)) {
                if (row + 1 < rows) {
                    val currentRoom: Int = getCurrentRoomIndex(row,col)
                    val southRoom:Int = getSouthRoomIndex(row,col)
                    print("${doors[Pair(currentRoom, southRoom)]?.description}   ")
                }
            }
            println()
        }
    }

    private fun getCurrentRoomIndex(row:Int, col:Int) = (row * columns) + col
    private fun getEastRoomIndex(row:Int, col:Int) = (row * columns) + col + 1
    private fun getSouthRoomIndex(row:Int, col:Int) = ((row + 1) * columns) + col
}