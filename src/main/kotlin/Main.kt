import parser.CsvParser
import resolver.Resolver

fun main(args: Array<String>) {
    val players = CsvParser.parse("src/main/resources/fakePlayers.csv")
    val resolver = Resolver(players)
    println(resolver.getCountWithoutAgency())
    println(resolver.getBestScorerDefender())
    println(resolver.getTheExpensiveGermanPlayerPosition())
    println(resolver.getTheRudestTeam())
}