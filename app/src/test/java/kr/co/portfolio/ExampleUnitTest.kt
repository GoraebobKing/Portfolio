package kr.co.portfolio

import androidx.annotation.MainThread
import kotlinx.coroutines.*
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @MainThread
    @Test
    fun start(){

        runBlocking {
            val handler = CoroutineExceptionHandler { _, error ->
                println("코로나 Error : ${error.localizedMessage}")
            }

            GlobalScope.launch(Dispatchers.IO + handler) {

                launch {
                    println("코로나1")
                }

                val value = withContext(Dispatchers.Default) {
                    1 + 5
                }

                println("코로나 $value")
            }
        }

//        println("코로나2")
    }

}
