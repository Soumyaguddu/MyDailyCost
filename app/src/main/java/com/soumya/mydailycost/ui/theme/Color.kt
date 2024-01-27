package com.soumya.mydailycost.ui.theme

import androidx.compose.material.Colors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

private val primary = Color(0xFF499BDD)
private val primaryVariant = Color(0xFF1984DA)
private val secondary = Color(0xFF5FD864)
private val secondaryVariant = Color(0xFF30D137)
private val backgroundColor = Color(0xFFE6F0F7)

private val successColor = Color(0xFF14C310)
private val warningColor = Color(0xFFEBC500)
private val errorColor = Color(0xFFE62112)

val appColors: Colors = lightColors(
    primary = primary,
    primaryVariant = primaryVariant,
    onPrimary = Color.White,
    secondary = secondary,
    secondaryVariant = secondaryVariant,
    onSecondary = Color.White,
    surface = Color.White,
    onSurface = Color.Black,
    background = backgroundColor,
    onBackground = Color.Black,
)
@Suppress("UnusedReceiverParameter")
val Colors.success: Color get() = successColor

@Suppress("UnusedReceiverParameter")
val Colors.warning: Color get() = warningColor
@Suppress("UnusedReceiverParameter")
val Colors.error: Color get() = errorColor
@Suppress("UnusedReceiverParameter")
val Colors.colorBackground: Color get() = backgroundColor