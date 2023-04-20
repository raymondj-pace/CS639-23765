package com.example.businesscard

import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.MaterialTheme
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Divider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

import android.os.Bundle

import com.example.businesscard.ui.theme.BusinessCardTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme(darkTheme = true) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardWithImage(name = "Ray Jennings", title = "Principal Technical Architect", phone = "+1 (646) 330-5074", email = "rayj@android.com", handle = "@RayJ")
                }
            }
        }
    }
}

@Composable
fun BusinessCardWithImage(name: String, title: String, phone: String, email: String, handle: String, modifier: Modifier = Modifier) {
    val darkblue = Color(0xFF0A3041)
    val android_logo_color = Color(0xFF47DB87)
    val image = painterResource(id = R.drawable.android_logo)
    val phoneIcon = painterResource(id = R.drawable.android_phone)
    val emailIcon = painterResource(id = R.drawable.email)
    val laptopIcon = painterResource(id = R.drawable.laptop_icon)
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = darkblue) {
        Box(contentAlignment = Alignment.TopCenter) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row(modifier = Modifier.padding(top = 50.dp)) {
                    Box(modifier = Modifier.height(150.dp)) {
                        Image(
                            modifier = Modifier,
                            painter = image,
                            contentDescription = null,
                            contentScale = ContentScale.Inside
                        )
                    }
                }
                Row(modifier = Modifier.padding(top = 20.dp)) {
                    Text(
                        text = name,
                        fontSize = 38.sp,
                        fontWeight = FontWeight.Light,
                        color = Color.White,
                        modifier = modifier
                    )
                }
                Row(modifier = Modifier.padding(top = 15.dp)) {
                    Text(
                        text = title,
                        fontSize = 20.sp,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold,
                        color = android_logo_color,
                        modifier = modifier
                    )
                }
            }
        }
        Box(contentAlignment = Alignment.Center) {
            Column(horizontalAlignment = Alignment.Start) {
                Row(modifier = Modifier.padding(top = 350.dp)) {
                    Divider(color = Color.Gray, thickness = 1.dp)
                }
                Row(modifier = Modifier.padding(top = 15.dp)) {
                    Box(modifier = Modifier.padding(start = 40.dp))
                    Image(
                        modifier = Modifier.padding(horizontal = 30.dp),
                        painter = phoneIcon,
                        contentDescription = null
                    )
                    Text(
                        text = phone,
                        color = Color.White,
                        fontSize = 18.sp,
                        modifier = modifier
                    )
                }
                Row(modifier = Modifier.padding(top = 15.dp)) {
                    Divider(color = Color.Gray, thickness = 1.dp)
                }
                Row(modifier = Modifier.padding(top = 15.dp)) {
                    Box(modifier = Modifier.padding(start = 40.dp))
                    Image(
                        modifier = Modifier.padding(horizontal = 30.dp),
                        painter = laptopIcon,
                        contentDescription = null,
                        contentScale = ContentScale.Inside
                    )
                    Text(
                        text = handle,
                        color = Color.White,
                        fontSize = 18.sp,
                        modifier = modifier
                    )
                }
                Row(modifier = Modifier.padding(top = 15.dp)) {
                    Divider(color = Color.Gray, thickness = 1.dp)
                }
                Row(modifier = Modifier.padding(top = 15.dp)) {
                    Box(modifier = Modifier.padding(start = 40.dp))
                    Image(
                        modifier = Modifier.padding(horizontal = 30.dp),
                        painter = emailIcon,
                        contentDescription = null,
                        contentScale = ContentScale.Inside
                    )
                    Text(
                        text = email,
                        color = Color.White,
                        fontSize = 18.sp,
                        modifier = modifier
                    )
                }
                Row(modifier = Modifier.padding(top = 15.dp)) {
                    Divider(color = Color.Gray, thickness = 1.dp)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCardWithImage("Ray Jennings", "Principal Technical Architect", "+1 (646) 4330-5074", "ray@android.com", "@RayJ")
    }
}