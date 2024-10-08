package com.example.labweek4.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.labweek4.R
import com.example.labweek4.data.dummy_data
import com.example.labweek4.model.categories
import com.example.labweek4.model.products

@Composable
fun Q2View(categories: List<categories>, products: List<products>) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Tokopedia",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            }
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.End
            ) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "More"
                )
            }
        }
        Image(painter = painterResource(id = R.drawable.promo), contentDescription = "Promo", modifier = Modifier.fillMaxWidth())
        Text(
            text = "Categories",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        LazyRow(userScrollEnabled = true, horizontalArrangement = Arrangement.Center){
            items(categories){
                CategoryCard(category = it,
                    Modifier
                        .padding(12.dp)
                        .fillMaxWidth()
                )

            }
        }
        Text(
            text = "Products",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2)
        ){
            items(products){
                ProductCard(it,
                    Modifier
                        .padding(12.dp)
                        .fillMaxWidth()
                )
            }
        }

    }
}

@Composable
fun CategoryCard(category: categories, modifier: Modifier = Modifier){
    Card (modifier = modifier, elevation = CardDefaults.cardElevation(10.dp), shape = RectangleShape, colors = CardDefaults.cardColors(Color.White)){
        Column (
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
                Image(painter = painterResource(id = category.image_path), contentDescription = "Category Image", modifier = Modifier.size(120.dp))
                Text(text = category.category_name, textAlign = TextAlign.Center, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text(text = "${category.number_of_items} Products", textAlign = TextAlign.Center)

        }
    }
}

@Composable
fun ProductCard(product: products, modifier: Modifier = Modifier){
    Card (modifier = modifier, elevation = CardDefaults.cardElevation(10.dp), shape = RectangleShape, colors = CardDefaults.cardColors(Color.White)){
        Column (
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Image(painter = painterResource(id = product.image_path), contentDescription = "Category Image", modifier = Modifier.size(150.dp))
            Text(text = product.product_name, fontSize = 18.sp, fontWeight = FontWeight.Bold, maxLines = 1, overflow = TextOverflow.Ellipsis)
            Text(text = "Rp. ${product.price}")
            Text(text = "Kota ${product.location}")
            Text(text = "${product.sold} Sold")

        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Q2Preview() {
    Q2View(dummy_data().get_data_tokopedia_category(), dummy_data().get_data_tokopedia_product())
}