package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class Horarios : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TelaHorarios(navController = rememberNavController())
        }
    }
}

data class RotaHorario(
    val tempo: String,
    val horaChegada: String,
    val preco: String,
    val linha: String,
    val saida: String,
    val chegada: String,
    val iconeCor: Color = Color(0xFFFF5722)
)


@Composable
fun TelaHorarios(navController: NavHostController) {
    val rotas = listOf(
        RotaHorario("21 min", "10:42", "Uber", "Táxi/Uber", "Saída em 2 min", "Chegada às 10:42", Color.Black),
        RotaHorario("28 min", "10:50", "R$ 6,00", "303 Centenário", "Praça Rui Barbosa", "Terminal Centenário"),
        RotaHorario("20 min", "10:50", "R$ 6,00", "366 Itupã", "Praça General Osório", "Chegada 10:50"),
        RotaHorario("24 min", "10:45", "R$ 6,00", "311 Interbairros", "Praça Rui Barbosa", "Chegada 10:45")
    )

    var pesquisa by remember { mutableStateOf("") }
    val rotasFiltradas = rotas.filter {
        it.linha.contains(pesquisa, ignoreCase = true) || it.chegada.contains(pesquisa, ignoreCase = true)
    }

    Column(Modifier.fillMaxSize().background(Color.Black)) {
        HeaderHorarios(pesquisa) { pesquisa = it }
        LazyColumn(
            Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(rotasFiltradas) { CardHorario(it) }
        }
    }
}

@Composable
fun HeaderHorarios(textoPesquisa: String, onTextoMudou: (String) -> Unit) {
    Surface(color = Color(0xFF2D2D2D), modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {

                }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Voltar",
                    tint = Color.White
                )

            }

            Spacer(Modifier.width(16.dp))

            Card(
                colors = CardDefaults.cardColors(Color(0xFF424242)),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.weight(1f)
            ) {
                Box(modifier = Modifier.padding(12.dp)) {
                    BasicTextField(
                        value = textoPesquisa,
                        onValueChange = onTextoMudou,
                        singleLine = true,
                        textStyle = LocalTextStyle.current.copy(color = Color.White, fontSize = 16.sp),
                        modifier = Modifier.fillMaxWidth(),
                        decorationBox = { innerTextField ->
                            if (textoPesquisa.isEmpty()) {
                                Text("Digite a linha ou destino", color = Color.Gray, fontSize = 16.sp)
                            }
                            innerTextField()
                        }
                    )
                }
            }

            Spacer(Modifier.width(16.dp))
            Icon(Icons.Default.Search, contentDescription = "Pesquisar", tint = Color.White)
        }
    }
}

@Composable
fun CardHorario(rota: RotaHorario) {
    Card(
        colors = CardDefaults.cardColors(Color(0xFF1C1C1C)),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(Modifier.padding(16.dp)) {
            // Linha de tempo e chegada
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(rota.tempo, color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text("Hora de chegada: ${rota.horaChegada}", color = Color.Gray, fontSize = 14.sp)
            }

            Spacer(Modifier.height(8.dp))

            // Linha/ônibus
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    Modifier.size(36.dp).background(rota.iconeCor, RoundedCornerShape(6.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("🚌", fontSize = 18.sp)
                }
                Spacer(Modifier.width(12.dp))
                Column {
                    Text(rota.linha, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text("${rota.saida} → ${rota.chegada}", color = Color.Gray, fontSize = 12.sp)
                }
            }

            Spacer(Modifier.height(8.dp))

            // Preço
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(rota.preco, color = Color(0xFFFF9500), fontWeight = FontWeight.Bold, fontSize = 14.sp)
                Text("🌱 CO2: 48g", color = Color.Gray, fontSize = 12.sp)
            }
        }
    }
}
