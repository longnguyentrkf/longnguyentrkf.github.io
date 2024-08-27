package org.kingfu.portfolio.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import com.kingfu.imaginate.ui.theme.ThemeType
import com.kingfu.imaginate.ui.theme.darkBackground
import com.kingfu.imaginate.ui.theme.darkError
import com.kingfu.imaginate.ui.theme.darkErrorContainer
import com.kingfu.imaginate.ui.theme.darkInverseOnSurface
import com.kingfu.imaginate.ui.theme.darkInversePrimary
import com.kingfu.imaginate.ui.theme.darkInverseSurface
import com.kingfu.imaginate.ui.theme.darkOnBackground
import com.kingfu.imaginate.ui.theme.darkOnError
import com.kingfu.imaginate.ui.theme.darkOnErrorContainer
import com.kingfu.imaginate.ui.theme.darkOnPrimary
import com.kingfu.imaginate.ui.theme.darkOnPrimaryContainer
import com.kingfu.imaginate.ui.theme.darkOnSecondary
import com.kingfu.imaginate.ui.theme.darkOnSecondaryContainer
import com.kingfu.imaginate.ui.theme.darkOnSurface
import com.kingfu.imaginate.ui.theme.darkOnSurfaceVariant
import com.kingfu.imaginate.ui.theme.darkOnTertiary
import com.kingfu.imaginate.ui.theme.darkOnTertiaryContainer
import com.kingfu.imaginate.ui.theme.darkOutline
import com.kingfu.imaginate.ui.theme.darkOutlineVariant
import com.kingfu.imaginate.ui.theme.darkPrimary
import com.kingfu.imaginate.ui.theme.darkPrimaryContainer
import com.kingfu.imaginate.ui.theme.darkScrim
import com.kingfu.imaginate.ui.theme.darkSecondary
import com.kingfu.imaginate.ui.theme.darkSecondaryContainer
import com.kingfu.imaginate.ui.theme.darkSurface
import com.kingfu.imaginate.ui.theme.darkSurfaceBright
import com.kingfu.imaginate.ui.theme.darkSurfaceContainer
import com.kingfu.imaginate.ui.theme.darkSurfaceContainerHigh
import com.kingfu.imaginate.ui.theme.darkSurfaceContainerHighest
import com.kingfu.imaginate.ui.theme.darkSurfaceContainerLow
import com.kingfu.imaginate.ui.theme.darkSurfaceContainerLowest
import com.kingfu.imaginate.ui.theme.darkSurfaceDim
import com.kingfu.imaginate.ui.theme.darkSurfaceTint
import com.kingfu.imaginate.ui.theme.darkSurfaceVariant
import com.kingfu.imaginate.ui.theme.darkTertiary
import com.kingfu.imaginate.ui.theme.darkTertiaryContainer
import com.kingfu.imaginate.ui.theme.lightBackground
import com.kingfu.imaginate.ui.theme.lightError
import com.kingfu.imaginate.ui.theme.lightErrorContainer
import com.kingfu.imaginate.ui.theme.lightInverseOnSurface
import com.kingfu.imaginate.ui.theme.lightInversePrimary
import com.kingfu.imaginate.ui.theme.lightInverseSurface
import com.kingfu.imaginate.ui.theme.lightOnBackground
import com.kingfu.imaginate.ui.theme.lightOnError
import com.kingfu.imaginate.ui.theme.lightOnErrorContainer
import com.kingfu.imaginate.ui.theme.lightOnPrimary
import com.kingfu.imaginate.ui.theme.lightOnPrimaryContainer
import com.kingfu.imaginate.ui.theme.lightOnSecondary
import com.kingfu.imaginate.ui.theme.lightOnSecondaryContainer
import com.kingfu.imaginate.ui.theme.lightOnSurface
import com.kingfu.imaginate.ui.theme.lightOnSurfaceVariant
import com.kingfu.imaginate.ui.theme.lightOnTertiary
import com.kingfu.imaginate.ui.theme.lightOnTertiaryContainer
import com.kingfu.imaginate.ui.theme.lightOutline
import com.kingfu.imaginate.ui.theme.lightOutlineVariant
import com.kingfu.imaginate.ui.theme.lightPrimary
import com.kingfu.imaginate.ui.theme.lightPrimaryContainer
import com.kingfu.imaginate.ui.theme.lightScrim
import com.kingfu.imaginate.ui.theme.lightSecondary
import com.kingfu.imaginate.ui.theme.lightSecondaryContainer
import com.kingfu.imaginate.ui.theme.lightSurface
import com.kingfu.imaginate.ui.theme.lightSurfaceBright
import com.kingfu.imaginate.ui.theme.lightSurfaceContainer
import com.kingfu.imaginate.ui.theme.lightSurfaceContainerHigh
import com.kingfu.imaginate.ui.theme.lightSurfaceContainerHighest
import com.kingfu.imaginate.ui.theme.lightSurfaceContainerLow
import com.kingfu.imaginate.ui.theme.lightSurfaceContainerLowest
import com.kingfu.imaginate.ui.theme.lightSurfaceDim
import com.kingfu.imaginate.ui.theme.lightSurfaceTint
import com.kingfu.imaginate.ui.theme.lightSurfaceVariant
import com.kingfu.imaginate.ui.theme.lightTertiary
import com.kingfu.imaginate.ui.theme.lightTertiaryContainer


