package com.example.crownstackdemo

import com.example.crownstackdemo.data.api.ApiService
import com.example.crownstackdemo.data.repository.ISongsRepository
import com.example.crownstackdemo.data.repository.SongsRepository
import com.example.crownstackdemo.ui.songs.SongsViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val remoteModules = module {
    single {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
    }

    single(createOnStart = false) { get<Retrofit>().create(ApiService::class.java) }
}

val repositoryModules = module {
    single<ISongsRepository> { SongsRepository(get()) }
}

val viewModelModules = module {
    viewModel { SongsViewModel(get()) }
}

