package IFRL.Dungeon

class Room(id: Int, row: Int, col: Int) {
    val collapsed: Boolean = Math.random() < 0.2
    val description:String = if (!collapsed) {"R${id.toString().padStart(2, '0')}"} else {"   "}
    val doors: Array<Boolean> = Array(4) { false }

    init {
//        println("Creating room number $id ($row, $col)")
    }
}