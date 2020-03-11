package dpo

class PostEvent (
    val id: Long,
    val author: String,
    val content: String,
    val created: String,
    var likedByMe: Boolean,
    var likedCount: Int,
    var shared: Boolean,
    var sharedCount: Int,
    var comments: Boolean,
    var commentsCount: Int,
    var address: String,
    var lat: Double,
    var lng: Double
)