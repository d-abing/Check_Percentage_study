plugins {
    id ("com.android.library")
    id ("kotlin-android")
    id ("kotlin-kapt")
    id ("dagger.hilt.android.plugin")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.domain"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    implementation (KTX.CORE)
    implementation (AndroidX.APP_COMPAT)
    implementation (Google.MATERIAL)
    testImplementation (TestTool.JUNIT)
    androidTestImplementation (TestTool.ANDROID_X_JUNIT)
    androidTestImplementation (TestTool.ANDROID_X_ESPRESSO)
    implementation (Firebase.FIREBASE_DATABASE_KTX)
    implementation (Firebase.FIREBASE_FIRESTORE_KTX)

    // retrofit
    implementation (Retrofit.RETROFIT)
    implementation (Retrofit.CONVERTER_GSON)
    implementation (Retrofit.CONVERTER_JAXB)

    // okHttp
    implementation (OkHttp.OKHTTP)
    implementation (OkHttp.LOGGING_INTERCEPTOR)

    // dagger hilt
    implementation (DaggerHilt.DAGGER_HILT)
    kapt (DaggerHilt.DAGGER_HILT_COMPILER)
    kapt (DaggerHilt.DAGGER_HILT_ANDROIDX_COMPILER)
}