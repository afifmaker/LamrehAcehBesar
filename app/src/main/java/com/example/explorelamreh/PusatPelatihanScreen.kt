package com.example.explorelamreh

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.RecordVoiceOver
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.explorelamreh.ui.theme.DashboardEkowisataTheme
import com.example.explorelamreh.ui.theme.ToscaUtama

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PusatPelatihanScreen(onBackClick: () -> Unit) {
    Scaffold(
        topBar = { PelatihanTopBar(onBackClick = onBackClick) },
        bottomBar = { PelatihanBottomBar() },
        containerColor = ToscaUtama
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                .background(Color.White),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(16.dp)
        ) {
            item { DasarPemanduCard() }
            item { TeknikStorytellingCard() }
        }
    }
}

@Composable
fun PelatihanTopBar(onBackClick: () -> Unit) {
    Column(modifier = Modifier.background(ToscaUtama)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, end = 16.dp, top = 24.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = onBackClick) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Kembali", tint = Color.White)
            }
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Icon(Icons.Default.Notifications, contentDescription = "Notifikasi", tint = Color.White)
                Icon(Icons.Default.Person, contentDescription = "Profil", tint = Color.White)
            }
        }
        Text(
            text = "Pusat Pelatihan",
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 16.dp, bottom = 16.dp)
        )
    }
}

@Composable
fun DasarPemanduCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF0FBF4))
    ) {
        Row(modifier = Modifier.height(IntrinsicSize.Min)) {
            Box(
                modifier = Modifier
                    .width(10.dp)
                    .fillMaxHeight()
                    .background(ToscaUtama.copy(alpha = 0.8f))
            )
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Icon(Icons.Default.School, contentDescription = "Pemandu Hebat", tint = ToscaUtama)
                    Text(text = "Dasar Pemandu Hebat", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                }
                InfoPoint(text = "Berikan Info Akurat: Jelaskan sejarah Kerajaan Lamuri dengan benar.")
                InfoPoint(text = "Ciptakan Rasa Nyaman: Ramah, sopan, dan ajak wisatawan mengobrol.")
                InfoPoint(text = "Jaga Keselamatan: Peringatkan jika ada jalan licin atau tebing curam.")
            }
        }
    }
}

@Composable
fun TeknikStorytellingCard() {
    val orangeColor = Color(0xFFF59E0B)
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFBEA))
    ) {
        Row(modifier = Modifier.height(IntrinsicSize.Min)) {
            Box(
                modifier = Modifier
                    .width(10.dp)
                    .fillMaxHeight()
                    .background(orangeColor.copy(alpha = 0.8f))
            )
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Icon(Icons.Default.RecordVoiceOver, contentDescription = "Storytelling", tint = orangeColor)
                    Text(text = "Teknik Storytelling", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                }
                Text(text = "\"Buat cerita menjadi hidup!\"", fontSize = 12.sp, color = Color.Gray)
                Spacer(modifier = Modifier.height(4.dp))
                CheckPoint(text = "Mainkan Nada Suara: Hindari bicara datar, gunakan intonasi.")
                CheckPoint(text = "Pancing Imajinasi: Ajak tamu membayangkan masa lalu.")
                CheckPoint(text = "Tunjukkan Antusiasme: Semangat kamu menular ke tamu!")
            }
        }
    }
}

@Composable
fun InfoPoint(text: String) {
    Row(verticalAlignment = Alignment.Top) {
        Text("•", modifier = Modifier.padding(horizontal = 8.dp), fontWeight = FontWeight.Bold, color = ToscaUtama)
        Text(text = text, fontSize = 14.sp, color = Color.DarkGray)
    }
}

@Composable
fun CheckPoint(text: String) {
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        Icon(Icons.Default.CheckCircle, contentDescription = "Check", tint = Color(0xFFF59E0B), modifier = Modifier.size(20.dp))
        Text(text = text, fontSize = 14.sp, color = Color.DarkGray)
    }
}

@Composable
fun PelatihanBottomBar() {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                .background(ToscaUtama)
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomBarItem(icon = Icons.Default.Menu, text = "Menu", onClick = {})
            Spacer(modifier = Modifier.weight(1f))
            BottomBarItem(icon = Icons.Default.Settings, text = "Setting", onClick = {})
        }
        FloatingActionButton(
            onClick = { /*TODO*/ },
            shape = CircleShape,
            containerColor = Color.White,
            contentColor = ToscaUtama,
            modifier = Modifier.offset(y = (-16).dp)
        ) {
            Icon(Icons.Default.Add, contentDescription = "Tambahkan")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PusatPelatihanScreenPreview() {
    DashboardEkowisataTheme {
        PusatPelatihanScreen(onBackClick = {})
    }
}
