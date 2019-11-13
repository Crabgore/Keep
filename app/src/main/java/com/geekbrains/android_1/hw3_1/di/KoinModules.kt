package com.geekbrains.android_1.hw3_1.di

import com.geekbrains.android_1.hw3_1.data.NotesRepository
import com.geekbrains.android_1.hw3_1.data.provider.FireStoreProvider
import com.geekbrains.android_1.hw3_1.data.provider.RemoteDataProvider
import com.geekbrains.android_1.hw3_1.ui.main.MainViewModel
import com.geekbrains.android_1.hw3_1.ui.note.NoteViewModel
import com.geekbrains.android_1.hw3_1.ui.splash.SplashViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val appModule = module {
    single { FirebaseAuth.getInstance() }
    single { FirebaseFirestore.getInstance() }
    single<RemoteDataProvider> { FireStoreProvider(get(), get()) }
    single { NotesRepository(get()) }
}

val splashModule = module {
    viewModel { SplashViewModel(get()) }
}

val mainModule = module {
    viewModel { MainViewModel(get()) }
}

val noteModule = module {
    viewModel { NoteViewModel(get()) }
}