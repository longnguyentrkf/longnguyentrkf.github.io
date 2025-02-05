package com.kingfuspace.sidePanel.ui.components.menu

import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Crop32
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.OpenWith
import androidx.compose.material.icons.rounded.Tune
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
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
    onModify: (() -> Unit)? = null,
    onDelete: (() -> Unit)? = null,
    onEditName: (() -> Unit)? = null,
    onBanner: (() -> Unit)? = null,
    onClick: (() -> Unit)? = null,
    onMove: (() -> Unit)? = null,
    onAdd: (() -> Unit)? = null
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

            if (onModify != null) {
                DropdownMenuItem(
                    text = {
                        Text(
                            text = "Modify",
                            style = typography.bodyLarge,
                        )
                    },
                    onClick = {
                        onModify()
                        expanded = false
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Rounded.Tune,
                            contentDescription = null
                        )
                    }
                )
            }

            if (onEditName != null) {
                DropdownMenuItem(
                    text = {
                        Text(
                            text = "Edit name",
                            style = typography.bodyLarge,
                        )
                    },
                    onClick = {
                        onEditName()
                        expanded = false
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Rounded.Edit,
                            contentDescription = null
                        )
                    }
                )
            }

            if (onAdd != null) {
                DropdownMenuItem(
                    text = {
                        Text(
                            text = "Add",
                            style = typography.bodyLarge,
                        )
                    },
                    onClick = {
                        onAdd()
                        expanded = false
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Rounded.Add,
                            contentDescription = null
                        )
                    }
                )
            }

            if (onMove != null) {
                DropdownMenuItem(
                    text = {
                        Text(
                            text = "Move",
                            style = typography.bodyLarge,
                        )
                    },
                    onClick = {
                        onMove()
                        expanded = false
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Rounded.OpenWith,
                            contentDescription = null
                        )
                    }
                )
            }

            if (onBanner != null) {
                DropdownMenuItem(
                    text = {
                        Text(
                            text = "Change banner layout",
                            style = typography.bodyLarge
                        )
                    },
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

            if (onDelete != null) {
                DropdownMenuItem(
                    text = {
                        Text(
                            text = "Delete",
                            style = typography.bodyLarge,
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