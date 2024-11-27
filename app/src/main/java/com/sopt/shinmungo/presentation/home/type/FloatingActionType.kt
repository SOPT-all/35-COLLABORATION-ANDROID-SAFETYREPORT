package com.sopt.shinmungo.presentation.home.type

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.sopt.shinmungo.R

enum class FloatingActionType(
    @StringRes val title: Int,
    @DrawableRes val icon: Int
) {
    SAFETY(
        title = R.string.main_fab_type_safety,
        icon = R.drawable.ic_safety_24
    ),
    PARKING(
        title = R.string.main_fab_type_parking,
        icon = R.drawable.ic_carwheel_24
    ),
    TRAFFIC(
        title = R.string.main_fab_type_traffic,
        icon = R.drawable.ic_car_24
    ),
    LIFE(
        title = R.string.main_fab_type_life,
        icon = R.drawable.ic_danger_24
    ),
    MENU(
        title = R.string.main_fab_type_menu,
        icon = R.drawable.ic_menu_24
    ),
    CAMERA(
        title = R.string.main_fab_type_camera,
        icon = R.drawable.ic_report_camera_24px
    );
}