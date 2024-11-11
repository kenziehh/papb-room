/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.inventory.data

import android.content.Context

/**
 * AppContainer berfungsi sebagai kontainer untuk Dependency Injection yang berfungsi untuk
 * mengelola dan menggunakan objek-objek secara efisien, terutama saat ada dependensi.
 * pada berbagai kelas
 */

interface AppContainer {
    val itemsRepository: ItemsRepository
}

/**
 * AppDataContainer mengimplement `AppContainer` yang menyediakan
 * instance `ItemsRepository`. Pada class ini menyediakan `OfflineItemsRepository` yang
 * digunakan sebagai repository utama untuk pengelolaan data aplikasi inventory ini.
 */

class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * variabel `itemsRepository` mengoverride `ItemsRepository` secara lazy
     * sehingga instance `OfflineItemsRepository` hanya dibuat ketika dibutuhkan.
     */
    override val itemsRepository: ItemsRepository by lazy {
        OfflineItemsRepository(InventoryDatabase.getDatabase(context).itemDao())
    }
}
