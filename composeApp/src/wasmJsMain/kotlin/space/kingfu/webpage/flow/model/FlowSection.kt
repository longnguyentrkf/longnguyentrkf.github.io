package space.kingfu.webpage.flow.model


data class FlowSection(
    val title: FlowTextStyle,
    val subtitle: FlowTextStyle,
    val body: FlowTextStyle,
    val footer: FlowTextStyle,
    val buttons: MutableList<FlowTextStyle>,
    val image: FlowTextStyle
)