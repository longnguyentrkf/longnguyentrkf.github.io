package space.kingfu.webpage.flow.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material.icons.rounded.Remove
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import space.kingfu.webpage.flow.viewModel.ButtonData
import space.kingfu.webpage.ui.components.MyTextField
import space.kingfu.webpage.ui.theme.Shape
import space.kingfu.webpage.ui.theme.Typography

@Composable
fun FlowButton(
    modifier: Modifier = Modifier.padding(vertical = 2.dp),
    remove: () -> Unit,
    onValueChangeButton: (String) -> Unit,
    onValueChangeUrl: (String) -> Unit,
    done: () -> Unit,
    onClick: () -> Unit,
    buttonData: ButtonData,
    style: TextStyle = Typography.bodySmall,
    textAlign: TextAlign = TextAlign.Center,
) {
    Row(modifier = modifier) {
        if (buttonData.isEdit) {
            Column(
                verticalArrangement = Arrangement.spacedBy(space = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MyTextField(
                    modifier = Modifier
                        .width(width = 120.dp)
                        .clip(shape = CircleShape)
                        .background(color = colorScheme.surfaceContainer)
                        .border(
                            width = 1.dp,
                            color = colorScheme.inverseSurface,
                            shape = CircleShape
                        )
                        .padding(start = 8.dp, end = 16.dp)
                        .height(height = 48.dp),
                    value = buttonData.text,
                    placeholder = "button",
                    onValueChange = { onValueChangeButton(it) },
                    contentAlignment = Alignment.Center,
                    style = style,
                    textAlign = textAlign,
                    maxChar = 30,
                    isSingleLine = true
                )

                MyTextField(
                    modifier = Modifier
                        .width(width = 120.dp)
                        .height(height = 48.dp)
                        .padding(start = 8.dp, end = 16.dp)
                        .clip(shape = Shape.small),
                    value = buttonData.url,
                    placeholder = "url",
                    onValueChange = { onValueChangeUrl(it) },
                    style = style,
                    isSingleLine = true,
                    contentAlignment = Alignment.Center,
                    textAlign = textAlign,
                    maxChar = 500
                )

                Row {
                    IconButton(onClick = remove) {
                        Icon(
                            imageVector = Icons.Rounded.Remove,
                            contentDescription = null,
                            tint = colorScheme.error
                        )
                    }

                    IconButton(onClick =  done){
                        Icon(
                            imageVector = Icons.Rounded.Done,
                            contentDescription = null
                        )
                    }
                }
            }
        } else {
            OutlinedButton(
                modifier = Modifier
                    .widthIn(min = 120.dp)
                    .height(height = 48.dp),
                onClick =  onClick,
            ) {
                Text(
                    text = buttonData.text,
                    textAlign = textAlign,
                    style = style
                )
            }
        }
    }
}