package IFRL

import IFRL.Actor.Actor
import IFRL.Actor.Player
import IFRL.Dungeon.Dungeon

fun main(args: Array<String>) {
    val dungeon = Dungeon
    val actors: MutableList<Actor> = MutableList()

    val player = Player()
    actors.add(player)
}