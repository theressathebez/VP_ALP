import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.vp_alp.R
import com.example.vp_alp.enums.listScreen
import com.example.vp_alp.ui.theme.VP_ALPTheme
import com.example.vp_alp.view.BottomNavigationBar
import com.example.vp_alp.viewmodel.StudyViewModel

@Composable
fun StudyScroll(
    viewModel: StudyViewModel = viewModel(factory = StudyViewModel.Factory),
    navController: NavController,
) {
    val categories by viewModel.categories
    val topics by viewModel.topics

    var selectedCategoryId by remember { mutableStateOf(viewModel.categoryId) }

    LaunchedEffect(Unit) {
        viewModel.fetchCategories()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .background(Color.White)
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            item {
                StudyView()
            }

            item {
                LazyRow(modifier = Modifier.padding(vertical = 16.dp)) {
                    items(categories.data) { category ->
                        CatList(
                            categoryName = category.name,
                            isSelected = category.id == selectedCategoryId,
                            onClick = {
                                selectedCategoryId = category.id
                                viewModel.fetchTopics(category.id)
                            }
                        )

                        Spacer(modifier = Modifier.width(5.dp))
                    }
                }

            }

            items(topics.data) { topic ->
                Log.d("StudyScroll", "Topic: ${topic.topic_name}, ID: ${topic.id}")

                TopicList(
                    topic_name = topic.topic_name,
                    onClick = {
                        navController.navigate("${listScreen.Topic.name}/${topic.id}")
                    }
                )

                Spacer(modifier = Modifier.height(14.dp))
            }
        }

        BottomNavigationBar(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(bottom = 16.dp)
                .navigationBarsPadding(),
            currentScreen = "study",
            navController = navController
        )
    }
}

@Composable
fun CatList(
    categoryName: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(width = 100.dp, height = 40.dp)
            .background(
                color = if (isSelected) Color(0xFFFFA726) else Color.LightGray,
                shape = RoundedCornerShape(30.dp)
            )
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = categoryName,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

@Composable
fun TopicList(
    topic_name: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .background(
                color = Color(0xFFF7ECFF),
                shape = RoundedCornerShape(15.dp)
            )
            .border(
                border = BorderStroke(1.dp, Color(0xFFA35FED)),
                shape = RoundedCornerShape(18.dp)
            )
            .padding(16.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = topic_name,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Image(
                painter = painterResource(id = R.drawable.image_removebg_preview__1_),
                contentDescription = "Lesson Image",
                modifier = Modifier
                    .size(120.dp)
            )
        }
    }
}

@Composable
fun StudyView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(vertical = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = R.drawable.group_410),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(75.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    "Good Afternoon!",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray
                )
                Text("Leon Smith", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }

            Box(
                modifier = Modifier
                    .background(
                        color = Color(0xFFFFA726),
                        shape = RoundedCornerShape(30.dp)
                    )
                    .padding(horizontal = 12.dp, vertical = 6.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Beginner",
                        fontSize = 16.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowDown,
                        contentDescription = "Dropdown Icon",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFFDCEEFF),
                    shape = RoundedCornerShape(15.dp),
                )
                .border(
                    border = BorderStroke(1.dp, Color(0xFFBDCBFF)),
                    shape = RoundedCornerShape(15.dp)
                )

                .padding(18.dp)
        ) {
            // Text Section
            Column(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(end = 90.dp)
            ) {
                Text(
                    text = "Today's lesson",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray
                )
                Text(
                    text = "\"Every journey starts with hello!\"",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Start Button
                Box(
                    modifier = Modifier
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(30.dp)
                        )
                        .padding(horizontal = 12.dp, vertical = 6.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Start",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF2196F3) // Blue
                        )
                        Icon(
                            imageVector = Icons.Filled.PlayArrow,
                            contentDescription = "Start Icon",
                            tint = Color(0xFF2196F3),
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }

            // Lesson Image
            Image(
                painter = painterResource(id = R.drawable.frame),
                contentDescription = "Lesson Image",
                modifier = Modifier
                    .size(120.dp)
                    .align(Alignment.BottomEnd)
                    .offset(y = 18.dp) // Push the image slightly down to "stick" to the box
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFFF7ECFF),
                    shape = RoundedCornerShape(15.dp)
                )
                .border(
                    border = BorderStroke(1.dp, Color(0xFFA35FED)),
                    shape = RoundedCornerShape(15.dp)
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                Text(
                    text = "Pelajaran terakhir:",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray
                )
                Text(
                    text = "Menyapa",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(8.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .background(
                            color = Color(0xFFDCEEFF),
                            shape = RoundedCornerShape(4.dp)
                        )
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .fillMaxHeight()
                            .background(
                                color = Color(0xFFA35FEC), // Blue Progress
                                shape = RoundedCornerShape(4.dp)
                            )
                    )
                }
            }

            Box(
                modifier = Modifier
                    .padding(end = 16.dp)
                    .background(
                        color = Color(0xFFA35FEC),
                        shape = RoundedCornerShape(30.dp)
                    )
                    .padding(horizontal = 12.dp, vertical = 4.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Lanjutkan",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier

                )
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun StudyViewPreview() {
    VP_ALPTheme {
        VP_ALPTheme {

        }
    }
}