package com.example.movieappupdate.screens.home


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieappupdate.model.Movie
import com.example.movieappupdate.model.getMovies
import com.example.movieappupdate.navigation.MovieScreens
import com.example.movieappupdate.widgets.MovieRow


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController){
    Scaffold (topBar = {
        TopAppBar(modifier = Modifier.fillMaxWidth(),
            colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent ),

            // Modifier.shadow(elevation = 5.dp),
            title = {
                Text(text = "Movies") }
        )

    },  content = { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            MainContent(navController=navController)
        }
    })
}

@Composable
fun MainContent(navController: NavController,
    movieList:List <Movie>  = getMovies()
){
    Column (modifier = Modifier.padding(12.dp)) {
        LazyColumn{
            items(items = movieList){
                MovieRow(movie =it ){movie->
                    navController.navigate(route = MovieScreens.DetailsScreen.name+"/$movie")
                    //Log.d("2525","Main $movie")


                }

            }
        }


    }



}


