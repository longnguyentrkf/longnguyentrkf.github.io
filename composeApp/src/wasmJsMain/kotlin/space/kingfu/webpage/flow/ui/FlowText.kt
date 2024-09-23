package space.kingfu.webpage.flow.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import space.kingfu.webpage.ui.components.MyTextField
import space.kingfu.webpage.ui.theme.Shape
import space.kingfu.webpage.ui.theme.Typography

@Composable
fun FlowText(
    modifier: Modifier = Modifier.padding(vertical = 2.dp),
    text: String,
    isEdit: Boolean,
    onValueChange: (String) -> Unit,
    placeholder: String,
    done: () -> Unit = {},
    clickable: () -> Unit = {},
    backgroundColor: Color = if (text.isBlank()) colorScheme.surfaceContainer else Transparent,
    shape: Shape = Shape.extraSmall,
    style: TextStyle = Typography.bodySmall,
    textAlign: TextAlign = TextAlign.Start,
    contentAlignment: Alignment = Alignment.TopStart,
    maxChar: Int = 100,
    fontWeight: FontWeight = FontWeight.Normal,
    isSingleLine: Boolean = false,
    textColor: Color = colorScheme.inverseSurface,
    fontStyle: FontStyle = FontStyle.Normal
) {
    Column(modifier = modifier) {
        if (isEdit) {
            MyTextField(
                value = text,
                placeholder = placeholder,
                onValueChange = { onValueChange(it) },
                contentAlignment = contentAlignment,
                style = style,
                done = done,
                textAlign = textAlign,
                maxChar = maxChar,
                fontWeight = fontWeight,
                isSingleLine = isSingleLine,
                editTextColor = textColor
            )
        } else {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { clickable() }
                    .background(color = backgroundColor, shape = shape),
                text = text,
                style = style,
                textAlign = textAlign,
                fontWeight = fontWeight,
                maxLines = if(isSingleLine) 1 else Int.MAX_VALUE,
                color = textColor,
                fontStyle = fontStyle
            )
        }
    }
}