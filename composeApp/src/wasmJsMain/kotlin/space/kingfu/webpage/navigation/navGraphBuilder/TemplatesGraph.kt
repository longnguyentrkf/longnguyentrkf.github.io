package space.kingfu.webpage.navigation.navGraphBuilder

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import space.kingfu.templates.TemplateScreen
import space.kingfu.templates.viewModel.TemplateViewModel
import space.kingfu.webpage.navigation.Screen


fun NavGraphBuilder.templatesGraph(
) {
    composable(route = Screen.Templates.route) {
        val vm = TemplateViewModel()

        TemplateScreen(
        )
    }
}