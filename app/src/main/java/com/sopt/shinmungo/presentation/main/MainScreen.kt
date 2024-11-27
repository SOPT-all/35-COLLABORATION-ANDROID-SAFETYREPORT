package com.sopt.shinmungo.presentation.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import com.sopt.shinmungo.core.navigation.Route
import com.sopt.shinmungo.presentation.allcategory.navigation.allCategoryScreen
import com.sopt.shinmungo.presentation.gallery.navigation.galleryScreen
import com.sopt.shinmungo.presentation.home.navigation.homeScreen
import com.sopt.shinmungo.presentation.main.component.MainBottomBars
import com.sopt.shinmungo.presentation.map.AddressInputScreen
import com.sopt.shinmungo.presentation.map.navigation.addressInputScreen
import com.sopt.shinmungo.presentation.report.navigation.reportScreen

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    mainNavigator: MainNavigator = rememberMainNavigator()
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            MainBottomBars(
                tabs = MainTab.entries,
                visibility = mainNavigator.showBottomBar(),
                onTabSelect = mainNavigator::navigate,
                selectedTab = mainNavigator.currentTab
            )
        }
    ) { innerPadding ->
        MainNavHost(
            modifier = Modifier.padding(innerPadding),
            navController = mainNavigator.navController,
            startDestination = mainNavigator.startDestination
        )
    }
}

@Composable
private fun MainNavHost(
    navController: NavHostController,
    startDestination: Route,
    modifier: Modifier = Modifier
) {
    val noScaffoldModifier = Modifier.systemBarsPadding()

    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        homeScreen(
            navController = navController,
            modifier = modifier
        )
        allCategoryScreen(
            navController = navController,
            modifier = modifier
        )
        reportScreen(
            navController = navController,
            modifier = noScaffoldModifier
        )
        addressInputScreen(
            navController = navController,
            modifier = modifier
        )
        galleryScreen(
            navController = navController,
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    ShinMunGoTheme {
        Column {
            MainScreen()
            MainBottomBars(
                onTabSelect = {},
                selectedTab = MainTab.HOME,
                tabs = MainTab.entries,
                visibility = true
            )
        }
    }
}