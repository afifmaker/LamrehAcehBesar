package com.example.explorelamreh

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

// Original Colors
private val GreenTag = Color(0xFFE3F3E9)
private val GreenTagText = Color(0xFF3C8D5D)
private val OrangeTag = Color(0xFFFDE9E3)
private val OrangeTagText = Color(0xFFB95027)
private val BlueTag = Color(0xFFE3F2FD)
private val BlueTagText = Color(0xFF2E64A4)

// New Colors
private val LightBlueTag = Color(0xFFCFFAFE)
private val LightBlueTagText = Color(0xFF0E7490)
private val YellowTag = Color(0xFFFEF9C3)
private val YellowTagText = Color(0xFF854D0E)

data class Destination(
    val imageRes: Int,
    val name: String,
    val category: String,
    val tags: List<Pair<String, Color>>
)

val featuredDestinations = listOf(
    Destination(
        imageRes = R.drawable.lheun_lhok,
        name = "Lheun Lhok",
        category = "Aceh Besar",
        tags = listOf("Pantai" to LightBlueTag)
    ),
    Destination(
        imageRes = R.drawable.spot_mancing_lubok,
        name = "Spot Mancing Lubok",
        category = "Aceh Besar",
        tags = listOf("Hobi" to BlueTag)
    ),
    Destination(
        imageRes = R.drawable.bukit_amat_rhang,
        name = "Bukit Amat Rhang",
        category = "Aceh Besar",
        tags = listOf("Alam" to GreenTag)
    ),
    Destination(
        imageRes = R.drawable.spot_foto_mercusuar,
        name = "Spot Foto Mercusuar",
        category = "Aceh Besar",
        tags = listOf("Fotografi" to YellowTag)
    ),
    Destination(
        imageRes = R.drawable.kerajaan_lamuri,
        name = "Kawasan Kerajaan Lamuri",
        category = "Aceh Besar",
        tags = listOf("Sejarah" to OrangeTag)
    ),
    Destination(
        imageRes = R.drawable.pasir_putih,
        name = "Pasir Putih",
        category = "Aceh Besar",
        tags = listOf("Pantai" to LightBlueTag)
    ),
    Destination(
        imageRes = R.drawable.makam_putroe_ijo,
        name = "Kulam Putroe Ijo",
        category = "Wisata Alam Air",
        tags = listOf("Ekowisata" to GreenTag)
    ),
    Destination(
        imageRes = R.drawable.img_banteng_inong_balee,
        name = "Benteng Inong Balee",
        category = "Situs Sejarah",
        tags = listOf("Edukasi" to OrangeTag)
    ),
    Destination(
        imageRes = R.drawable.img_bukit_soeharto,
        name = "Bukit Soeharto",
        category = "Pemandangan Alam",
        tags = listOf("Trekking" to GreenTag)
    ),
    Destination(
        imageRes = R.drawable.img_makam_laksamana_keumalahayati,
        name = "Makam Keumalahayati",
        category = "Wisata Religi & Sejarah",
        tags = listOf("Budaya" to BlueTag)
    ),
    Destination(
        imageRes = R.drawable.img_bukit_lamreh,
        name = "Bukit Lamreh",
        category = "Pemandangan Alam",
        tags = listOf("Trekking" to GreenTag)
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JelajahScreen(onBackClick: () -> Unit, onDestinationClick: (Destination) -> Unit) {
    Scaffold(
        topBar = { JelajahTopBar(onBackClick = onBackClick) },
        bottomBar = { JelajahBottomBar() },
        containerColor = ToscaUtama
    ) {
        Column(modifier = Modifier.padding(it)) {
            JelajahHeader()
            DestinationsContent(onDestinationClick)
        }
    }
}

@Composable
fun JelajahTopBar(onBackClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 32.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Kembali",
            tint = Color.White,
            modifier = Modifier.clickable(onClick = onBackClick)
        )
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Notifikasi",
                tint = Color.White
            )
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Profil",
                tint = Color.White
            )
        }
    }
}

@Composable
fun JelajahHeader() {
    var searchQuery by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        Text(
            text = "Jelajah & Rencanakan",
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("Cari destinasi anda", color = Color.Gray) },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search Icon", tint = Color.Gray) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
fun DestinationsContent(onDestinationClick: (Destination) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
            .background(Color.White)
            .padding(top = 24.dp)
    ) {
        Text(
            text = "Destinasi Unggulan",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 24.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 24.dp, vertical = 16.dp)
        ) {
            items(featuredDestinations) { destination ->
                DestinationCard(destination, onDestinationClick)
            }
        }
    }
}

@Composable
fun DestinationCard(destination: Destination, onDestinationClick: (Destination) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onDestinationClick(destination) },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = destination.imageRes),
                contentDescription = destination.name,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = destination.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = "Category Icon",
                        modifier = Modifier.size(14.dp),
                        tint = Color.Gray
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = destination.category, fontSize = 12.sp, color = Color.Gray)
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    destination.tags.forEach { (tag, color) ->
                        TagChip(tag, color)
                    }
                }
            }
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Go to destination",
                tint = Color.Gray,
                modifier = Modifier.size(32.dp)
            )
        }
    }
}

@Composable
fun TagChip(text: String, backgroundColor: Color) {
    Box(
        modifier = Modifier
            .background(backgroundColor, RoundedCornerShape(8.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Text(
            text = text,
            color = when (backgroundColor) {
                GreenTag -> GreenTagText
                OrangeTag -> OrangeTagText
                BlueTag -> BlueTagText
                LightBlueTag -> LightBlueTagText
                YellowTag -> YellowTagText
                else -> Color.DarkGray
            },
            fontSize = 10.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun JelajahBottomBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
            )
            .padding(horizontal = 48.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(imageVector = Icons.Default.Home, contentDescription = "Menu", tint = ToscaUtama)
            Text(text = "Menu", color = ToscaUtama, fontSize = 12.sp)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(imageVector = Icons.Default.Settings, contentDescription = "Setting", tint = Color.Gray)
            Text(text = "Setting", color = Color.Gray, fontSize = 12.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun JelajahScreenPreview() {
    DashboardEkowisataTheme {
        JelajahScreen(onBackClick = {}, onDestinationClick = {})
    }
}
