package IFRL.Dungeon

import java.util.*

class Floor {
    private val columns: Int = (Math.random() * (8 - 2)).toInt() + 3
    private val rows: Int = (Math.random() * (8 - 2)).toInt() + 3
    private val rooms: Array<Room> = Array(columns * rows) { Room(it + 1, it / columns, it % columns) }
    private val doors: MutableMap<Pair<Int, Int>, Door> = mutableMapOf()
    private val roomIndexRange: IntRange
        get() = (0..columns * rows)

    private val startingRoomIndex: Int = roomIndexRange.random()
    private val endingRoomIndex: Int = getEndingRoomIndex()

    // https://stackoverflow.com/questions/45685026/how-can-i-get-a-random-number-in-kotlin
    // TODO: revisit but it's a good starting place for now
    private fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start) + start

    init {
//        println("Creating a $rows x $columns floor")
        createDoors()
        init_flood()
    }

    private fun init_flood(): Unit {
        val touched: MutableList<Room> = mutableListOf()

        flood(rooms[startingRoomIndex], touched)

        // gets here if no path exists between the starting and ending rooms
        if (rooms[endingRoomIndex] in touched) {
            // do something to attempt to close it
            println("*** Ending room reachable. ***")
        } else {
            println("Ending room NOT reachable.")
        }
    }

    private fun flood(node:Room, touched: MutableList<Room>) {
        if (node in touched) return

        touched.add(node)
//        println("touching node at ${node.debugDescription} for ($rows x $columns)")

//        try {
            if (node.row + 1 < rows) {
//                println("Getting SOUTH for ${node.row}, ${node.col}: Index found ${getSouthRoomIndex(node.row, node.col)}")
                flood(rooms[getSouthRoomIndex(node.row, node.col)], touched) // south
            }
            if (node.row - 1 >= 0) {
//                println("Getting NORTH for ${node.row}, ${node.col}: Index found ${getNorthRoomIndex(node.row, node.col)}")
                flood(rooms[getNorthRoomIndex(node.row, node.col)], touched) // north
            }
            if (node.col + 1 < columns) {
//                println("Getting EAST for ${node.row}, ${node.col}: Index found ${getEastRoomIndex(node.row, node.col)}")
                flood(rooms[getEastRoomIndex(node.row, node.col)], touched) // east
            }
            if (node.col - 1 >= 0) {
//                println("Getting WEST for ${node.row}, ${node.col}: Index found ${getWestRoomIndex(node.row, node.col)}")
                flood(rooms[getWestRoomIndex(node.row, node.col)], touched) // west
            }
//        } catch (e:Exception) {
//            println("Exception at: Row: ${node.row}, Col: ${node.col}, max ($rows,$columns)")
//        }
    }

    private fun walk(from: Int, to: Int): Room {
        val d: Door? = doors[Pair(from, to)]
        // TODO: This might be wrong. Needs to check the Door and Room state more anyway. Fine for now.
        return d?.rooms?.second ?: rooms[from]
    }

    private fun createDoors() {
        for (row in 0..(rows - 1)) {
            for (col in 0..(columns - 1)) {
                val currentRoom = getCurrentRoomIndex(row, col)

                if (col + 1 < columns) {
                    val eastRoom = getEastRoomIndex(row, col)
                    doors.put(
                            Pair(currentRoom, eastRoom),
                            Door(Pair(rooms[currentRoom], rooms[eastRoom])))
                }
                if (row + 1 < rows) {
                    val southRoom = getSouthRoomIndex(row, col)
                    doors.put(
                            Pair(currentRoom, southRoom),
                            Door(Pair(rooms[currentRoom], rooms[southRoom])))
                }
            }
        }
//        println("Door count: ${doors.size}, Room Count: ${rooms.size}")
    }

    fun drawFloor() {
        println("($rows x $columns) S: ${rooms[startingRoomIndex].description}, E: ${rooms[endingRoomIndex].description}")
        for (row in 0..(rows - 1)) {
            for (col in 0..(columns - 1)) {
                val currentRoom: Int = getCurrentRoomIndex(row, col)
                print(rooms[currentRoom].description)
                if (col + 1 < columns) {
                    val eastRoom: Int = getEastRoomIndex(row, col)
                    print(doors[Pair(currentRoom, eastRoom)]?.description ?: "   ")
                }
            }
            println()
            for (col in 0..(columns - 1)) {
                if (row + 1 < rows) {
                    val currentRoom: Int = getCurrentRoomIndex(row, col)
                    val southRoom: Int = getSouthRoomIndex(row, col)
                    print("${doors[Pair(currentRoom, southRoom)]?.description}   ")
                }
            }
            println()
        }
    }

    private fun getCurrentRoomIndex(row: Int, col: Int) = (row * columns) + col
    private fun getEastRoomIndex(row: Int, col: Int) = (row * columns) + col + 1
    private fun getWestRoomIndex(row: Int, col: Int) = (row * columns) + col - 1
    private fun getNorthRoomIndex(row: Int, col: Int) = ((row - 1) * columns) + col
    private fun getSouthRoomIndex(row: Int, col: Int) = ((row + 1) * columns) + col

    private fun getEndingRoomIndex(): Int {
        var index = roomIndexRange.random()
        while (index == startingRoomIndex) {
            index = roomIndexRange.random()
        }
        return index
    }
}