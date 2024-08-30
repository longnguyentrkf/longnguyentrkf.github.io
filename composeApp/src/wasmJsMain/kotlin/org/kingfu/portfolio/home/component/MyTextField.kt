package org.kingfu.portfolio.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.kingfu.imaginate.ui.theme.TextBodyLarge
import org.kingfu.portfolio.ui.theme.Shape


@Composable
fun MyTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    focusRequester: FocusRequester,
    placeholder: String
) {
    BasicTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        modifier = modifier
            .clip(shape = Shape.extraSmall)
            .background(color = colorScheme.surfaceContainer)
            .focusRequester(focusRequester = focusRequester)
            .height(height = 40.dp),
        maxLines = 1,
        singleLine = true,
        textStyle = LocalTextStyle.current.copy(
            color = colorScheme.inverseSurface,
            fontSize = typography.bodyLarge.fontSize
        ),
        cursorBrush = Brush.linearGradient(
            listOf(colorScheme.inverseSurface, colorScheme.inverseSurface)
        ),
        decorationBox = { innerTextField ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .weight(weight = 1f)
                        .padding(start = 8.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (value.isEmpty()) {
                        TextBodyLarge(
                            text = placeholder,
                            color = colorScheme.outline
                        )
                    }
                    innerTextField()
                }
            }
        }
    )
}