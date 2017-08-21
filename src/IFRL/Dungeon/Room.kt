package IFRL.Dungeon

class Room(id: Int, row: Int, col: Int) {
    private val open: Boolean = Math.random() > 0.2
    val description:String = if (open) {"R${id.toString().padStart(2, '0')} "} else {"    "}
    val doors: Array<Boolean> = Array(4) { false }

    init {
//        println("Creating room number $id ($row, $col)")
    }
}