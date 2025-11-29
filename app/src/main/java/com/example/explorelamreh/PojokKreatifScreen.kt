package com.example.explorelamreh

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import com.example.explorelamreh.ui.theme.ToscaUtama

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PojokKreatifScreen(onBackClick: () -> Unit) {
    Scaffold(
        topBar = { PojokKreatifTopBar(onBackClick = onBackClick) },
        bottomBar = { PelatihanBottomBar() }, // Reusing the bottom bar from the other screen
        containerColor = Color.White
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding).fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            contentPadding = PaddingValues(bottom = 24.dp)
        ) {
            item { KreatifHeaderImage() }
            item { AlatDanBahan() }
            item { CaraMembuat() }
        }
    }
}

@Composable
fun PojokKreatifTopBar(onBackClick: () -> Unit) {
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
            text = "Pojok Kreatif",
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 16.dp, bottom = 16.dp)
        )
    }
}

@Composable
fun KreatifHeaderImage() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_lampu),
            contentDescription = "Lampu Hias",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.7f)),
                        startY = 300f
                    )
                )
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)
        ) {
            Text(
                text = "Ide Usaha Kreatif",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Lampu Hias dari Botol Bekas",
                color = Color.White,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun AlatDanBahan() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Icon(Icons.Default.Build, contentDescription = "Alat & Bahan", tint = ToscaUtama)
            Text(text = "Alat & Bahan", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            BahanChip("Botol Plastik", modifier = Modifier.weight(1f))
            BahanChip("Lampu LED", modifier = Modifier.weight(1f))
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            BahanChip("Gunting & Lem", modifier = Modifier.weight(1f))
            BahanChip("Tali Gantung", modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun BahanChip(text: String, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        color = Color(0xFFF3F4F6), // Light grey
    ) {
        Text(
            text = "• $text",
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
            fontSize = 14.sp
        )
    }
}

@Composable
fun CaraMembuat() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Icon(Icons.Default.Book, contentDescription = "Cara Membuat", tint = ToscaUtama)
            Text(text = "Cara Membuat", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        }
        Spacer(modifier = Modifier.height(16.dp))
        NumberedStep("1", "Siapkan Botol", "Bersihkan botol dan potong bagian bawah 4-5 cm.")
        Spacer(modifier = Modifier.height(12.dp))
        NumberedStep("2", "Pasang Lampu LED", "Masukkan lampu ke dalam potongan botol, rekatkan dengan lem.")
        Spacer(modifier = Modifier.height(12.dp))
        NumberedStep("3", "Finishing", "Pasang tali gantungan pada tutup botol, satukan, dan nyalakan!")
    }
}

@Composable
fun NumberedStep(number: String, title: String, description: String) {
    Row(horizontalArrangement = Arrangement.spacedBy(16.dp), verticalAlignment = Alignment.Top) {
        Box(
            modifier = Modifier
                .size(24.dp)
                .background(ToscaUtama, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(text = number, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        }
        Column {
            Text(text = title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(text = description, fontSize = 14.sp, color = Color.Gray)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PojokKreatifScreenPreview() {
    DashboardEkowisataTheme {
        PojokKreatifScreen(onBackClick = {})
    }
}
