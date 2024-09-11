package space.kingfu.webpage.flow.model

import space.kingfu.webpage.flow.util.FlowSectionType

data class FlowStyleData(
    val index: Int,
    val section: FlowSectionType,
    val isEdit: Boolean? = null,
    val buttonIndex: Int? = null,
    val buttonUrl: String? = null,
    val text: String? = null,
    val imageUrl: String? = null
)