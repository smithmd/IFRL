package IFRL.Dungeon

class Room(id: Int) {
    val description:String = "R${id.toString().padStart(2,'0')} "
    init {
//        println("Creating room number $id")
    }
}