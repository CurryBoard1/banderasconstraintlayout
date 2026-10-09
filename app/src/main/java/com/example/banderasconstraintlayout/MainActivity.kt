package com.example.banderasconstraintlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
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
                    BanderaAlemaniaCL(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}

@Composable
fun BanderaAlemaniaCL(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (negro, rojo, amarillo) = createRefs()

        // ahora las guias son horizontales (desde arriba)
        val guia1 = createGuidelineFromTop(1f / 3f)
        val guia2 = createGuidelineFromTop(2f / 3f)

        Box(
            modifier = Modifier
                .constrainAs(negro) {
                    top.linkTo(parent.top)
                    bottom.linkTo(guia1)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
                .background(Color.Black)
        )

        Box(
            modifier = Modifier
                .constrainAs(rojo) {
                    top.linkTo(guia1)
                    bottom.linkTo(guia2)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
                .background(Color(0xFFDD0000))
        )

        Box(
            modifier = Modifier
                .constrainAs(amarillo) {
                    top.linkTo(guia2)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
                .background(Color(0xFFFFCE00))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaAlemaniaCLPreview() {
    BanderasconstraintlayoutTheme {
        BanderaAlemaniaCL(modifier = Modifier.fillMaxSize())
    }
}
