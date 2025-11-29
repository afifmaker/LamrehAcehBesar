package com.example.explorelamreh

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.explorelamreh.ui.theme.DashboardEkowisataTheme
import com.example.explorelamreh.ui.theme.ToscaCard
import com.example.explorelamreh.ui.theme.ToscaUtama
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class Ekowisata : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Firebase.firestore
        enableEdgeToEdge()
        setContent {
            DashboardEkowisataTheme {
                // Panggil AppNavigation di sini
                AppNavigation()
            }
        }
    }
}

// Composable baru untuk mengatur semua navigasi aplikasi
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "category_selection") {
        composable("category_selection") {
            EkowisataCategoryScreen(
                onCategoryClick = { category ->
                    when (category) {
                        "Wisatawan" -> {
                            navController.navigate("dashboard_wisatawan")
                        }
                        "Pemandu" -> {
                            navController.navigate("dashboard_pemandu")
                        }
                        "Warga Lokal" -> {
                            navController.navigate("dashboard_warga")
                        }
                    }
                }
            )
        }
        composable("dashboard_wisatawan") {
            DashboardWisatawanScreen(
                onBackClick = { navController.popBackStack() },
                onJelajahClick = { navController.navigate("jelajah_screen") }
            )
        }
        composable("dashboard_pemandu") {
            DashboardPemanduScreen(
                onBackClick = { navController.popBackStack() },
                onPusatPelatihanClick = { navController.navigate("pusat_pelatihan_screen") }
            )
        }
        composable("dashboard_warga") {
            DashboardWargaLokalScreen(
                onBackClick = { navController.popBackStack() },
                onPojokKreatifClick = { navController.navigate("pojok_kreatif_screen") }
            )
        }
        composable("jelajah_screen") {
            JelajahScreen(
                onBackClick = { navController.popBackStack() },
                onDestinationClick = { destination ->
                    when (destination.name) {
                        "Kulam Putroe Ijo" -> navController.navigate("kulam_putroe_ijo_screen")
                        "Benteng Inong Balee" -> navController.navigate("benteng_inong_balee_screen")
                        "Bukit Soeharto" -> navController.navigate("bukit_soeharto_screen")
                        "Makam Keumalahayati" -> navController.navigate("makam_keumalahayati_screen")
                        "Bukit Lamreh" -> navController.navigate("bukit_lamreh_screen")
                        "Lheun Lhok" -> navController.navigate("lheun_lhok_screen")
                        "Spot Mancing Lubok" -> navController.navigate("spot_mancing_lubok_screen")
                        "Bukit Amat Rhang" -> navController.navigate("bukit_amat_rhang_screen")
                        "Spot Foto Mercusuar" -> navController.navigate("spot_foto_mercusuar_screen")
                        "Kawasan Kerajaan Lamuri" -> navController.navigate("kawasan_kerajaan_lamuri_screen")
                        "Pasir Putih" -> navController.navigate("pasir_putih_screen")
                    }
                }
            )
        }
        composable("kulam_putroe_ijo_screen") {
            KulamPutroeIjoScreen(onBackClick = { navController.popBackStack() })
        }
        composable("benteng_inong_balee_screen") {
            BentengInongBaleeScreen(onBackClick = { navController.popBackStack() })
        }
        composable("bukit_soeharto_screen") {
            BukitSoehartoScreen(onBackClick = { navController.popBackStack() })
        }
        composable("pusat_pelatihan_screen") {
            PusatPelatihanScreen(onBackClick = { navController.popBackStack() })
        }
        composable("pojok_kreatif_screen") {
            PojokKreatifScreen(onBackClick = { navController.popBackStack() })
        }
        composable("makam_keumalahayati_screen") {
            MakamKeumalahayatiScreen(onBackClick = { navController.popBackStack() })
        }
        composable("bukit_lamreh_screen") {
            BukitLamrehScreen(onBackClick = { navController.popBackStack() })
        }
        composable("lheun_lhok_screen") {
            LheunLhokScreen(onBackClick = { navController.popBackStack() })
        }
        composable("spot_mancing_lubok_screen") {
            SpotMancingLubokScreen(onBackClick = { navController.popBackStack() })
        }
        composable("bukit_amat_rhang_screen") {
            BukitAmatRhangScreen(onBackClick = { navController.popBackStack() })
        }
        composable("spot_foto_mercusuar_screen") {
            SpotFotoMercusuarScreen(onBackClick = { navController.popBackStack() })
        }
        composable("kawasan_kerajaan_lamuri_screen") {
            KawasanKerajaanLamuriScreen(onBackClick = { navController.popBackStack() })
        }
        composable("pasir_putih_screen") {
            PasirPutihScreen(onBackClick = { navController.popBackStack() })
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EkowisataCategoryScreen(onCategoryClick: (String) -> Unit) {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar() },
        containerColor = Color.White // Warna background utama layar
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CategoryCard(
                title = "Wisatawan",
                description = "Jelajahi destinasi, buat rencana tujuan, dan dapatkan rekomendasi",
                imageRes = R.drawable.img_wisatawan,
                onClick = { onCategoryClick("Wisatawan") }
            )
            CategoryCard(
                title = "Pemandu",
                description = "Akses Materi, simulasi pemanduan, dan kelola rating",
                imageRes = R.drawable.img_pemandu,
                onClick = { onCategoryClick("Pemandu") }
            )
            CategoryCard(
                title = "Warga Lokal",
                description = "Temukan Peluang Usaha dan kelola pariwisata berkelanjutan",
                imageRes = R.drawable.img_warga_lokal,
                onClick = { onCategoryClick("Warga Lokal") }
            )
        }
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp) // Sedikit lebih tinggi untuk estetika
            .background(
                color = ToscaUtama,
                shape = RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp)
            )
            .padding(horizontal = 24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Kembali",
            tint = Color.White,
            modifier = Modifier
                .size(28.dp)
                .clickable { /* Aksi kembali */ }
        )
        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = "Notifikasi",
            tint = Color.White,
            modifier = Modifier
                .size(28.dp)
                .clickable { /* Aksi notifikasi */ }
        )
    }
}

@Composable
fun BottomBar() {
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
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            imageVector = Icons.Default.Home,
            contentDescription = "Beranda",
            tint = Color.White,
            modifier = Modifier
                .size(32.dp)
                .clickable { /* Aksi beranda */ }
        )
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "Profil",
            tint = Color.White,
            modifier = Modifier
                .size(32.dp)
                .clickable { /* Aksi profil */ }
        )
    }
}

@Composable
fun CategoryCard(
    title: String,
    description: String,
    imageRes: Int,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = ToscaCard), // Menggunakan warna tosca lebih terang
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = title,
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = ToscaUtama
                )
                Text(
                    text = description,
                    fontSize = 14.sp,
                    color = Color.DarkGray
                )
            }
        }
    }
}

@Preview(showBackground = true, name = "Ekowisata Category Screen")
@Composable
fun GreetingPreview() {
    DashboardEkowisataTheme {
        AppNavigation() // Preview sekarang menjalankan AppNavigation
    }
}
