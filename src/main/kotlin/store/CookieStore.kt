package store

object CookieStore {

    private var cookies = listOf<String>()

    fun getCookie(): String {
        return cookies.joinToString(";")
    }

    fun addCookie(cookies: List<String>) {
        this.cookies += cookies
        cookies.forEach { println("Cookie: $it") }
    }

}