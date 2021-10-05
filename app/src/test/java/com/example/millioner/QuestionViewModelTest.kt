package com.example.millioner

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.*
import org.junit.Test
import org.junit.Assert.*
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import java.io.FileReader

class QuestionViewModelTest {
    val application: Application = Application()
    val testCoroutineRule = TestCoroutineRule()

    @Test
    fun fetchingJsonCorrect() {
        val viewModel = QuestionViewModel(application)
        testCoroutineRule.runBlockingTest {
            assertEquals(
                "{\"a1\":\"a\",\"a2\":\"c\",\"a3\":\"b\",\"a4\":\"d\",\"aa\":\"a\",\"id\":0,\"desc\":\"who1?\"}",
                viewModel.getResponse(1)
            )
            assertEquals("", viewModel.getResponse(0))
            assertEquals(
                "{\"a1\":\"a\",\"a2\":\"c\",\"a3\":\"b\",\"a4\":\"d\",\"aa\":\"a\",\"id\":0,\"desc\":\"who2?\"}",
                viewModel.getResponse(2)
            )
            assertEquals("", viewModel.getResponse(10))
            assertEquals(
                "{\"a1\":\"a\",\"a2\":\"c\",\"a3\":\"b\",\"a4\":\"d\",\"aa\":\"a\",\"id\":0,\"desc\":\"who3?\"}",
                viewModel.getResponse(3)
            )
            assertEquals("", viewModel.getResponse(20))
            assertEquals(
                "{\"a1\":\"a\",\"a2\":\"c\",\"a3\":\"b\",\"a4\":\"d\",\"aa\":\"a\",\"id\":0,\"desc\":\"who4?\"}",
                viewModel.getResponse(4)
            )
            assertEquals("", viewModel.getResponse(300))
        }
    }
}