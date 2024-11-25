package com.sopt.shinmungo.presentation.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.sopt.shinmungo.core.designsystem.theme.ShinMunGoTheme
import com.sopt.shinmungo.core.navigation.Route
import com.sopt.shinmungo.presentation.home.navigation.homeScreen
import com.sopt.shinmungo.presentation.main.component.MainBottomBars
import com.sopt.shinmungo.presentation.map.AddressInputScreen
import com.sopt.shinmungo.presentation.map.navigation.addressInputScreen

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
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        homeScreen(
            navController = navController,
            modifier = modifier
        )
        addressInputScreen(
            navController = navController,
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    ShinMunGoTheme {
        MainScreen()
    }
}