package com.appscals.daycountr.presentation.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.appscals.daycountr.R
import com.appscals.daycountr.ui.theme.blueSecondary
import com.appscals.daycountr.ui.theme.yellowPrimary

@Composable
fun LoginScreen(navController: NavController) {
    val emailState = remember { mutableStateOf(TextFieldValue()) }
    val passState = remember { mutableStateOf(TextFieldValue()) }
    var showPassword by remember { mutableStateOf(false) }
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        val (cardBg, textBoxLayout, icon) = createRefs()
        Card(
            modifier = Modifier
                .fillMaxSize()
                .constrainAs(cardBg) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            backgroundColor = yellowPrimary,
            shape = RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "DAYS COUNTR",
                    color = MaterialTheme.colors.onPrimary,
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 50.dp),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Missed Events No More",
                    color = blueSecondary,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(bottom = 180.dp)
                )
            }
        }
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_undraw_calendar_re_ki49),
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
                .offset(x = 0.dp, y = (-160).dp)
                .constrainAs(icon) {
                    top.linkTo(cardBg.bottom, margin = 16.dp)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                }
        )
        Column(
            modifier = Modifier
                .constrainAs(textBoxLayout) {
                    top.linkTo(cardBg.bottom, margin = 16.dp)
                    start.linkTo(cardBg.start)
                    end.linkTo(cardBg.end)
                    bottom.linkTo(parent.bottom)
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = emailState.value,
                onValueChange = {
                    emailState.value = it
                },
                label = { Text("Email Address") },
                singleLine = true,
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 24.dp)
            )
            OutlinedTextField(
                value = passState.value,
                visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = {
                        showPassword = !showPassword
                    }) {
                        Icon(
                            imageVector = if (showPassword)
                                Icons.Filled.Visibility
                            else
                                Icons.Filled.VisibilityOff, ""
                        )
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                onValueChange = {
                    passState.value = it
                },
                label = { Text("Password") },
                singleLine = true,
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 24.dp)
            )
            Button(
                onClick = {
                    Log.e("Email&Pass", "Email: $emailState Pass: $passState")
                    navController.navigate("dashboardScreen")
                },
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
                    .requiredHeight(47.dp)
            ) {
                Text(text = "LOGIN", color = Color.White)
            }
            Text(text =
            buildAnnotatedString {
                append("Don’t have an Account? ")
                append(
                    AnnotatedString("Register Here", spanStyle = SpanStyle(yellowPrimary))
                )
            }, modifier = Modifier
                .padding(bottom = 16.dp)
                .clickable { Log.e("Test CLick", "TRUE") }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(rememberNavController())
}
