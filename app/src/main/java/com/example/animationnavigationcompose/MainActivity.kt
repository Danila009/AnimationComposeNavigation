package com.example.animationnavigationcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.navigation
import com.google.accompanist.navigation.animation.composable
import com.example.animationnavigationcompose.screen.HomeScreen
import com.example.animationnavigationcompose.screen.ProfileScreen
import com.example.animationnavigationcompose.ui.theme.AnimationNavigationComposeTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {

    lateinit var navHostController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            navHostController = rememberAnimatedNavController()

            AnimationNavigationComposeTheme {
                AnimatedNavHost(
                    navController = navHostController,
                    startDestination = "home",
                    route = "main_route",
                    builder = {
                        composable(
                            route = "home",
                            exitTransition = {_,_ ->
                                slideOutHorizontally(
                                    targetOffsetX = {300},
                                    animationSpec = tween(
                                        durationMillis = 300,
                                        easing = FastOutSlowInEasing
                                    )
                                ) + fadeOut(animationSpec = tween(300))
                            },
                            popEnterTransition = {_,_ ->
                                slideInHorizontally(
                                    initialOffsetX = {-300},
                                    animationSpec = tween(
                                        durationMillis = 300,
                                        easing = FastOutSlowInEasing
                                    )
                                ) + fadeIn(animationSpec = tween(300))
                            }
                        ){
                            HomeScreen(navController = navHostController)
                        }
                        composable(
                            route = "profile",
                            enterTransition = {_,_ ->
                                slideInHorizontally(
                                    initialOffsetX = {300},
                                    animationSpec = tween(
                                        durationMillis = 300,
                                        easing = FastOutSlowInEasing
                                    )
                                ) + fadeIn(animationSpec = tween(300))
                            },
                            popExitTransition = {_,_ ->
                                slideOutHorizontally(
                                    targetOffsetX = {-300},
                                    animationSpec = tween(
                                        durationMillis = 300,
                                        easing = FastOutSlowInEasing
                                    )
                                ) + fadeOut(animationSpec = tween(300))
                            }
                        ){
                            ProfileScreen(navController = navHostController)
                        }
                    }
                )
            }
        }
    }
}