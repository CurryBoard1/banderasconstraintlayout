package com.example.banderasconstraintlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    BanderaMexicoCL(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}

@Composable
fun BanderaMexicoCL(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (verde, blanco, rojo, escudo) = createRefs()

        val guia1 = createGuidelineFromStart(1f / 3f)
        val guia2 = createGuidelineFromStart(2f / 3f)

        Box(
            modifier = Modifier
                .constrainAs(verde) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(guia1)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
                .background(Color(0xFF006341))
        )

        Box(
            modifier = Modifier
                .constrainAs(blanco) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(guia1)
                    end.linkTo(guia2)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
                .background(Color.White)
        )

        Box(
            modifier = Modifier
                .constrainAs(rojo) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(guia2)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
                .background(Color(0xFFCE1126))
        )

        Box(
            modifier = Modifier
                .constrainAs(escudo) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(guia1)
                    end.linkTo(guia2)
                }
                .size(60.dp)
                .clip(CircleShape)
                .background(Color(0xFFC9A227))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaMexicoCLPreview() {
    BanderasconstraintlayoutTheme {
        BanderaMexicoCL(modifier = Modifier.fillMaxSize())
    }
}
