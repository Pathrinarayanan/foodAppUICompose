package com.example.foodapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.curvedbottombar.CurvedBottomBar
import com.example.foodapp.ui.theme.FoodAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodAppTheme {
                MainScreen()
            }
        }
    }
}


@Composable
fun SplashScreen(){
    val gradient = Brush.linearGradient(
        listOf(Color(0xffFF939B), Color(0xffEF2A39))
    )
    Box(modifier =Modifier.fillMaxSize().background(gradient),
        contentAlignment = Alignment.BottomCenter
        ){

        Text(
            "Foodgo",
            Modifier.fillMaxSize().padding(top =200.dp),
            fontSize = 60.sp,
            color = Color.White,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center
        )
        Row(
            modifier =Modifier,
            verticalAlignment = Alignment.Bottom
        ) {
            Image(
                painter = painterResource(R.drawable.burger2),
                contentDescription = "burger"
            )
            Image(
                painter = painterResource(R.drawable.burger),
                contentDescription = "burger",
                modifier = Modifier.offset(x = -50.dp)
            )
        }
    }
}

@Preview
@Composable
fun MainScreen(){
    Scaffold(
        modifier = Modifier,
        bottomBar = {
            CurvedBottomBar {
                Row (
                    Modifier
                ){
                    Image(
                        painter = painterResource(R.drawable.home),
                        contentDescription = null
                    )
                    Spacer(modifier =Modifier.width(50.dp))
                    Image(
                            painter = painterResource(R.drawable.user),
                    contentDescription = null
                    )
                    Spacer(modifier =Modifier.width(140.dp))

                    Image(
                        painter = painterResource(R.drawable.comment),
                        contentDescription = null
                    )
                    Spacer(modifier =Modifier.width(50.dp))

                    Image(
                        painter = painterResource(R.drawable.filled_heart),
                        contentDescription = null
                    )

                }
            }
        },
        floatingActionButton = {
            Box (
                modifier = Modifier.fillMaxWidth().background(Color.Transparent),
                contentAlignment = Alignment.Center
            ){
            Box(
                modifier = Modifier
                    .offset(y =  30.dp)
                    .padding(start = 30.dp)
                    .size(72.dp)
                    .shadow(elevation = 16.dp, shape = CircleShape, clip = false)
                    .clip(CircleShape)
                    .background(Color(0xffEF2A39)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    Icons.Filled.Add,
                    contentDescription = null,
                    Modifier.size(40.dp),
                    tint = Color.White
                )
            }
        }
        },

    ) {
        Box(modifier = Modifier){
            HomeScreen()
        }
    }

}

@Composable
fun FoodItem(){
    Card(
        modifier = Modifier.width(185.dp).height(225.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(5.dp)
    ){
        Image(
            painter = painterResource(R.drawable.burger),
            contentDescription = "burger",
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .size(120.dp)
        )
        Column(
            modifier = Modifier.padding(top = 20.dp, start = 11.dp)
        ){
            Text("Cheeseburger", Modifier, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            Text("Wendy's Burger", Modifier, fontSize = 16.sp)
        }
        Row(
            modifier = Modifier.padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ){
            RatingData()
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(R.drawable.empty_heart),
                contentDescription = null,
                modifier = Modifier.padding(top = 5.dp,end = 5.dp)
            )
        }

    }
}

@Composable
fun RatingData(){
    Row(
        modifier =Modifier.padding(top = 15.dp, start = 11.dp)
    ){
        Image(
            painter = painterResource(R.drawable.filled_star),
            contentDescription = null,
            modifier = Modifier
        )
        Text("4.9", Modifier, fontSize = 16.sp, fontWeight = FontWeight.Medium)
    }
}


@Composable
fun HomeScreen(){
    Column(
        modifier= Modifier.fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 28.dp)
    ){
        Text("Foodgo", Modifier, fontSize = 45.sp, fontWeight = FontWeight.SemiBold, )
        Text("Order your favourite food!", Modifier, fontSize = 15.sp,
            color = Color(0xff6A6A6A),
            fontWeight = FontWeight.Medium)
        SearchBox()
        HorizontalSliderItems()
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize().padding(vertical = 12.dp),

        ) {
            items(10) {
                FoodItem()
            }
        }

    }
}

@Composable
fun HorizontalSliderItems(){
    val texts = listOf<SlidingContent>(
        SlidingContent("All", true),
        SlidingContent( "Combos",false),
        SlidingContent("Sliders", false),
        SlidingContent("Classics",false)
    )
    Row(
        modifier =Modifier
            .padding(horizontal = 11.dp, vertical = 20.dp )
            .fillMaxWidth().
        wrapContentHeight(),
        horizontalArrangement = Arrangement.spacedBy(20.dp)

    ) {
        texts.forEach {
            Box(
                modifier = Modifier.height(40.dp).wrapContentWidth()
                    .background( if(it.selected)Color(0xffEF2A39) else Color(0xffF3F4F6), RoundedCornerShape(20.dp))
                    .padding(horizontal = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(it.text, Modifier, color = if(it.selected) Color.White else Color(0xff6a6a6a), fontWeight = FontWeight.SemiBold)
            }
        }
    }
}
@Composable
fun SearchBox(){

    Row(
        modifier= Modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            modifier = Modifier
                .padding(top = 20.dp)
                .height(60.dp)
                .width(280.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0xfff3f4f6))
                .padding(18.dp),
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Icon(Icons.Filled.Search, contentDescription = null)
            Text("Search", Modifier, fontSize = 18.sp, fontWeight = FontWeight.SemiBold,)

        }
        Box(
            modifier = Modifier
                .padding(top =15.dp)
                .size(60.dp)
                .background(Color(0xffEF2A39), RoundedCornerShape(20.dp)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.settings_sliders),
                contentDescription = null,
            )
        }
    }
}
data class SlidingContent(
    val text : String,
    val selected : Boolean = false,
)