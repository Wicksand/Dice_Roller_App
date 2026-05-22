package com.example.dice_roller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Button
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.draw.blur
import kotlin.random.Random
import com.example.dice_roller.ui.theme.Dice_RollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Dice_RollerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var result by remember { mutableIntStateOf(20) }

                    val roller = remember {Roller()}
                    val history = remember{ mutableListOf<Int>()}
                    Column (
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(24.dp)
                    ) {


                        Box(

                            modifier = Modifier,
                            Alignment.Center
                        ){

                            Image(
                                painter = painterResource(id = R.drawable.d20),
                                contentDescription = "D20 Dice",
                                modifier = Modifier.size(200.dp)
                            )
                            Text(
                                modifier = Modifier.padding(
                                    top = 12.dp,
                                    end = 10.dp
                                ),
                                text = "${result}",
                                fontSize = 30.sp
                            )

                        }
                        Button(onClick = {
                            result = roller.roll("d20")
                            history.add(result)
                        }) {
                            Text("Roll")
                        }
                        Text(
                            text = "${history}"
                        )

                    }
                }
            }
        }
    }
}
