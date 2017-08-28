package IFRL.Dungeon

class Room(val id: Int, val row: Int, val col: Int) {
    val collapsed: Boolean = Math.random() < 0.2
    val description:String = if (collapsed) {"   "} else {"R${id.toString().padStart(2, '0')}"}
    val debugDescription: String = "$id: ($row, $col)"

    init {
//        println("Creating room number $id ($row, $col)")
    }
}