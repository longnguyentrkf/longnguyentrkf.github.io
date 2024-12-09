package space.kingfu.sidePanel.ui.components.menu

import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.rounded.Crop32
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun BannerMenu(
    modifier: Modifier = Modifier,
    onDelete: () -> Unit,
    onEdit: () -> Unit,
    onBanner: (() -> Unit)? = null,
    onClick: (() -> Unit)? = null
) {
    var expanded by remember { mutableStateOf(value = false) }

    Box(modifier = modifier) {
        IconButton(
            onClick = {
                expanded = true
                if (onClick != null) {
                    onClick()
                }
            }
        ) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = null
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {

            DropdownMenuItem(
                text = { Text(text = "Edit name") },
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

            if (onBanner != null) {
                DropdownMenuItem(
                    text = { Text(text = "Change Banner Type") },
                    onClick = {
                        onBanner()
                        expanded = false
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Rounded.Crop32,
                            contentDescription = null
                        )
                    }
                )
            }

            DropdownMenuItem(
                text = {
                    Text(
                        text = "Delete",
                        color = MaterialTheme.colorScheme.error
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
                        tint = MaterialTheme.colorScheme.error
                    )
                }
            )
        }
    }
}