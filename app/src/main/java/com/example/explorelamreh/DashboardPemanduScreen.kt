package com.example.explorelamreh

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.explorelamreh.ui.theme.DashboardEkowisataTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardPemanduScreen(onBackClick: () -> Unit, onPusatPelatihanClick: () -> Unit) {
    Scaffold(
        topBar = { WisatawanTopBar(onBackClick = onBackClick) }, // Bisa pakai TopBar yang sama
        bottomBar = { WisatawanBottomBar() }, // Bisa pakai BottomBar yang sama
        containerColor = Color(0xFFF0F0F0)
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
                // Header Image
                Image(
                    painter = painterResource(id = R.drawable.img_header_pemandu),
                    contentDescription = "Header Pemandu",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop
                )
            }
            item {
                FeatureCard(
                    title = "Pusat Pelatihan",
                    description = "Materi untuk meningkatkan skill komunikasi dan teknik bercerita Anda.",
                    imageRes = R.drawable.img_pelatihan,
                    onClick = onPusatPelatihanClick
                )
            }
        }
    }
}

@Preview(showBackground = true, name = "Dashboard Pemandu Preview")
@Composable
fun DashboardPemanduScreenPreview() {
    DashboardEkowisataTheme {
        DashboardPemanduScreen(onBackClick = {}, onPusatPelatihanClick = {})
    }
}
