package dpo

class Post (
    val id: Long,
    val author: String,
    val content: String,
    val created: String,
    var likedByMe: Boolean = false,
    var likedCount: Int,
    var shared: Boolean = false,
    var sharedCount: Int,
    var comments: Boolean = false,
    var commentsCount: Int
)