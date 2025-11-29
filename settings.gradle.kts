pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        mavenCentral()

        // === [BARU] TAMBAHKAN INI AGAR VUFORIA TERBACA ===
        flatDir {
            dirs ("unityLibrary/libs")
        }
        // =================================================
    }
}

rootProject.name = "ExploreLamreh"
include(":app")

// 2. TAMBAHKAN DUA BARIS INI (Mendaftarkan Unity)
include(":unityLibrary")
project(":unityLibrary").projectDir = file("./unityLibrary")