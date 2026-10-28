package com.example.filme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.filme.ui.theme.FilmeTheme
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.Movie
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FilmeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TelaPreferencias(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
val listadefil = listOf(
    "Shrek",
    "Toy story",
    "Divertida mente",
    "Encanto",
    "A origem",
    "Minha mãe é uma peça",
    "A odisseia",
    "Paixão de escritório",
    "Mensagens para Isabelle",
    "Alerta vermelho",
    "Se meu apartamento falasse",
    "10 Coisas que eu odeio em você",
    "De repente 30",
    "A mãe",
    "Para todos os garotos que já amei",
    "Todos menos você",
    "De férias com você",
    "Fuja",
    "A freira",
    "O exorcista",
    "Invocação do mal",
    "Hereditário",
    "Resgate",
    "Mulan"
)
val filmesComedia = listOf(
    "Minha mãe é uma peça",
    "Se meu apartamento falasse",
    "10 Coisas que eu odeio em você",
    "De repente 30"
)
val filmesRomance = listOf(
    "Paixão de escritório",
    "Mensagens para Isabelle",
    "Para todos os garotos que já amei",
    "Todos menos você",
    "De férias com você"
)
val filmesTerror = listOf(
    "Fuja",
    "O exorcista",
    "Invocação do mal",
    "Hereditário"
)
val filmesAcao = listOf(
    "A mãe",
    "Alerta vermelho",
    "A origem",
   "A odisseia",
    "Resgate"
)
val filmesAnimacao = listOf(
    "Shrek",
    "Toy story",
    "Divertida mente",
    "Encanto",
    "Mulan"

)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    var filmeSorteado by remember {
        mutableStateOf("Seu filme aparecerá aqui !")
    }

    var mensagem by remember {
        mutableStateOf("Escolha um filme para começar!")
    }


    Column(
        modifier = modifier.fillMaxSize().background(Color(0xFFFFF1F5)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically)
    ) {
        Icon(
            imageVector = Icons.Default.Movie,
            contentDescription = "Ícone de cinema",
            tint = Color(0xFFC2185B),
            modifier = modifier.size(60.dp)
        )
        Text(
            text = "MOVIE NOVE",
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFD81860)
        )
        Text(
            text = "Sua próxima sessão começa aqui!\uD83C\uDF7F",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFE91E63)
        )
        Text(
            text = "Não sabe o que assistir hoje? Deixe a sorte escolher por você!",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFF44336)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Card(
                shape =  RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                containerColor = Color(0xFFEDE7F6)
            ),
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = filmeSorteado,
                color = Color.DarkGray,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(20.dp)
            )
            Text(
                text = mensagem,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFFC2185B),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )

        }

        Button(
            onClick = {
                filmeSorteado= listadefil.random()
            mensagem = "Ótima escolha! Prepare a pipoca e aproveite o filme !"
               },
            modifier = Modifier.padding(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFE91E63)
            )
        ) {
            Text(
                text = "ESCOLHER FILME",
                color = Color.Black
            )
        }
    }
}
@Composable
fun TelaPreferencias(modifier: Modifier = Modifier) {
    var generoSelecionado by remember {
        mutableStateOf("")
    }
    var filmeSorteado by remember {
        mutableStateOf("")
    }
    val capaSelecionada = when (filmeSorteado) {
        "Shrek" -> R.drawable.shrek
        "Toy story" -> R.drawable.toy_story
        "Divertida mente" -> R.drawable.divertidamente
        "Encanto" -> R.drawable.encanto
        "A origem" -> R.drawable.a_origem
        "Minha mãe é uma peça" -> R.drawable.minhamaeeumapeca
        "Paixão de escritório" -> R.drawable.paixao_de_escritorio
        "Mensagens para Isabelle" -> R.drawable.mensagensparaisabelle
        "A odisseia" -> R.drawable.a_odisseia
        "Alerta vermelho" -> R.drawable.alerta_vermelho
        "De férias com você" -> R.drawable.de_ferias_com_voce
        "De repente 30" -> R.drawable.de_repente_trinta
        "10 Coisas que eu odeio em você" -> R.drawable.dez_coisas_que_eu_odeio_em_voce
        "Hereditário" -> R.drawable.hereditario
        "Invocação do mal" -> R.drawable.invocacao_do_mal
        "Mulan" -> R.drawable.mulan
        "O exorcista" -> R.drawable.o_exorcista
        "Para todos os garotos que já amei" -> R.drawable.para_todos_os_garotos_que_ja_amei
        "Resgate" -> R.drawable.resgate
        "Se meu apartamento falasse" -> R.drawable.se_meu_apartamento_falasse
        "Todos menos você" -> R.drawable.todos_menos_voce
        "A mãe" -> R.drawable.a_mae
        "Fuja" -> R.drawable.fuja
        "A freira" -> R.drawable.a_freira




         else -> null
    }
    var telaAtual by remember {
        mutableStateOf("genero")
    }

    val filmesDoGenero = when (generoSelecionado) {
        "Comédia" -> filmesComedia
        "Romance" -> filmesRomance
        "Terror" -> filmesTerror
        "Ação" -> filmesAcao
        "Animação" -> filmesAnimacao
        else -> emptyList()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFFFF1F5))
            .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Default.Movie,
            contentDescription = "Ícone de cinema",
            tint = Color(0xFFC2185B),
            modifier = modifier.size(60.dp)
        )
        Text(
            text = "MOVIE NOVE",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFC2185B)
        )
        if (telaAtual == "genero") {
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Qual gênero de filme você quer assistir?",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    generoSelecionado = "Comédia"
                    telaAtual = "sorteio"
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFC2185B)
                )
            ) {
                Text("😂 Comédia")
            }
            Button(
                onClick = {
                    generoSelecionado = "Romance"
                    telaAtual = "sorteio"
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFC2185B)
                )
            ) {
                Text("😍 Romance")
            }
            Button(
                onClick = {
                    generoSelecionado = "Terror"
                    telaAtual = "sorteio"
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFC2185B)
                )
            ) {
                Text("😮 Terror")
            }
            Button(
                onClick = {
                    generoSelecionado = "Ação"
                    telaAtual = "sorteio"
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFC2185B)
                )
            ) {
                Text("🤩 Ação")
            }
            Button(
                onClick = {
                    generoSelecionado = "Animação"
                    telaAtual = "sorteio"
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFC2185B)
                )
            ) {
                Text("😀 Animação")
            }
        } else {
            Spacer(modifier = Modifier.height(20.dp))

            if (generoSelecionado.isNotEmpty()) {
                Text(
                    text = "Gênero escolhido: $generoSelecionado",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.height(20.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (capaSelecionada != null) {
                    Image(
                        painter = painterResource(id = capaSelecionada),
                        contentDescription = "Capa de $filmeSorteado",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(260.dp),
                        contentScale = ContentScale.Fit
                    )

                    Spacer(modifier = Modifier.height(12.dp))
                }
                    Text(
                        text = if (filmeSorteado.isEmpty()) {
                            "Seu filme aparecerá aqui!"
                        } else {
                            filmeSorteado
                        },
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = if (filmeSorteado.isEmpty()) {
                            "Escolha um gênero e prepare a pipoca! 🍿"
                        } else {
                            "Prepare a pipoca e aproveite! 🎬"
                        },
                        textAlign = TextAlign.Center

                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    if (generoSelecionado.isNotEmpty()) {
                        Button(
                            onClick = {
                                filmeSorteado = filmesDoGenero.random()
                            },
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFC2185B)
                            )
                        ) {
                            Text("🎬 Sortear filme")
                        }
                        Spacer(modifier = Modifier.height(8.dp))

                        Spacer(modifier = Modifier.height(8.dp))

                        Button(
                            onClick = {
                                telaAtual = "genero"
                                filmeSorteado = ""
                                generoSelecionado = ""
                            },
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFC2185B)
                            )
                        ) {
                            Text("⬅️ Voltar e escolher outro gênero")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FilmeTheme {
        Greeting("Android")
    }
}
