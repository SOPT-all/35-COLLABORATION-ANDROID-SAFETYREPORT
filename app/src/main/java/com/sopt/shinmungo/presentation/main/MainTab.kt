package com.sopt.shinmungo.presentation.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import com.sopt.shinmungo.R
import com.sopt.shinmungo.core.navigation.MainTabRoute
import com.sopt.shinmungo.presentation.home.navigation.Home

enum class MainTab(
    @StringRes val title: Int,
    @DrawableRes val selectedIconRes: Int,
    @DrawableRes val unselectedIconRes: Int,
    val route: MainTabRoute,
) {
    HOME(
        title = R.string.main_bottom_bar_home,
        selectedIconRes = R.drawable.ic_home_filled_24,
        unselectedIconRes = R.drawable.ic_home_24,
        route = Home
    ),
    REPORT(
        title = R.string.main_bottom_bar_report,
        selectedIconRes = R.drawable.ic_safety_filled_24,
        unselectedIconRes = R.drawable.ic_safety_24,
        route = Report
    ),
    PREVENTION(
        title = R.string.main_bottom_bar_prevent,
        selectedIconRes = R.drawable.ic_danger_filled_24,
        unselectedIconRes = R.drawable.ic_danger_24,
        route = Prevent
    ),
    NEWS(
        title = R.string.main_bottom_bar_news,
        selectedIconRes = R.drawable.ic_news_filled_24,
        unselectedIconRes = R.drawable.ic_news_24,
        route = News
    ),
    MYPAGE(
        title = R.string.main_bottom_bar_my_page,
        selectedIconRes = R.drawable.ic_person_filled_24,
        unselectedIconRes = R.drawable.ic_person_24,
        route = MyPage
    );

    companion object {
        @Composable
        fun find(predicate: @Composable (MainTabRoute) -> Boolean): MainTab? =
             entries.find { predicate(it.route) }

        @Composable
        fun contains(predicate: @Composable (MainTabRoute) -> Boolean): Boolean =
            entries.map{it.route}.any { predicate(it) }


        // TODO: 임시 바텀바 메뉴 루트 추가 (삭제 예정)
        data object Report: MainTabRoute
        data object Prevent: MainTabRoute
        data object News: MainTabRoute
        data object MyPage: MainTabRoute
    }
}