private val darkColorScheme = darkColorScheme(
    primary = darkPrimary,
    onPrimary = darkOnPrimary,
    primaryContainer = darkPrimaryContainer,
    onPrimaryContainer = darkOnPrimaryContainer,
    inversePrimary = darkInversePrimary,
    secondary = darkSecondary,
    onSecondary = darkOnSecondary,
    secondaryContainer = darkSecondaryContainer,
    onSecondaryContainer = darkOnSecondaryContainer,
    tertiary = darkTertiary,
    onTertiary = darkOnTertiary,
    tertiaryContainer = darkTertiaryContainer,
    onTertiaryContainer = darkOnTertiaryContainer,
    background = darkBackground,
    onBackground = darkOnBackground,
    surface = darkSurface,
    onSurface = darkOnSurface,
    surfaceVariant = darkSurfaceVariant,
    onSurfaceVariant = darkOnSurfaceVariant,
    surfaceTint = darkSurfaceTint,
    inverseSurface = darkInverseSurface,
    onError = darkOnError,
    onErrorContainer = darkOnErrorContainer,
    outline = darkOutline,
    outlineVariant = darkOutlineVariant,
    scrim = darkScrim,
    surfaceBright = darkSurfaceBright,
    surfaceDim = darkSurfaceDim,
    surfaceContainer = darkSurfaceContainer,
    surfaceContainerHigh = darkSurfaceContainerHigh,
    surfaceContainerHighest = darkSurfaceContainerHighest,
    surfaceContainerLow = darkSurfaceContainerLow,
    surfaceContainerLowest = darkSurfaceContainerLowest,
    error = darkError,
    errorContainer = darkErrorContainer,
    inverseOnSurface = darkInverseOnSurface
)

private val lightColorScheme = lightColorScheme(
    primary = lightPrimary,
    onPrimary = lightOnPrimary,
    primaryContainer = lightPrimaryContainer,
    onPrimaryContainer = lightOnPrimaryContainer,
    inversePrimary = lightInversePrimary,
    secondary = lightSecondary,
    onSecondary = lightOnSecondary,
    secondaryContainer = lightSecondaryContainer,
    onSecondaryContainer = lightOnSecondaryContainer,
    tertiary = lightTertiary,
    onTertiary = lightOnTertiary,
    tertiaryContainer = lightTertiaryContainer,
    onTertiaryContainer = lightOnTertiaryContainer,
    background = lightBackground,
    onBackground = lightOnBackground,
    surface = lightSurface,
    onSurface = lightOnSurface,
    surfaceVariant = lightSurfaceVariant,
    onSurfaceVariant = lightOnSurfaceVariant,
    surfaceTint = lightSurfaceTint,
    inverseSurface = lightInverseSurface,
    onError = lightOnError,
    onErrorContainer = lightOnErrorContainer,
    outline = lightOutline,
    outlineVariant = lightOutlineVariant,
    scrim = lightScrim,
    surfaceBright = lightSurfaceBright,
    surfaceDim = lightSurfaceDim,
    surfaceContainer = lightSurfaceContainer,
    surfaceContainerHigh = lightSurfaceContainerHigh,
    surfaceContainerHighest = lightSurfaceContainerHighest,
    surfaceContainerLow = lightSurfaceContainerLow,
    surfaceContainerLowest = lightSurfaceContainerLowest,
    error = lightError,
    errorContainer = lightErrorContainer,
    inverseOnSurface = lightInverseOnSurface
)


@Composable
fun PortfolioTheme(
    content: @Composable () -> Unit,
    theme: ThemeType = ThemeType.LIGHT
) {
    val colorScheme = when (theme) {
        ThemeType.DARK -> darkColorScheme
        ThemeType.LIGHT -> lightColorScheme
        ThemeType.SYSTEM -> if (isSystemInDarkTheme()) darkColorScheme else lightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = typography,
        content = content
    )
}
