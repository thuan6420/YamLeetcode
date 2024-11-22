import org.jetbrains.kotlin.konan.properties.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.thuan6420.medium.practice"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.thuan6420.medium.practice"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    val localProps = Properties()
    val localPropertiesFile = File(rootProject.rootDir,"api.properties")
    if (localPropertiesFile.exists() && localPropertiesFile.isFile) {
        localPropertiesFile.inputStream().use {
            localProps.load(it)
        }
    }

    externalNativeBuild {
        cmake {
            path = File("cpp","CMakeLists.txt")
            version = "3.31.0"
        }
    }
    android.ndkVersion = "28.0.12433566"

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "API_KEY", localProps.getProperty("API_KEY_PROD"))
        }
        debug {
            buildConfigField("String", "API_KEY", localProps.getProperty("API_KEY_DEV"))
        }
    }

    buildFeatures {
        buildConfig = true
        resValues = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}