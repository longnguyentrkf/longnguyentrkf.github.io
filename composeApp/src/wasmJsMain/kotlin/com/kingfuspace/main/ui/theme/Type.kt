package com.kingfuspace.main.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val Typography = Typography(

    labelSmall = TextStyle(
        fontSize = 4.sp,
        lineHeight = 6.sp, // Reduced for tighter labels
    ),

    labelMedium = TextStyle(
        fontSize = 8.sp,
        lineHeight = 12.sp, // Adjusted for compactness
    ),

    labelLarge = TextStyle(
        fontSize = 12.sp,
        lineHeight = 16.sp, // Proportionate line height
    ),

    bodySmall = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp, // 1.5x for readability
    ),

    bodyMedium = TextStyle(
        fontSize = 24.sp,
        lineHeight = 36.sp, // 1.5x for comfortable reading
    ),

    bodyLarge = TextStyle(
        fontSize = 32.sp,
        lineHeight = 44.sp // Slightly tighter for large body text
    ),

    titleSmall = TextStyle(
        fontSize = 40.sp,
        lineHeight = 52.sp // Tighter for emphasis
    ),

    titleMedium = TextStyle(
        fontSize = 48.sp,
        lineHeight = 60.sp // Balanced line height for titles
    ),

    titleLarge = TextStyle(
        fontSize = 56.sp,
        lineHeight = 68.sp // Tighter for display titles
    ),

    displaySmall = TextStyle(
        fontSize = 64.sp,
        lineHeight = 80.sp // Proportionate for large text
    ),

    displayMedium = TextStyle(
        fontSize = 72.sp,
        lineHeight = 90.sp // Slightly tighter for better visual impact
    ),

    displayLarge = TextStyle(
        fontSize = 80.sp,
        lineHeight = 96.sp // Optimized for readability and aesthetics
    )
)

@Composable
fun TypographyPreview() {
    val textStyles = listOf(
        "Label Small" to typography.labelSmall,
        "Label Medium" to typography.labelMedium,
        "Label Large" to typography.labelLarge,
        "Body Small" to typography.bodySmall,
        "Body Medium" to typography.bodyMedium,
        "Body Large" to typography.bodyLarge,
        "Title Small" to typography.titleSmall,
        "Title Medium" to typography.titleMedium,
        "Title Large" to typography.titleLarge,
        "Display Small" to typography.displaySmall,
        "Display Medium" to typography.displayMedium,
        "Display Large" to typography.displayLarge,
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 16.dp),
        verticalArrangement = Arrangement.spacedBy(space = 8.dp)
    ) {
        items(textStyles.size) { index ->
            Column {
                Text(
                    text = textStyles[index].first,
                    style = typography.labelMedium,
                    color = Color.Gray
                )
                Text(
                    text = "The quick brown fox jumps over the lazy dog.",
                    style = textStyles[index].second
                )
            }
        }
    }
}