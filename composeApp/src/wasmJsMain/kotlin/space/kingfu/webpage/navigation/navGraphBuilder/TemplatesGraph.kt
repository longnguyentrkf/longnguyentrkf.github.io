package space.kingfu.webpage.navigation.navGraphBuilder

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import space.kingfu.webpage.templates.TemplateScreen
import space.kingfu.webpage.templates.viewModel.TemplateViewModel
import space.kingfu.webpage.navigation.Screen


fun NavGraphBuilder.templatesGraph(navController: NavHostController) {
    composable(route = Screen.Templates.route) {
        val vm = TemplateViewModel()

        TemplateScreen(
            goToPureFrame = {
                navController.navigate(route = Screen.Flow.route)
            }
        )
    }
}