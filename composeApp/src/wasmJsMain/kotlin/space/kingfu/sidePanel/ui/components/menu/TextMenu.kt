package space.kingfu.sidePanel.ui.components.menu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun TextMenu(
    modifier: Modifier = Modifier,
    onDelete: (() -> Unit)? = null,
    onEdit: () -> Unit,
    iconPadding: Dp = 8.dp
) {
    var expanded by remember { mutableStateOf(value = false) }

    Box(modifier = modifier) {
        Icon(
            modifier = Modifier
                .clip(shape = CircleShape)
                .padding(all = iconPadding)
                .clickable { expanded = true },
            imageVector = Icons.Default.MoreVert,
            contentDescription = null
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = {
                    Text(
                        text = "Edit name",
                        style = typography.labelLarge
                    )
                },
                onClick = {
                    onEdit()
                    expanded = false
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Edit,
                        contentDescription = null
                    )
                }
            )

            if (onDelete != null) {
                DropdownMenuItem(
                    text = {
                        Text(
                            text = "Delete",
                            style = typography.labelLarge,
                            color = colorScheme.error
                        )
                    },
                    onClick = {
                        onDelete()
                        expanded = false
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Rounded.Delete,
                            contentDescription = null,
                            tint = colorScheme.error
                        )
                    }
                )
            }
        }
    }
}