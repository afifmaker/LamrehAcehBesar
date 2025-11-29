package com.example.explorelamreh

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.explorelamreh.ui.theme.DashboardEkowisataTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KulamPutroeIjoScreen(onBackClick: () -> Unit) {
    Scaffold(
        containerColor = Color.White
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            HeaderKulamPutroeIjo(onBackClick = onBackClick)
            Spacer(modifier = Modifier.height(16.dp))
            InfoSection()
            Spacer(modifier = Modifier.height(24.dp))
            AboutSection()
            Spacer(modifier = Modifier.height(24.dp))
            EcoWisataInfo()
            Spacer(modifier = Modifier.height(24.dp))
            DestinationButton()
        }
    }
}

@Composable
fun HeaderKulamPutroeIjo(onBackClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .clip(RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp))
    ) {
        Image(
            painter = painterResource(id = R.drawable.makam_putroe_ijo),
            contentDescription = "Kulam Putroe Ijo",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.7f)),
                        startY = 400f,
                        endY = Float.POSITIVE_INFINITY
                    )
                )
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 32.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back",
                tint = Color.White,
                modifier = Modifier.clickable(onClick = onBackClick)
            )
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = "Favorite",
                tint = Color.White
            )
        }
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(24.dp)
        ) {
            Text(text = "ALAM", color = Color.White, fontSize = 14.sp)
            Text(text = "Kulam Putroe Ijo", color = Color.White, fontSize = 28.sp, fontWeight = FontWeight.Bold)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(imageVector = Icons.Default.Place, contentDescription = "Location", tint = Color.White, modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Aceh Besar, Aceh", color = Color.White, fontSize = 14.sp)
            }
        }
    }
}

@Composable
fun InfoSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        InfoItem(icon = Icons.Default.History, title = "Jam Buka", value = "08:00 - 18:00")
        InfoItem(icon = Icons.Default.Info, title = "Kewajiban", value = "Mudah")
    }
}

@Composable
fun AboutSection() {
    Column(modifier = Modifier.padding(horizontal = 24.dp)) {
        Text(text = "Tentang Destinasi", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Kolam alami dengan air jernih berwarna kehijauan. Sempurna untuk bersantai. Dikelilingi pepohonan rimbun yang menjaga keasrian lingkungan.", fontSize = 14.sp, color = Color.Gray)
    }
}

@Composable
fun EcoWisataInfo() {
    Card(
        modifier = Modifier.padding(horizontal = 24.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFBEA)),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = Icons.Default.Info, contentDescription = "Info", tint = Color(0xFFF59E0B))
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = "Wawasan Ekowisata", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                Text(text = "Jaga kebersihan air dengan tidak menggunakan sabun kimia saat berenang di kolam alami ini.", fontSize = 12.sp, color = Color.Gray)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun KulamPutroeIjoScreenPreview() {
    DashboardEkowisataTheme {
        KulamPutroeIjoScreen(onBackClick = {})
    }
}
