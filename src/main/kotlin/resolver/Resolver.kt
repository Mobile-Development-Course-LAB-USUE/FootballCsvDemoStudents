package resolver

import model.Player
import model.Position
import model.Team
import kotlin.reflect.KClass

class Resolver(private val players: List<Player>): IResolver {

    override fun getCountWithoutAgency(): Int =
        players.count { it.agency.isEmpty() }


    override fun getBestScorerDefender(): Pair<String, Int> =
        players
            .filter { it.position == Position.DEFENDER }
            .maxBy { it.goalsCount }
            .let { it.name to it.goalsCount }

    override fun getTheExpensiveGermanPlayerPosition() =
        players
            .filter { it.nationality == "Germany" }
            .maxBy { it.goalsCount }
            .let {
                when (it.position) {
                    Position.DEFENDER -> "Защитник"
                    Position.GOALKEEPER -> "Вратарь"
                    Position.MIDFIELD -> "Полузащитник"
                    Position.FORWARD -> "Нападающий"
                    else -> ""
                }
            }

    //Выберите команду с наибольшим числом удалений на одного игрока
    // Выберите команду с наибольшим средним числом удалений на одного игрока.
    override fun getTheRudestTeam(): Team {
        return players
            .groupBy { it.team }
            .maxBy { it.value.sumOf { player -> player.redCardsCount } / it.value.size }.key
    }
}