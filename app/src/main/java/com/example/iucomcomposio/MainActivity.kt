package com.example.iucomcomposio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.iucomcomposio.ui.theme.IUComComposiçãoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IUComComposiçãoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeUIApp()
                }
            }
        }
    }
}

@Composable
fun InfomacaoPessoal(nomeCompleto: String, titulo: String, modifier: Modifier = Modifier){
    val image = painterResource(id = R.drawable.eu)
    Column ( modifier.padding(4.dp).fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            modifier = Modifier.padding(4.dp),
            painter = image,
            contentDescription = "Imagem do contato sorrindo",
            contentScale = ContentScale.FillBounds
        )
        Text(
            text = nomeCompleto,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = titulo,
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        )
    }

}

@Composable
fun IconeTexto(icone: ImageVector, texto: String, modifier: Modifier = Modifier) {
    Row (modifier.padding(4.dp), verticalAlignment = Alignment.Bottom
    ){
        Icon(
            imageVector = icone,
            modifier = Modifier.weight(0.2f).height(25.dp),
            contentDescription = null,
            tint = Color(47,40,40)
        )
        Text(
            text = texto,
            modifier = Modifier.weight(0.8f).height(25.dp),
            fontSize = 12.sp,
            lineHeight = 30.sp,
            color = Color(47, 47, 227)
        )
    }
}
@Composable
fun InformacoesContato(
    icone1: ImageVector,
    texto1: String,
    icone2: ImageVector,
    texto2: String,
    icone3: ImageVector,
    texto3: String,
    modifier: Modifier
){
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconeTexto(icone = icone1, texto = texto1, modifier)
        IconeTexto(icone = icone2, texto = texto2, modifier)
        IconeTexto(icone = icone3, texto = texto3, modifier)
    }
}

@Composable
fun ComposeUIApp(){
    Column (Modifier
                .padding(8.dp).fillMaxSize().fillMaxHeight().fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceEvenly,
        ) {
        InfomacaoPessoal(
            nomeCompleto = stringResource(R.string.nome_completo),
            titulo = stringResource(R.string.titulo),
            modifier = Modifier
        )
        val MyAppIcons = Icons.Rounded
        InformacoesContato(
            MyAppIcons.Phone,
            stringResource(R.string.numero_telefone),
            MyAppIcons.Email,
            stringResource(R.string.email),
            MyAppIcons.AccountCircle,
            stringResource(R.string.instagram),
            modifier = Modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IUComComposiçãoTheme {
        ComposeUIApp()
    }
}