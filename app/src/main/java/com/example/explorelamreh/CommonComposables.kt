package com.example.explorelamreh

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.explorelamreh.ui.theme.ToscaUtama

@Composable
fun PlanButton() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 16.dp)
            .height(56.dp),
        colors = ButtonDefaults.buttonColors(containerColor = ToscaUtama),
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(text = "+ Rencanakan", fontSize = 18.sp)
    }
}

@Composable
fun DestinationButton() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 16.dp)
            .height(56.dp),
        colors = ButtonDefaults.buttonColors(containerColor = ToscaUtama),
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(text = "Menuju Destinasi", fontSize = 18.sp)
    }
}

@Composable
fun InfoItem(icon: androidx.compose.ui.graphics.vector.ImageVector, title: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(imageVector = icon, contentDescription = title, tint = ToscaUtama)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = title, fontSize = 12.sp, color = Color.Gray)
        Text(text = value, fontSize = 14.sp, fontWeight = FontWeight.Bold)
    }
}
