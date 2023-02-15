package com.aldikitta.serverdrivenuisimplified.di

import com.aldikitta.serverdrivenuisimplified.core.commons.NetworkConstants
import com.aldikitta.serverdrivenuisimplified.core.data.repository.CustomUIRepository
import com.aldikitta.serverdrivenuisimplified.core.data.repository.CustomUIRepositoryImpl
import com.aldikitta.serverdrivenuisimplified.core.remote.NetworkApi
import com.aldikitta.serverdrivenuisimplified.domain.usecase.GetCustomUIUseCase
import com.aldikitta.serverdrivenuisimplified.domain.usecase.GetCustomUIUseCaseImpl
import com.aldikitta.serverdrivenuisimplified.presentation.CustomUIViewModel
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single<CustomUIRepository> { CustomUIRepositoryImpl(get()) }
    single<GetCustomUIUseCase> { GetCustomUIUseCaseImpl(get()) }
    viewModel { CustomUIViewModel(get()) }
//    single<Retrofit> {
//        retrofit
//    }
//
//    single<NetworkApi> {
//        get<Retrofit>().create(NetworkApi::class.java)
//    }
    single {
        providesRetrofit()
    }
    factory { providesNetworkRequestApi(get()) }
}

//val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
//    level = HttpLoggingInterceptor.Level.BODY
//}
//
//val okHttpClient = OkHttpClient.Builder()
//    .addInterceptor(httpLoggingInterceptor)
//    .build()
//
//private val json = Json {
//    ignoreUnknownKeys = true
//    coerceInputValues = true
//}
//
//@OptIn(ExperimentalSerializationApi::class)
//val retrofit = Retrofit.Builder()
//    .baseUrl(NetworkConstants.BASE_URL)
//    .client(okHttpClient)
//    .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
//    .build()
//
fun providesRetrofit(): Retrofit {
    val contentType = "application/json".toMediaType()
    return Retrofit.Builder()
        .baseUrl(NetworkConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun providesNetworkRequestApi(retrofit: Retrofit): NetworkApi {
    return retrofit.create(NetworkApi::class.java)
}