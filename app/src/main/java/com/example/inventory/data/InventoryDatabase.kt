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
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * class abstract `InventoryDatabase` mengimplement `RoomDatabase` yang digunakan
 * untuk mengelola akses data melalui Room. Class `InventoryDatabase` menyediakan database
 * yang terstruktur dan persistent untuk menyimpan data inventory.
 */

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class InventoryDatabase : RoomDatabase() {

    /**
     * Method abstract `itemDao` yang mengembalikan instance `ItemDao` yang berisi
     * metode untuk operasi database create,read,update,delete pada tabel `items`.
     */

    abstract fun itemDao(): ItemDao

    companion object {

        /**
         * Variabel Instance digunakan untuk menyimpan instance database yang telah dibuat.
         * Variabel ini dilengkapi anotasi `@Volatile` untuk memastikan perubahan segera terlihat
         * pada thread lain.
         */

        @Volatile
        private var Instance: InventoryDatabase? = null

        /**
         * Method `getDatabase` mengembalikan instance singleton dari `InventoryDatabase`.
         * Jika instance belum ada, akan dibuat baru melalui `Room.databaseBuilder`.
         * Method ini dilengkapi `synchronized` untuk memastikan instance hanya dibuat satu kali
         * walaupun dipanggil dari beberapa thread.
         */

        fun getDatabase(context: Context): InventoryDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, InventoryDatabase::class.java, "item_database")
                    .build().also { Instance = it }
            }
        }
    }
}

