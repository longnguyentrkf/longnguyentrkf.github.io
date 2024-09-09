package space.kingfu.webpage.flow.model

data class Details(
    val title: Pair<String, Boolean> = Pair("", true),
    val subtitle: Pair<String, Boolean> = Pair("", true),
    val body: Pair<String, Boolean> = Pair("", true),
    val footer: Pair<String, Boolean> = Pair("", true),
    val button: Pair<Pair<String, String>, Boolean> = Pair(Pair("", ""), true)
)