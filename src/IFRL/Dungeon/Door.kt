package IFRL.Dungeon

class Door(room1: Room, room2: Room) {
    var isOpen: Boolean = true
    var sealed: Boolean = Math.random() < 0.25
}