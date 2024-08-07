package classesObjectInterfaces.propertiesInInterfaces

private interface User {
    val email: String
    val nickname: String
        get() = email.getSubstring("@")
}

private class PrivateUser(override val email: String) : User

private class SubcribedUser(override val email: String) : User {

    override val nickname: String
        get() = email.getSubstring("@")
}

private class FacebookUser(override val email: String) : User {

    override val nickname: String = email.getSubstring("@")
}

private fun String.getSubstring(delimiter: String): String {
    println("InvokeGetSubstring")
    return substringBefore(delimiter)
}

fun main() {
    println("CheckPrivateUser")
    val privateUser = PrivateUser("PrivateUser@mail.com")
    privateUser.nickname
    privateUser.nickname
    //Вызовется метод getSubstring каждый раз при получении значения
    //InvokeGetSubstring
    //InvokeGetSubstring
    println("CheckSubcribedUser")
    val subcribedUser = SubcribedUser("SubcribedUser@mail.com")
    subcribedUser.nickname
    subcribedUser.nickname
    //Вызовется метод getSubstring каждый раз при получении значения
    //InvokeGetSubstring
    //InvokeGetSubstring

    println("CheckFacebookUser")
    val facebookdUser = FacebookUser("FacebookUser@mail.com")
    //facebookdUser.nickname
    //facebookdUser.nickname
    //Вызовется метод getSubstring только 1 раз и сохранит его в backing field
    //InvokeGetSubstring

}

