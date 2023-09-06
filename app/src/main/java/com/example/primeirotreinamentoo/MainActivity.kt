package com.example.primeirotreinamentoo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.primeirotreinamentoo.data.Products
import com.example.primeirotreinamentoo.data.products
import com.example.primeirotreinamentoo.ui.theme.PrimeiroTreinamentooTheme
import java.text.NumberFormat
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrimeiroTreinamentooTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainApp()
                }
            }
        }
    }
}

@Composable
fun MainApp() {
    LazyColumn {
        items(products) {
            ProductList(
                product = it,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
            )
        }
    }
}

@Composable
fun ProductList(
    product: Products,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(
            bottomStart = 10.dp,
            topEnd = 10.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_small))
        ) {
            ProductInformation(
                productName = product.name,
                productPrice = product.price,
                productBrand = product.brand
            )
        }
    }
}

fun formatToCurrency(number: Float): String {
    val locale = Locale("pt", "BR")
    val format = NumberFormat.getCurrencyInstance(locale)
    return format.format(number)
}

@Composable
fun ProductInformation(
    modifier: Modifier = Modifier,
    @StringRes productName: Int,
    productPrice: Float,
    @StringRes productBrand: Int
) {
    Column(modifier = modifier) {
        Row {
            Text(
                text = stringResource(productName)
            )
            Text(text = " - ")
            Text(
                text = stringResource(productBrand)
            )
        }
        Text(
            text = formatToCurrency(productPrice)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TrainingPreview() {
    PrimeiroTreinamentooTheme {
        MainApp()
    }
}