package com.sopt.shinmungo.presentation.map.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.shinmungo.presentation.map.AddressInputScreen

fun NavHostController.navigateToAddressInput(navOptions: NavOptions? = null) =
    navigate(route = AddressInput, navOptions = navOptions)

fun NavGraphBuilder.addressInputScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    composable<AddressInput> {
        AddressInputScreen(
            modifier = modifier,
            onBackClick = {
                navController.popBackStack()
            },
            onConfirmClick = { selectedAddress ->
                navController.previousBackStackEntry?.savedStateHandle?.set(
                    "selected_address",
                    selectedAddress
                )
                navController.popBackStack()
            }
        )
    }
}