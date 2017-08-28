package IFRL.Dungeon

class Door(room1: Room, room2: Room) {
    private val noDoor: Boolean = room1.collapsed || room2.collapsed
    private val sealed: Boolean = Math.random() < 0.05
    private var isOpen: Boolean = !sealed && Math.random() < 0.1
    val description: String = " ${ if(noDoor) { " " } else { if (sealed) { "~" } else { if (isOpen) { "o" } else { "c" } } } } "

    fun open() { if (!sealed) isOpen = true }
    fun close() { if (!sealed) isOpen = false }
}