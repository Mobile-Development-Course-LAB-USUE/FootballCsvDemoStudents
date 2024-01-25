import parser.CsvParser
import resolver.Resolver

fun main(args: Array<String>) {
    val players = CsvParser.parse("src/main/resources/fakePlayers.csv")
    val resolver = Resolver(players)
    print(resolver.getBestScorerDefender())
    print(resolver.getTheExpensiveGermanPlayerPosition())
}