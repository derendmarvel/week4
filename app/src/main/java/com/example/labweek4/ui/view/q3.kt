package com.example.labweek4.ui.view

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.labweek4.data.DataSource
import com.example.labweek4.model.Story
import com.example.labweek4.R
import com.example.labweek4.model.Feed
import com.example.labweek4.model.Suggestion

@Composable
fun Q3View(stories: List<Story>, feeds: List<Feed>) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFFfafafa))
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                LazyColumn {
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp, 16.dp, 16.dp, 12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(modifier = Modifier.weight(6f)) {
                                Image(
                                    painter = painterResource(id = R.drawable.logo_dark),
                                    contentDescription = "Instagram Logo",
                                    colorFilter = ColorFilter.tint(Color(0xFF111111))
                                )
                            }
                            Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.End) {
                                Image(
                                    painter = painterResource(id = R.drawable.like),
                                    contentDescription = "Like Icon",
                                )
                            }
                            Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.End) {
                                Image(
                                    painter = painterResource(id = R.drawable.dm),
                                    contentDescription = "DM Icon",
                                )
                            }
                        }
                        Row {
                            LazyRow(
                                modifier = Modifier.padding(0.dp),
                                userScrollEnabled = true,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                items(stories) {
                                    StoryCard(
                                        it,
                                        Modifier
                                            .padding(0.dp)
                                    )
                                }
                            }
                        }
                    }
                    items(feeds) {
                        PostCard(it, Modifier.padding(0.dp))
                    }
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
                .padding(16.dp)
                .align(Alignment.BottomEnd)
        ) {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = "Home",
                )
            }
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "Search",
                )
            }
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.post),
                    contentDescription = "Post",
                )
            }
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.reels),
                    contentDescription = "Reels",
                )
            }
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.account),
                    contentDescription = "Account",
                )
            }
        }
    }
}


@Composable
fun StoryCard(igStory: Story, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Button(
        onClick = {
            Toast.makeText(context, "${igStory.username} Story Clicked", Toast.LENGTH_SHORT).show()
        },
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        shape = RectangleShape,
        contentPadding = PaddingValues(6.dp),
        modifier = modifier
    ) {
        Card(colors = CardDefaults.cardColors(Color.Transparent), modifier = modifier) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Image(
                        painter = painterResource(id = R.drawable.story),
                        contentDescription = "Story Border",
                        modifier = Modifier
                            .height(100.dp)
                            .width(100.dp)
                    )
                    val context = LocalContext.current
                    val profPic = igStory.getProfilePicture(igStory.profilePicture, context)

                    Image(
                        painter = painterResource(id = profPic),
                        contentDescription = "Profile",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(85.dp)
                            .width(85.dp)
                            .clip(CircleShape)
                    )
                }
                Text(
                    text = igStory.username,
                    color = Color(0xFF111111),
                    modifier = Modifier.padding(4.dp)
                )
            }
        }
    }
}

@Composable
fun PostCard(feed: Feed, modifier: Modifier = Modifier) {
    Card(colors = CardDefaults.cardColors(Color.Transparent), modifier = modifier) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 0.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val context = LocalContext.current
                val profPic = feed.getPicture(feed.profilePicture, context)
                Column(modifier = Modifier.weight(1f)) {
                    Image(
                        painter = painterResource(id = profPic),
                        contentDescription = "User Profile", contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(80.dp)
                            .aspectRatio(1f)
                            .clip(CircleShape)
                    )
                }
                Column(modifier = Modifier.weight(6f)) {
                    Row() {
                        Text(
                            text = feed.username,
                            color = Color(0xFF111111),
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(12.dp, 1.dp)
                        )
                    }
                    Row(){
                        Text(
                            text = "${feed.convertDate(feed.date)}",
                            color = Color(0xFF222222),
                            fontSize = 14.sp,
                            modifier = Modifier.padding(12.dp, 1.dp)
                        )
                    }
                }
                Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.End) {
                    Icon(
                        imageVector = Icons.Filled.MoreVert,
                        contentDescription = "More",
                    )
                }
            }
            val context = LocalContext.current
            val content = feed.getPicture(feed.content, context)
            Image(
                painter = painterResource(id = content),
                contentDescription = "Content Post",
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp, 2.dp, 4.dp, 2.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    var isLiked by rememberSaveable { mutableStateOf(feed.liked) }
                    Button(
                        onClick = { isLiked = !isLiked },
                        shape = CircleShape,
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Image(
                            painter = painterResource(id = if (isLiked) R.drawable.liked else R.drawable.like),
                            contentDescription = "Like Button",
                        )
                        Text(
                            text = "${feed.likes}",
                            color = Color(0xFF111111),
                            fontSize = 16.sp,
                            modifier = Modifier.padding(4.dp, 0.dp, 0.dp, 0.dp)
                        )
                    }
                }
                Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally) {
                    val context = LocalContext.current
                    Image(
                        painter = painterResource(id = R.drawable.comment),
                        contentDescription = "Comment Button",
                        modifier = Modifier.padding(0.dp),
                        colorFilter = ColorFilter.tint(Color(0xFF111111))
                    )
                }
                Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = R.drawable.messanger),
                        contentDescription = "Share Button",
                        modifier = Modifier.padding(0.dp),
                        colorFilter = ColorFilter.tint(Color(0xFF111111))
                    )
                }
                Column(modifier = Modifier.weight(5f), horizontalAlignment = Alignment.End) {
                    var isSaved by rememberSaveable { mutableStateOf(feed.saved) }
                    Button(
                        onClick = { isSaved = !isSaved },
                        shape = CircleShape,
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Image(
                            painter = painterResource(id = if (isSaved) R.drawable.saved_light else R.drawable.save),
                            contentDescription = "Save Button",
                            colorFilter = ColorFilter.tint(Color.Black)
                        )
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 0.dp)
            ) {
                val caption = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("${feed.username} ")
                    }
                    append("${feed.caption}")
                }

                var clickedCaption by rememberSaveable { mutableStateOf(false) }

                Button(
                    onClick = { clickedCaption = !clickedCaption },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Color.Transparent),
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    if (clickedCaption) {
                        Text(text = caption, color = Color(0xFF222222), fontSize = 14.sp,
                            fontWeight = FontWeight.Normal)
                    } else {
                        Text(
                            text = caption,
                            color = Color(0xFF222222),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val context = LocalContext.current
                val profPic = feed.getPicture(feed.profilePicture, context)
                Column(modifier = Modifier.weight(1f)) {
                    Image(
                        painter = painterResource(id = profPic),
                        contentDescription = "User Profile", contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(40.dp)
                            .aspectRatio(1f)
                            .clip(CircleShape)
                    )
                }
                Column(modifier = Modifier.weight(7f)) {
                    Row() {
                        Text(
                            text = "Add a comment...",
                            color = Color.Gray,
                            fontSize = 14.sp,
                            modifier = Modifier.padding(8.dp, 1.dp)
                        )
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 0.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "See translation",
                    color = Color.Black,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Composable
fun SuggestionCard(suggestion: Suggestion, modifier: Modifier = Modifier) {

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Q3Preview() {
    Q3View(DataSource().loadStory(), DataSource().loadFeed())
}