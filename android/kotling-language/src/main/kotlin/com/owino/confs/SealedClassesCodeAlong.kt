sealed class Result {
    class Success(val items: List<String>) : Result()
    class Failure(val error: Throwable) : Result()
}

class API(val result: Result) {
    fun handleResult() {
        when (result) {
            is Result.Success -> handleSuccess(result.items)
            is Result.Failure -> handleFailure(result.error)
            else -> {
                throw java.lang.AssertionError("Failed to to handle unknown result")
            }
        }
    }

    fun handleFailure(error: Throwable) {
        println("API Error: cause ${error.cause} message ==> ${error.message}")
    }

    fun handleSuccess(items: List<String>) {
        for (item in items) {
            println("API Result: $item")
        }
    }
}

fun main(){
    val successApi = API(Result.Success(listOf("Apples🍎","Oranges🍊","Mangoes🥭")))
    successApi.handleResult()

    val failedApi = API(Result.Failure(Throwable("404 Not Found")))
    failedApi.handleResult()
}