package space.kingfu.webpage.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
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
    contentAlignment: Alignment = Alignment.TopStart,
    fontWeight: FontWeight = FontWeight.Normal,
    done: (() -> Unit)? = null,
    isSingleLine: Boolean = false,
    textAlign: TextAlign = TextAlign.Start,
    maxChar: Int = 100,
    fontStyle: FontStyle = FontStyle.Normal,
    editTextColor: Color = colorScheme.inverseSurface,
) {
    val focusRequester =  FocusRequester()

    BasicTextField(
        modifier = modifier
            .focusRequester(focusRequester = focusRequester)
            .background(color = colorScheme.surfaceContainer),
        value = value,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        onValueChange = { text ->
            if (text.length <= maxChar) {
                onValueChange(text)
            }
        },
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
                        .weight(weight = 1f)
                        .padding(start = 8.dp),
                    contentAlignment = contentAlignment
                ) {

                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            color = placeHolderColor,
                            style = style,
                            fontStyle = fontStyle,
                            fontWeight = fontWeight
                        )
                    }

                    innerTextField()

                }

                if (done != null) {
                    IconButton(onClick = done ){
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
