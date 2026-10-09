package com.example.banderasconstraintlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
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
                    BanderaChileCL(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}

@Composable
fun BanderaChileCL(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (blanco, rojo, canton) = createRefs()

        val mitad = createGuidelineFromTop(0.5f)
        val tercio = createGuidelineFromStart(0.33f)

        Box(
            modifier = Modifier
                .constrainAs(blanco) {
                    top.linkTo(parent.top)
                    bottom.linkTo(mitad)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
                .background(Color.White)
        )

        Box(
            modifier = Modifier
                .constrainAs(rojo) {
                    top.linkTo(mitad)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
                .background(Color(0xFFD52B1E))
        )

        Box(
            modifier = Modifier
                .constrainAs(canton) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(tercio)
                    bottom.linkTo(mitad)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
                .background(Color(0xFF0039A6)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "★", color = Color.White, fontSize = 40.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaChileCLPreview() {
    BanderasconstraintlayoutTheme {
        BanderaChileCL(modifier = Modifier.fillMaxSize())
    }
}
