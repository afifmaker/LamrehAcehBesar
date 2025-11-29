// File: DashboardWisatawanScreen.kt
package com.example.explorelamreh

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.explorelamreh.ui.theme.DashboardEkowisataTheme
import com.example.explorelamreh.ui.theme.ToscaUtama

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardWisatawanScreen(onBackClick: () -> Unit, onJelajahClick: () -> Unit) {
    Scaffold(
        topBar = { WisatawanTopBar(onBackClick = onBackClick) },
        bottomBar = { WisatawanBottomBar() },
        containerColor = Color(0xFFF0F0F0) // Warna background abu-abu muda
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            item {
                HeaderImageWisatawan()
            }
            item {
                FeatureCard(
                    title = "Jelajah",
                    description = "Perencanaan perjalanan dengan edukasi sejak awal.",
                    imageRes = R.drawable.img_jelajah, // Ganti dengan nama file Anda
                    onClick = onJelajahClick
                )
            }
        }
    }
}

@Composable
fun WisatawanTopBar(onBackClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(
                color = ToscaUtama,
                shape = RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp)
            )
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Ikon Kembali
        IconButton(onClick = onBackClick) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Kembali",
                tint = Color.White,
                modifier = Modifier.size(28.dp)
            )
        }
        // Grup Ikon Kanan
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Notifikasi",
                tint = Color.White,
                modifier = Modifier.size(28.dp).clickable { /* Aksi Notifikasi */ }
            )
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Profil",
                tint = Color.White,
                modifier = Modifier.size(28.dp).clickable { /* Aksi Profil */ }
            )
        }
    }
}

@Composable
fun WisatawanBottomBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(
                color = ToscaUtama,
                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
            )
            .padding(horizontal = 48.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        BottomBarItem(icon = Icons.Default.Menu, text = "Menu", onClick = { /* Aksi Menu */ })
        BottomBarItem(icon = Icons.Default.Settings, text = "Setting", onClick = { /* Aksi Setting */ })
    }
}

@Composable
fun BottomBarItem(icon: androidx.compose.ui.graphics.vector.ImageVector, text: String, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable(onClick = onClick)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = text,
            tint = Color.White,
            modifier = Modifier.size(28.dp)
        )
        Text(text = text, color = Color.White, fontSize = 12.sp)
    }
}


@Composable
fun HeaderImageWisatawan() {
    Image(
        painter = painterResource(id = R.drawable.img_header_wisatawan), // Ganti dengan nama file Anda
        contentDescription = "Header Wisatawan",
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .clip(RoundedCornerShape(20.dp)),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun FeatureCard(title: String, description: String, imageRes: Int, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = title,
                modifier = Modifier.size(64.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = title, fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color.Black)
                Text(text = description, fontSize = 14.sp, color = Color.Gray)
            }
        }
    }
}


@Preview(showBackground = true, name = "Dashboard Wisatawan Preview")
@Composable
fun DashboardWisatawanScreenPreview() {
    DashboardEkowisataTheme {
        DashboardWisatawanScreen(onBackClick = {}, onJelajahClick = {})
    }
}
