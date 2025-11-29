package com.example.explorelamreh

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Hiking
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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

@Composable
fun BukitLamrehScreen(onBackClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .background(Color.White)
        ) {
            // Header Section
            Box(modifier = Modifier.height(400.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.img_bukit_lamreh),
                    contentDescription = "Bukit Lamreh",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
                )
                // Gradient Overlay
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.6f)),
                                startY = 500f
                            )
                        )
                )
                // Top Buttons
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                        onClick = onBackClick,
                        modifier = Modifier.background(Color.Black.copy(alpha = 0.3f), CircleShape)
                    ) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back", tint = Color.White)
                    }
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.background(Color.Black.copy(alpha = 0.3f), CircleShape)
                    ) {
                        Icon(Icons.Default.FavoriteBorder, "Favorite", tint = Color.White)
                    }
                }
                // Title Section
                Column(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(24.dp)
                ) {
                    Text("ALAM", color = Color.White, fontSize = 12.sp, modifier = Modifier.background(Color.White.copy(alpha=0.15f), RoundedCornerShape(4.dp)).padding(horizontal = 6.dp, vertical = 2.dp))
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("Bukit Lamreh", color = Color.White, fontSize = 26.sp, fontWeight = FontWeight.Bold)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.LocationOn, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Aceh Besar, Aceh", color = Color.White, fontSize = 14.sp)
                    }
                }
            }

            // Content Section
            Column(modifier = Modifier.padding(24.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    InfoColumn(title = "Jam Buka", value = "24 Jam", icon = { Icon(Icons.Default.Schedule, contentDescription = null, tint = ToscaUtama) })
                    InfoColumn(title = "Akses", value = "Menantang", icon = { Icon(Icons.Default.Hiking, contentDescription = null, tint = ToscaUtama) })
                }

                Spacer(modifier = Modifier.height(24.dp))

                Text("Tentang Destinasi", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Bukit Lamreh menawarkan pemandangan tebing yang eksotis berpadu dengan birunya laut Samudra Hindia. Salah satu spot terbaik untuk menikmati matahari terbenam.",
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                    lineHeight = 20.sp
                )

                Spacer(modifier = Modifier.height(16.dp))

                Card(
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFBEB)),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Row(Modifier.padding(16.dp)) {
                        Icon(Icons.Default.Info, contentDescription = null, tint = Color(0xFFD97706), modifier = Modifier.padding(top=2.dp))
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text("Wawasan Ekowisata", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Jaga kebersihan dengan tidak membuang sampah sembarangan dan ikuti jalur yang sudah ada untuk menjaga kelestarian alam.",
                                fontSize = 12.sp,
                                color = Color.DarkGray,
                                lineHeight = 16.sp
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 16.dp)
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = ToscaUtama),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text("Menuju Destinasi", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
private fun InfoColumn(title: String, value: String, icon: @Composable () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        icon()
        Spacer(modifier = Modifier.height(8.dp))
        Text(title, fontSize = 12.sp, color = Color.Gray)
        Text(value, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Preview(showBackground = true)
@Composable
fun BukitLamrehScreenPreview() {
    DashboardEkowisataTheme {
        BukitLamrehScreen(onBackClick = {})
    }
}
