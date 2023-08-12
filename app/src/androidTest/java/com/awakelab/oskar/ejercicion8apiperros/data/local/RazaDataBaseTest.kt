package com.awakelab.oskar.ejercicion8apiperros.data.local

import android.content.Context
import androidx.annotation.VisibleForTesting
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

/*
 //Test
    androidTestImplementation "androidx.arch.core:core-testing:2.2.0"
    androidTestImplementation "androidx.room:room-testing:2.5.2"
    androidTestImplementation 'androidx.test.ext:truth:1.5.0'

*/

class RazaDataBaseTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var breedsDao: RazaDao
    private lateinit var db: RazaDataBase

    @Before  //inicializar la ddbb
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, RazaDataBase::class.java).build()
        breedsDao = db.getRazaDao()
    }

    @After  //Cerrar lo inicializado
    fun tearDown() {
        db.close()
    }

    @Test
    fun insertBreeds_empty() = runBlocking {
        // Given
        val breedList = listOf<RazaEntity>()

        // When
        breedsDao.insertRaza(breedList)

        // Then A  comprueba que hay una lista y esta vacia. esto luego de haber insertado  bredList
        val it = breedsDao.getAllRazas().getOrAwaitValue()
        assertThat(it).isNotNull()
        assertThat(it).isEmpty()

        // Then B
        breedsDao.getAllRazas().observeForever {
            assertThat(it).isNotNull()  // assertNotEquals(it, null)
            assertThat(it).isEmpty()    // assertEquals(it.size, 0)
        }
    }

    @Test
    fun insertBreeds_happyCase_1element() = runBlocking {
        // Given
        val breedList = listOf(RazaEntity("breed1"))

        // When
        breedsDao.insertRaza(breedList)

        // Then   (assertThat = valida esto!!!!!
        breedsDao.getAllRazas().observeForever {
            assertThat(it).isNotNull()
            assertThat(it).isNotEmpty()
            assertThat(it).hasSize(1)
        }
    }

    @Test
    fun insertBreeds_happyCase_3elements() = runBlocking {
        // Given
        val breedList = listOf(RazaEntity("breed1"), RazaEntity("breed2"), RazaEntity("breed3"))

        // When
        breedsDao.insertRaza(breedList)

        // Then
        breedsDao.getAllRazas().observeForever {
            assertThat(it).isNotNull()
            assertThat(it).isNotEmpty()
            assertThat(it).hasSize(3)
        }
    }
}

//Se crea un afuncion de extension,
@VisibleForTesting(otherwise = VisibleForTesting.NONE)
fun <T> LiveData<T>.getOrAwaitValue(
    time: Long = 2,
    timeUnit: TimeUnit = TimeUnit.SECONDS,
    afterObserve: () -> Unit = {},
): T {
    var data: T? = null
    val latch = CountDownLatch(1)
    val observer = object : Observer<T> {
        override fun onChanged(value: T) {
            data = value
            latch.countDown()
            this@getOrAwaitValue.removeObserver(this)
        }
    }
    this.observeForever(observer)

    try {
        afterObserve.invoke()

        // Don't wait indefinitely if the LiveData is not set.
        if (!latch.await(time, timeUnit)) {
            throw TimeoutException("LiveData value was never set.")
        }

    } finally {
        this.removeObserver(observer)
    }

    @Suppress("UNCHECKED_CAST")
    return data as T

}
