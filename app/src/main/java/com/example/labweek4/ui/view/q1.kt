package com.example.labweek4.ui.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.labweek4.R
import com.example.labweek4.data.dummy_data
import com.example.labweek4.model.line_chat

@Composable
fun Q1View(chatList: List<line_chat>) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Top bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFfafafa))
                    .drawBehind {
                        val strokeWidth = 1.dp.toPx()
                        val y = size.height - strokeWidth / 2
                        drawLine(
                            color = Color.LightGray,
                            start = Offset(0f, y),
                            end = Offset(size.width, y),
                            strokeWidth = strokeWidth
                        )
                    }
                    .padding(6.dp, 4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Column(
                    modifier = Modifier
                        .padding(10.dp, 16.dp, 10.dp, 10.dp)
                        .weight(1f)
                ) {
                    Text(
                        text = "WhatsApp",
                        fontWeight = FontWeight.Bold,
                        fontSize = 26.sp,
                        color = Color(0xFF228B22)
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(10.dp, 16.dp, 10.dp, 10.dp)
                        .weight(1f), horizontalAlignment = Alignment.End
                ) {
                    Row(
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.outline_photo_camera_24),
                            contentDescription = "Camera",
                            modifier = Modifier.padding(10.dp, 0.dp)
                        )
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Search",
                            modifier = Modifier.padding(10.dp, 0.dp)
                        )
                        Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "More")
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp, 16.dp, 14.dp, 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFFA8E4A0))
                        .padding(12.dp, 6.dp)
                ) {
                    Text(text = "All", textAlign = TextAlign.Center, fontWeight = FontWeight.SemiBold, color = Color(0xFF0B6623))
                }
                Column(
                    modifier = Modifier
                        .padding(start = 6.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFFDDDDDD))
                        .padding(12.dp, 6.dp)
                ) {
                    Text(text = "Unread", textAlign = TextAlign.Center, fontWeight = FontWeight.SemiBold, color = Color.DarkGray)
                }
                Column(
                    modifier = Modifier
                        .padding(start = 6.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFFDDDDDD))
                        .padding(12.dp, 6.dp)
                ) {
                    Text(text = "Favorites", textAlign = TextAlign.Center, fontWeight = FontWeight.SemiBold, color = Color.DarkGray)
                }
                Column(
                    modifier = Modifier
                        .padding(start = 6.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFFDDDDDD))
                        .padding(12.dp, 6.dp)
                ) {
                    Text(text = "Groups", textAlign = TextAlign.Center, fontWeight = FontWeight.SemiBold, color = Color.DarkGray)
                }
            }

            LazyColumn(
                modifier = Modifier.weight(1f) // This ensures LazyColumn takes up remaining space
            ) {
                items(chatList) {
                    ChatBox(
                        it,
                        Modifier
                            .fillMaxWidth()
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFfafafa))
                .drawBehind {
                    val strokeWidth = 1.dp.toPx()
                    val y = 0f
                    drawLine(
                        color = Color.LightGray,
                        start = Offset(0f, y),
                        end = Offset(size.width, y),
                        strokeWidth = strokeWidth
                    )
                }
                .padding(10.dp, 16.dp)
                .align(Alignment.BottomEnd)
        ) {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.whatsapp_icon_1),
                    contentDescription = "Chats",
                    modifier = Modifier
                        .size(36.dp)
                        .padding(4.dp)
                )
                Text(
                    text = "Chats",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
            }
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.whatsapp_icon_2),
                    contentDescription = "Updates",
                    modifier = Modifier
                        .size(36.dp)
                        .padding(4.dp)
                )
                Text(
                    text = "Updates",
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp
                )
            }
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.whatsapp_icon_3),
                    contentDescription = "Communities",
                    modifier = Modifier
                        .size(36.dp)
                        .padding(0.dp)
                )
                Text(
                    text = "Communities",
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp
                )
            }
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.whatsapp_icon_4),
                    contentDescription = "Calls",
                    modifier = Modifier
                        .size(36.dp)
                        .padding(4.dp)
                )
                Text(
                    text = "Calls",
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp
                )
            }
        }
    }
}

@Composable
fun ChatBox(chat: line_chat, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Button(
        onClick = { Toast.makeText(context, "${chat.name} Clicked", Toast.LENGTH_SHORT).show() },
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        contentPadding = PaddingValues(6.dp),
        shape = RectangleShape
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "Empty Profile",
                        modifier = Modifier.size(64.dp)
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(5f)
                        .padding(8.dp)
                ) {
                    Row {
                        Text(
                            text = chat.name,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = Color(0xFF010101),
                            modifier = Modifier.weight(1f)
                        )
                        Text(
                            text = chat.date,
                            fontSize = 14.sp,
                            color = Color.Gray,
                            textAlign = TextAlign.End,
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Row {
                        Text(
                            text = chat.chat,
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp,
                            color = Color(0xFF010101),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Q1Preview() {
    Q1View(dummy_data().get_data_line())
    //ChatBox()
}