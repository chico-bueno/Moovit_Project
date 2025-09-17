package com.example.moovit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


class TelaInicial : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        }
    }
}


@Composable
fun TelaPrincipal(navController: NavHostController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)
        .padding(16.dp)) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 90.dp)
        ) {
            Pesquisa()
            Frequentes(navController = navController)
            FavoritosCasa()
            FavoritoTrabalho()
            FavoritoDestino()
        }

        Rodape(
            modifier = Modifier
                .align(Alignment.BottomCenter),
            navController = navController,
        )
    }
}

@Composable
fun Pesquisa() {

    Card(
        colors = CardDefaults.cardColors(Color.DarkGray),
        modifier = Modifier
            .height(56.dp)
            .padding(top = 16.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "        Para onde você quer ir?",
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 17.sp,
                color = Color.White
            )

            Surface(
                modifier = Modifier.size(56.dp),
                color = Color(0xFFFF9500)
            ) {
                Image(
                    imageVector = Icons.Default.Search,
                    contentDescription = "",
                    modifier = Modifier.size(40.dp)
                )
            }
        }
    }
}


@Composable
fun Frequentes(navController: NavHostController){
    Spacer(modifier = Modifier.width(20.dp))
    Card(
        colors = CardDefaults.cardColors(Color.DarkGray),
        modifier = Modifier
            .height(200.dp)
            .padding(10.dp)
            .clickable {
                    navController.navigate("Horarios")
    }
    ) {

        Row(
            modifier = Modifier.width(350.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {

            Spacer(modifier = Modifier.width(20.dp))

            Column {
                Text("Destinos frequentes",
                    style = MaterialTheme
                        .typography
                        .labelMedium
                    , color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,)
                Text("Para ABO - Associação Brasileira de Odontologia - Secção Paraná",
                    style = MaterialTheme
                        .typography.headlineSmall,
                    fontSize = 24.sp,
                    color = Color.White)
                Surface(
                    modifier = Modifier
                        .width(200.dp)
                        .height(35.dp),
                    color = Color.LightGray,
                ) {

                        Text(
                            text = "➡ 380 Detran ➡ 👤",
                            style = MaterialTheme
                                .typography
                                .titleLarge,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .width(100.dp)
                        )


                }
            }
        }
    }
}

@Composable
fun FavoritosCasa() {
    Spacer(modifier = Modifier.width(20.dp))
    Card(
        colors = CardDefaults.cardColors(Color.DarkGray),
        modifier = Modifier
            .height(89.dp)
            .padding(10.dp)

    ) {

        Row(
            modifier = Modifier.width(350.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {
            Text(
                text = "🏠 Casa ",
                style = MaterialTheme
                    .typography
                    .titleLarge,
                color = Color.White,
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold,

                modifier = Modifier.padding(16.dp),

                )

            Text(
                text = "Voce esta perto",
                style = MaterialTheme.typography.titleMedium,
                color = Color(0xFFFF9500),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp),
            )

            Spacer(modifier = Modifier.width(20.dp))
        }
    }
}

@Composable
fun FavoritoTrabalho(){
    Spacer(modifier = Modifier.width(20.dp))
    Card(
        colors = CardDefaults.cardColors(Color.DarkGray),
        modifier = Modifier
            .height(89.dp)
            .padding(10.dp)

    ) {

        Row(
            modifier = Modifier.width(350.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {
            Text(
                text = "🌇 Trabalho ",
                style = MaterialTheme
                    .typography
                    .titleLarge,
                color = Color.White,
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp),

                )

            Text(
                text = "Toque para Editar",
                style = MaterialTheme.typography.titleMedium,
                color = Color(0xFFFF9500),
                modifier = Modifier.padding(16.dp),
            )

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable

fun FavoritoDestino(){
    Card(
        colors = CardDefaults.cardColors(Color.DarkGray),
        modifier = Modifier
            .height(200.dp)
            .padding(10.dp)

    ) {
        Column(
            modifier = Modifier.width(350.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "☸ ABO-Associoação Brasileira de Odontologia - Secção Paraná",
                style = MaterialTheme
                    .typography
                    .titleLarge,
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 4.dp),
            )

            Text(
                text = "Rua Dias da Rocha Filho - Alto da XV, Curitiba - PR, Brasil",
                style = MaterialTheme
                    .typography
                    .titleLarge,
                color = Color.White,
                fontSize = 20.sp,

                )

        }
    }
}

@Composable
fun Rodape(modifier: Modifier, navController: NavHostController) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(vertical = 16.dp)
    ) {
        Button(
            onClick = {navController.navigate("Estaçoes") },
            modifier = modifier
                .fillMaxSize(),
            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
        ) {
            Text(
                text = "Estações",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White,
                fontSize = 18.sp
            )
        }
    }
}
