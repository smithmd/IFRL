package IFRL.Dungeon

class Room(id: Int, row: Int, col: Int) {
    val collapsed: Boolean = Math.random() < 0.2
    val description:String = if (collapsed) {"   "} else {"R${id.toString().padStart(2, '0')}"}

    init {
//        println("Creating room number $id ($row, $col)")
    }
}