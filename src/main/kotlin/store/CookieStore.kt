package store

import org.openqa.selenium.Cookie

object CookieStore {

    private var cookies = mutableMapOf<String, String>()

    fun getCookie(): String {
        return cookies.map { (k, v) -> "$k=$v" }.joinToString(";")
    }

    fun addCookie(cookies: List<Cookie>) {
        cookies.forEach{
            this.cookies[it.name] = it.value
            println("Cookie: $it")
        }
    }

    fun addCookie(cookies: List<String>) {
        cookies.forEach{
            val strings = it.split("=", " ")
            this.cookies[strings[0]] = strings[1]
        }
    }

}