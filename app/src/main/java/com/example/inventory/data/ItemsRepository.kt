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
 * ItemsRepository adalah inteface repositori yang mendefinisikan operasi data Item
 * untuk insert, update, delete, dan get data Item.
 */
interface ItemsRepository {
    /**
     * fungsi untuk mendapatkan semua data item
     */
    fun getAllItemsStream(): Flow<List<Item>>

    /**
     * fungsi untuk mendapatkan data item berdasarkan id
     */
    fun getItemStream(id: Int): Flow<Item?>

    /**
     * fungsi untuk menambah sebuah data
     */
    suspend fun insertItem(item: Item)

    /**
     * fungsi untuk menghapus sebuah data
     */
    suspend fun deleteItem(item: Item)

    /**
     * fungsi untuk merubah sebuah data
     */
    suspend fun updateItem(item: Item)
}

