package logic.entities

data class Contract(
        val id: Long,
        val codeAndCount: Map<String, Int> // code and count
) {
    fun get(code: String): Int? = codeAndCount.get(code)
}