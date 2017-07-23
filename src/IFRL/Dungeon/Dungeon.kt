package IFRL.Dungeon

object Dungeon {
    val floorCount: Int = (Math.random() * 5).toInt() + 1
    val floors: Array<Floor> = Array(floorCount, { Floor() })

    init {
        println("Creating a dungeon with $floorCount floor${if (floorCount > 1) "s" else ""}.")
        for (i in 0..(floorCount - 1)) {
            floors[i].drawFloor()
            println()
        }
    }
}