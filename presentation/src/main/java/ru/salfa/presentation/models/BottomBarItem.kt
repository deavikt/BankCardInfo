package ru.salfa.presentation.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

internal data class BottomBarItem <T : Any> (
    @DrawableRes val iconId: Int,
    @StringRes val topBarTitleId: Int,
    val destination: T
)