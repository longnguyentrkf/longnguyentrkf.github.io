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

val typography = Typography(
//
//    labelSmall = TextStyle(
//        fontSize = 12.sp, // Starting size (like previous labelLarge)
//        lineHeight = 16.sp, // Proportionate line height
//        letterSpacing = 0.2.sp
//    ),
//
//    labelMedium = TextStyle(
//        fontSize = 16.sp, // Larger than labelSmall
//        lineHeight = 24.sp,
//        letterSpacing = 0.25.sp
//    ),
//
//    labelLarge = TextStyle(
//        fontSize = 20.sp, // Larger than labelMedium
//        lineHeight = 28.sp,
//        letterSpacing = 0.3.sp
//    ),
//
//    bodySmall = TextStyle(
//        fontSize = 24.sp, // Larger than labelLarge
//        lineHeight = 32.sp,
//        letterSpacing = 0.35.sp
//    ),
//
//    bodyMedium = TextStyle(
//        fontSize = 32.sp, // Progressively larger
//        lineHeight = 40.sp,
//        letterSpacing = 0.4.sp
//    ),
//
//    bodyLarge = TextStyle(
//        fontSize = 40.sp, // Larger body text
//        lineHeight = 52.sp,
//        letterSpacing = 0.45.sp
//    ),
//
//    titleSmall = TextStyle(
//        fontSize = 48.sp, // Larger emphasis
//        lineHeight = 60.sp,
//        letterSpacing = 0.4.sp
//    ),
//
//    titleMedium = TextStyle(
//        fontSize = 56.sp, // Even larger
//        lineHeight = 68.sp,
//        letterSpacing = 0.35.sp
//    ),
//
//    titleLarge = TextStyle(
//        fontSize = 64.sp, // Significant size increase
//        lineHeight = 80.sp,
//        letterSpacing = 0.3.sp
//    ),
//
//    displaySmall = TextStyle(
//        fontSize = 72.sp, // Display level
//        lineHeight = 90.sp,
//        letterSpacing = 0.25.sp
//    ),
//
//    displayMedium = TextStyle(
//        fontSize = 80.sp, // Bigger display size
//        lineHeight = 100.sp,
//        letterSpacing = 0.2.sp
//    ),
//
//    displayLarge = TextStyle(
//        fontSize = 96.sp, // Largest size
//        lineHeight = 112.sp,
//        letterSpacing = 0.15.sp
//    )
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