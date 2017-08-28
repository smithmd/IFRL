package IFRL.Dungeon

class Door(val rooms: Pair<Room, Room>) {
    private val noDoor: Boolean = rooms.first.collapsed || rooms.second.collapsed
    private val sealed: Boolean = Math.random() < 0.05
    private var isOpen: Boolean = !sealed && Math.random() < 0.1
    val description: String = " ${ if(noDoor) { " " } else { if (sealed) { "~" } else { if (isOpen) { "o" } else { "c" } } } } "

    fun open() { if (!sealed) isOpen = true }
    fun close() { if (!sealed) isOpen = false }
}