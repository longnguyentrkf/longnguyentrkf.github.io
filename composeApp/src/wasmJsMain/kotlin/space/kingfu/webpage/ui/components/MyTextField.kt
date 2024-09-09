package space.kingfu.webpage.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import space.kingfu.webpage.ui.theme.Shape
import space.kingfu.webpage.ui.theme.Space
import space.kingfu.webpage.ui.theme.Typography


@Composable
fun MyTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    style: TextStyle = Typography.bodySmall,
    color: Color = colorScheme.outline,
    contentAlignment: Alignment = Alignment.CenterStart,
    fontWeight: FontWeight = FontWeight.Normal,
    done: ((Boolean) -> Unit)? = null,
    singleLine: Boolean = false,
    maxLine: Int = 5,
    textAlign: TextAlign = TextAlign.Start,
    maxChar: Int = 200,
    fontStyle: FontStyle = FontStyle.Normal
) {
    val focusRequester = remember { FocusRequester() }

    BasicTextField(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = Shape.extraSmall)
            .background(color = colorScheme.surfaceContainer)
            .focusRequester(focusRequester = focusRequester),
//            .height(height = 40.dp),
        value = value,
        onValueChange = {
            if (it.length <= maxChar) {
                onValueChange(it)
            }
        },
        maxLines = maxLine,
        singleLine = singleLine,
        textStyle = style.copy(
            color = colorScheme.inverseSurface,
            fontWeight = fontWeight,
            textAlign = textAlign,
            fontStyle = fontStyle
        ),
        cursorBrush = Brush.linearGradient(
            listOf(colorScheme.inverseSurface, colorScheme.inverseSurface)
        ),
        decorationBox = { innerTextField ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .weight(weight = 0.9f)
                        .padding(start = Space().small_8),
                    contentAlignment = contentAlignment
                ) {

                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            color = color,
                            style = style,
                            fontStyle = fontStyle
                        )
                    }
                    innerTextField()

                }

                if (done != null) {
                    IconButton(
                        modifier = Modifier.weight(weight = 0.1f),
                        onClick = { done(true) }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Done,
                            contentDescription = null
                        )
                    }
                }
            }
        }
    )
}