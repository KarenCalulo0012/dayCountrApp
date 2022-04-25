package com.appscals.daycountr.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appscals.daycountr.R
import com.appscals.daycountr.data.eventList
import com.appscals.daycountr.model.Events

@Composable
fun EventScreen(scrollState: ScrollState) {
    val searchText = remember { mutableStateOf(TextFieldValue()) }
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    MaterialTheme.colors.secondary
                )
                .padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
        ) {
            Box(
                modifier = Modifier
                    .requiredHeight(55.dp)
                    .background(Color.White, shape = RoundedCornerShape(30.dp))
            ) {
                TextField(
                    value = searchText.value,
                    onValueChange = { searchText.value = it },
                    placeholder = {
                        Text(
                            text = "Search",
                            color = Color.Gray,
                            modifier = Modifier.wrapContentHeight(
                                Alignment.CenterVertically,
                            )
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Rounded.Search,
                            contentDescription = "Search",
                            tint = Color.Gray,
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Gray,
                        disabledTextColor = Color.Transparent,
                        backgroundColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(30.dp),
                )
            }
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .scrollable(scrollState, Orientation.Vertical)
        ) {
            items(eventList) { data ->
                EventsItems(eventData = data)
            }
        }
    }
}

@Composable
fun EventsItems(eventData: Events) {
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = 8.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "26 Days Left",
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.align(Alignment.End),
            )
        }
        Spacer(modifier = Modifier.padding(start = 50.dp))
        Row(
            modifier = Modifier
                .padding(start = 16.dp, top = 50.dp, bottom = 16.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "",
                modifier = Modifier.size(50.dp)
            )
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Text(text = eventData.title, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Text(text = eventData.date, fontWeight = FontWeight.Light, fontSize = 14.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
//    EventsItems()
}