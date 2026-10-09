package com.example.banderasconstraintlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.banderasconstraintlayout.ui.theme.BanderasconstraintlayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BanderasconstraintlayoutTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BanderaEEUUCL(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}

@Composable
fun BanderaEEUUCL(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val franjas = List(13) { createRef() }
        val canton = createRef()

        val finCanton = createGuidelineFromStart(0.4f)
        val bajoCanton = createGuidelineFromTop(0.54f)

        createVerticalChain(*franjas.toTypedArray(), chainStyle = ChainStyle.Spread)

        franjas.forEachIndexed { index, franja ->
            Box(
                modifier = Modifier
                    .constrainAs(franja) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        if (index == 0) top.linkTo(parent.top)
                        if (index == 12) bottom.linkTo(parent.bottom)
                        width = Dimension.fillToConstraints
                        height = Dimension.fillToConstraints
                    }
                    .background(if (index % 2 == 0) Color(0xFFB22234) else Color.White)
            )
        }

        Box(
            modifier = Modifier
                .constrainAs(canton) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(finCanton)
                    bottom.linkTo(bajoCanton)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
                .background(Color(0xFF3C3B6E))
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                repeat(5) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        repeat(6) {
                            Text(text = "★", color = Color.White, fontSize = 12.sp)
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaEEUUCLPreview() {
    BanderasconstraintlayoutTheme {
        BanderaEEUUCL(modifier = Modifier.fillMaxSize())
    }
}
