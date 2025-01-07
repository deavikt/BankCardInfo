package ru.salfa.bankcardinfo.ui.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import ru.salfa.bankcardinfo.R

enum class BottomBarItems(
    @DrawableRes val iconId: Int,
    @StringRes val descriptionId: Int
) {
    Search(
        iconId = R.drawable.search_icon,
        descriptionId = R.string.bin_info_search_title
    ),
    QueryHistory(
        iconId = R.drawable.history_icon,
        descriptionId = R.string.query_history_title
    )
}