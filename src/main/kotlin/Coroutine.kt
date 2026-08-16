package org.example

import kotlinx.coroutines.*

fun main() = runBlocking {
    val scope = CoroutineScope(Dispatchers.Default)

    val job = scope.launch {
        repeat(5) { i ->
            println("Coroutine is working: $i")
            delay(500L)
        }
    }

    delay(1300L) // รอสักครู่
    println("Cancelling scope...")
    scope.cancel() // ยกเลิก scope ทั้งหมด
    job.join() // รอให้ job จบการทำงาน
    println("Scope is cancelled.")
}