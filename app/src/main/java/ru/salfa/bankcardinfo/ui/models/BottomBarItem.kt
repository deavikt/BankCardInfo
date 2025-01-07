package ru.salfa.bankcardinfo.ui.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class BottomBarItem <T : Any> (
    @DrawableRes val iconId: Int,
    @StringRes val descriptionId: Int,
    val destination: T
)