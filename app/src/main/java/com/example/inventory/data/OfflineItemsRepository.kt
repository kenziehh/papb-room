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

import kotlinx.coroutines.flow.Flow

/**
 * Class `OfflineItemsRepository` mengimplement `ItemsRepository` yang memanfaatkan
 * `ItemDao` sebagai data source untuk operasi CRUD. Repository ini berfungsi sebagai
 * lapisan perantara yang mengelola akses ke database Room.
 */

class OfflineItemsRepository(private val itemDao: ItemDao) : ItemsRepository {
    /**
     * Fungsi untuk mengambil semua item sebagai aliran `Flow` dengan mengakses `getAllItems` dari `ItemDao`.
     */
    override fun getAllItemsStream(): Flow<List<Item>> = itemDao.getAllItems()

    /**
     * Fungsi untuk mengambil satu item berdasarkan id sebagai `Flow` dengan mengakses `getItem` dari `ItemDao`.
     */
    override fun getItemStream(id: Int): Flow<Item?> = itemDao.getItem(id)

    /**
     * Fungsi untuk menambah item baru ke database menggunakan `insert` dari `ItemDao`.
     */
    override suspend fun insertItem(item: Item) = itemDao.insert(item)

    /**
     * Fungsi untuk menghapus item dari database menggunakan `delete` dari `ItemDao`.
     */
    override suspend fun deleteItem(item: Item) = itemDao.delete(item)

    /**
     * Fungsi untuk merubah data item yang ada di database menggunakan `update` dari `ItemDao`.
     */
    override suspend fun updateItem(item: Item) = itemDao.update(item)
}
