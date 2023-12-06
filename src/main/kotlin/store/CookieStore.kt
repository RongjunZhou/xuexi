package store

object CookieStore {

    private var cookies = listOf<String>()

    fun getCookie(): String {
        return ""
    }

    fun addCookie(cookie: String) {

    }

    fun setCookie(cookies: List<String>) {
        this.cookies = cookies
    }
}