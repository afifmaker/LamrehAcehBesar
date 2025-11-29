// File: DashboardWargaLokalScreen.kt
package com.example.explorelamreh

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
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
fun DashboardWargaLokalScreen(onBackClick: () -> Unit, onPojokKreatifClick: () -> Unit) {
    Scaffold(
        // Kita kembalikan strukturnya seperti semula
        topBar = { WisatawanTopBar(onBackClick = onBackClick) }, // Pakai ulang TopBar
        bottomBar = { WisatawanBottomBar() }, // Pakai ulang BottomBar
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
                // Header Image, sama seperti dashboard lainnya
                Image(
                    painter = painterResource(id = R.drawable.img_header_warga),
                    contentDescription = "Header Warga Lokal",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp) // Samakan tingginya dengan yang lain
                        .clip(RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop
                )
            }
            item {
                // Gunakan kembali FeatureCard yang sudah ada
                FeatureCard(
                    title = "Pojok Kreatif",
                    description = "Temukan ide bisnis & peluang ekonomi dari sektor ekowisata.",
                    imageRes = R.drawable.img_peluang_usaha,
                    onClick = onPojokKreatifClick
                )
            }
        }
    }
}


@Preview(showBackground = true, name = "Dashboard Warga Lokal Preview")
@Composable
fun DashboardWargaLokalScreenPreview() {
    DashboardEkowisataTheme {
        DashboardWargaLokalScreen(onBackClick = {}, onPojokKreatifClick = {})
    }
}
