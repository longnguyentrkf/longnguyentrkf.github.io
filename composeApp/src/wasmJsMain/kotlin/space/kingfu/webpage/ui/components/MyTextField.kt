package space.kingfu.webpage.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
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
    placeHolderColor: Color = colorScheme.outline,
    contentAlignment: Alignment = Alignment.CenterStart,
    fontWeight: FontWeight = FontWeight.Normal,
    done: ((Boolean) -> Unit)? = null,
    isSingleLine: Boolean = false,
    maxLine: Int = 5,
    textAlign: TextAlign = TextAlign.Start,
    maxChar: Int = 200,
    fontStyle: FontStyle = FontStyle.Normal,
    editTextColor: Color = colorScheme.inverseSurface,
    borderColor: Color? = null,
    borderShape: Shape = CircleShape,
    weight: Float = 0.9f
) {
    val focusRequester =  FocusRequester()

    BasicTextField(
        modifier = modifier
            .clip(shape = if (borderColor != null) borderShape else Shape.medium)
            .border(
                width = if (borderColor != null) 1.dp else 0.dp,
                color = borderColor ?: Color.Transparent,
                shape = borderShape
            )
            .focusRequester(focusRequester = focusRequester)
            .fillMaxWidth()
            .background(color = colorScheme.surfaceContainer),
        value = value,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        onValueChange = {
            if (it.length <= maxChar) {
                onValueChange(it)
            }
        },
        maxLines = maxLine,
        singleLine = isSingleLine,
        textStyle = style.copy(
            color = editTextColor,
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
                        .weight(weight = weight)
                        .padding(start = Space().small_8),
                    contentAlignment = contentAlignment
                ) {

                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            color = placeHolderColor,
                            style = style,
                            fontStyle = fontStyle
                        )
                    }
                    innerTextField()

                }

                if (done != null) {
                    IconButton(
                        modifier = Modifier.weight(weight = 1 - weight),
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
