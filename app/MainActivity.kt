/*  imports to be added here   */

/*      Updated code with MVVM applied       */


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: CounterViewModel = viewModel()                 //  import androidx.lifecycle.viewmodel.compose.viewModel , this viewModel work only if you import this
                                                                          //  This line gets an instance of CounterViewModel scoped to the current Composable's lifecycle,
                                                                          //  so you can access and use its data and logic (like state) inside the Composable.
                                                                          //  It also ensures the ViewModel survives recompositions and configuration changes.
                                                                          //  as no change/resetting of "Count:" on screen rotation
            CounterMVVM_learnTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CounterApp(viewModel)
                }
            }
        }
    }
}


@Composable
fun CounterApp( viewModel: CounterViewModel ){

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            "Count: ${viewModel.count.value}",
            fontSize = 25.sp,                                                // sp = scaled pixels
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Button({ viewModel.increment() }) {
                Text("Increment")
            }
            Spacer(Modifier.padding(20.dp))

            Button({ viewModel.decrement() }) {
                Text("Decrement")
            }
        }
    }
}
