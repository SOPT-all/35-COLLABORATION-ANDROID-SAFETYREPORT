package com.sopt.shinmungo.presentation.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.sopt.shinmungo.core.navigation.Route
import com.sopt.shinmungo.presentation.allcategory.navigation.navigateToAllCategory
import com.sopt.shinmungo.presentation.home.navigation.Home
import com.sopt.shinmungo.presentation.home.navigation.navigateToHome

class MainNavigator(
    val navController: NavHostController,
) {
    val startDestination: Route = Home

    private val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination


    val currentTab: MainTab?
        @Composable get() = MainTab.find { tab ->
                currentDestination?.hasRoute(tab::class) == true
    }

    @Composable
    fun showBottomBar() = MainTab.contains { tab ->
            currentDestination?.hasRoute(tab::class) == true
    }

    fun navigate(tab: MainTab) {
        val mainNavOption = navOptions {
            navController.currentDestination?.route?.let {
                popUpTo(it) {
                    saveState = true
                    inclusive = true
                }
            }
            launchSingleTop = true
            restoreState = true
        }

        when (tab) {
            MainTab.HOME -> navController.navigateToHome(navOptions = mainNavOption)

            MainTab.REPORT -> navController.navigateToAllCategory(navOptions = mainNavOption)

            // 구현 예정 없는 화면
            MainTab.PREVENTION -> {}
            MainTab.NEWS -> {}
            MainTab.MYPAGE -> {}
        }
    }
}

@Composable
fun rememberMainNavigator(
    navController: NavHostController = rememberNavController()
):MainNavigator = remember(navController) {
    MainNavigator(navController)
}
