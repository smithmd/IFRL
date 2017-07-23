package IFRL.Dungeon

object Dungeon {
    private val floorCount: Int = (Math.random() * 5).toInt() + 1
    val floors: List<Floor> = List(floorCount) { Floor() }

    init {
        println("Creating a dungeon with $floorCount floor${if (floorCount > 1) "s" else ""}.")
        for (floor in floors) {
            floor.drawFloor()
            println()
        }
    }
}