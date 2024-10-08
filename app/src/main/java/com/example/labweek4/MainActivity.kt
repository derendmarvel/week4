package com.example.labweek4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.labweek4.data.DataSource
import com.example.labweek4.data.dummy_data
import com.example.labweek4.ui.theme.LabWeek4Theme
import com.example.labweek4.ui.view.Q1View
import com.example.labweek4.ui.view.Q2View
import com.example.labweek4.ui.view.Q3View
import com.example.labweek4.ui.view.Q4View

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LabWeek4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Q1View(dummy_data().get_data_line())
                    //Q2View(dummy_data().get_data_tokopedia_category(), dummy_data().get_data_tokopedia_product())
                    Q3View(DataSource().loadStory(), DataSource().loadFeed())
                    //Q4View(DataSource().loadExplore())
                }
            }
        }
    }
}
