package IFRL.Dungeon

class Door(room1: Room, room2: Room) {
    private val sealed: Boolean = room1.collapsed || room2.collapsed
    private var isOpen: Boolean = !sealed && Math.random() < 0.1
    val description: String = " ${if (sealed) { " " } else { if (isOpen) { "o" } else { "c" } } } "

    fun open() { if (!sealed) isOpen = true }
    fun close() { if (!sealed) isOpen = false }
}