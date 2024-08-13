package com.example.movieappupdate

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.movieappupdate.navigation.MovieNavigation
import com.example.movieappupdate.ui.theme.MovieAppUpdateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieAppUpdateTheme {
                MyApp {
                    MovieNavigation()
                }

            }
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun MyApp(content: @Composable () -> Unit) {
        MovieAppUpdateTheme {
            content()


        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        MyApp {
            MovieNavigation()
        }

    }
}