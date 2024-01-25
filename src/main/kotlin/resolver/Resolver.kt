package resolver

import model.Player
import model.Position
import model.Team

class Resolver(private val players: List<Player>): IResolver {

    override fun getCountWithoutAgency(): Int {
        TODO("Not yet implemented")
    }

    override fun getBestScorerDefender(): Pair<String, Int> =
        players
            .filter { it.position == Position.DEFENDER }
            .maxBy { it.goalsCount }
            .let { player -> player.name to player.goalsCount }

    override fun getTheExpensiveGermanPlayerPosition() =
        players
            .filter { it.nationality == "Germany" }
            .maxBy { it.transferCost }
            .let { it.position.rusName }

    override fun getTheRudestTeam(): Team {
        TODO("Not yet implemented")
    }

}