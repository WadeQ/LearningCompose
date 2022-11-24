package com.example.learningcompose.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.learningcompose.R
import com.example.learningcompose.presentation.AuthViewModel
import com.example.learningcompose.presentation.composables.destinations.HomeScreenDestination
import com.example.learningcompose.presentation.utils.OnLoginEvent
import com.example.learningcompose.presentation.utils.ResultWrapper
import com.example.learningcompose.ui.theme.DeepBlue
import com.example.learningcompose.ui.theme.LightGreen1
import com.example.learningcompose.ui.theme.LightGreen2
import com.example.learningcompose.ui.theme.LightGreen3
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Destination(start = true)
@Composable
fun LoginScreen(
    navigator: DestinationsNavigator
){
    val authViewModel  = viewModel<AuthViewModel>()
    val state = authViewModel.state
    val context = LocalContext.current

    LaunchedEffect(key1 = context){
       authViewModel.loginEvents.collect{ event ->
           when(event){
               is ResultWrapper.Success  -> navigator.navigate(HomeScreenDestination)
           }
       }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepBlue)
    ) {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

           Image(
               painter = painterResource(id = R.drawable.star),
               contentDescription = null,
               modifier = Modifier.size(150.dp)
           )

            Spacer(modifier = Modifier.padding(8.dp))

           OutlinedTextField(
               value = state.email,
               label = {
                   Text(
                       text = "Email",
                       color = LightGreen2
                   )
               },
               onValueChange = {
                   authViewModel.onLoginEvent(OnLoginEvent.OnEmailChanged(it))
               },
               isError = state.emailError != null,
               keyboardOptions = KeyboardOptions(
                   keyboardType = KeyboardType.Email
               ),
               singleLine = true,
               modifier = Modifier
                   .padding(start = 16.dp, end = 16.dp)
                   .fillMaxWidth(),
               colors = TextFieldDefaults.outlinedTextFieldColors(
                   unfocusedBorderColor = LightGreen3,
                   focusedBorderColor = LightGreen2,
                   focusedLabelColor = LightGreen1
               )
           )
            if (state.emailError != null){
                Text(
                    text = state.emailError,
                    color = MaterialTheme.colors.error,
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .align(Alignment.End)
                )
            }

            Spacer(modifier = Modifier.padding(8.dp))

            OutlinedTextField(
                value = state.password,
                label = {
                    Text(
                        text = "Password",
                        color = LightGreen2
                    )
                },
                onValueChange = {
                    authViewModel.onLoginEvent(OnLoginEvent.OnPasswordChanged(it))
                },
                isError = state.passwordError != null,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                visualTransformation = PasswordVisualTransformation(),
                singleLine = true,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = LightGreen3,
                    focusedBorderColor = LightGreen2,
                    focusedLabelColor = LightGreen1
                )
            )

            if (state.passwordError != null){
                Text(
                    text = state.passwordError,
                    color = MaterialTheme.colors.error,
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .align(Alignment.End)
                )
            }

            Spacer(modifier = Modifier.padding(8.dp))

            OutlinedTextField(
                value = state.confirmPassword,
                label = {
                    Text(
                        text = "Confirm Password",
                        color = LightGreen2
                    )
                },
                onValueChange = {
                    authViewModel.onLoginEvent(OnLoginEvent.OnConfirmPasswordChanged(it))
                },
                isError = state.confirmPasswordError != null,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                visualTransformation = PasswordVisualTransformation(),
                singleLine = true,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = LightGreen3,
                    focusedBorderColor = LightGreen2,
                    focusedLabelColor = LightGreen1
                )
            )

            if (state.confirmPasswordError != null){
                Text(
                    text = state.confirmPasswordError,
                    color = MaterialTheme.colors.error,
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .align(Alignment.End)
                )
            }

            Spacer(modifier = Modifier.padding(top = 16.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {

                Checkbox(
                    checked = state.acceptedTerms,
                    onCheckedChange = {
                        authViewModel.onLoginEvent(OnLoginEvent.OnTermsAccepted(it))
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = LightGreen3,
                        uncheckedColor = LightGreen2,
                        checkmarkColor = LightGreen3
                    )
                )

                Text(
                    text = "Accept Terms",
                    modifier = Modifier.padding(top = 16.dp),
                    color = LightGreen2
                )
            }

            if (state.termsError != null){
                Text(
                    text = state.termsError,
                    color = MaterialTheme.colors.error,
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .align(Alignment.Start)
                )
            }

            Spacer(modifier = Modifier.padding(8.dp))

            Button(
                onClick = {
                         authViewModel.onLoginEvent(OnLoginEvent.OnLoginButtonClicked)
                },
                colors = ButtonDefaults.buttonColors(LightGreen2),
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Login")
            }
        }
    }
}