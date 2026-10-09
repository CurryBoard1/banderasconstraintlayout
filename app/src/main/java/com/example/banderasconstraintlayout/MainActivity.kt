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
                    BanderaArgentinaCL(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}

@Composable
fun BanderaArgentinaCL(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (celesteArriba, blanco, celesteAbajo, sol) = createRefs()

        val guia1 = createGuidelineFromTop(1f / 3f)
        val guia2 = createGuidelineFromTop(2f / 3f)

        Box(
            modifier = Modifier
                .constrainAs(celesteArriba) {
                    top.linkTo(parent.top)
                    bottom.linkTo(guia1)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
                .background(Color(0xFF74ACDF))
        )

        Box(
            modifier = Modifier
                .constrainAs(blanco) {
                    top.linkTo(guia1)
                    bottom.linkTo(guia2)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
                .background(Color.White)
        )

        Box(
            modifier = Modifier
                .constrainAs(celesteAbajo) {
                    top.linkTo(guia2)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
                .background(Color(0xFF74ACDF))
        )

        Box(
            modifier = Modifier
                .constrainAs(sol) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .size(50.dp)
                .clip(CircleShape)
                .background(Color(0xFFF6B40E))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaArgentinaCLPreview() {
    BanderasconstraintlayoutTheme {
        BanderaArgentinaCL(modifier = Modifier.fillMaxSize())
    }
}
