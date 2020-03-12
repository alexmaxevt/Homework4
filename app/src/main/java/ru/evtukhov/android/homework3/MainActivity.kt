package ru.evtukhov.android.homework3

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ru.evtukhov.android.homework3.dpo.Post
import ru.evtukhov.android.homework3.dpo.PostEvent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val post = Post(
        1,
        "Netology",
        "First post in our network!",
        "20 august 2019",
        false,
        0,
        false,
        2,
        false,
        8
    )

    private val postEvent = PostEvent(
        2,
        "Netology",
        "First post in our network!",
        "20 august 2019",
        false,
        25,
        false,
        2,
        false,
        8,
        "this is address",
        55.75222,
        37.61556
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        author.text = post.author
        textViewDate.text = post.created
        content.text = post.content
        likeCount.text = (
                if (post.likedCount == 0) {
                    ""
                }
                else {
                    post.likedCount
                }).toString()
        shareCount.text = (
                if (post.sharedCount == 0) {
                    ""
                }
                else {
                    post.sharedCount
                }).toString()
        commentsCount.text = (
                if (post.commentsCount == 0) {
                    ""
                }
                else {
                   post.commentsCount
                }).toString()
        authorEvent.text = postEvent.author
        textViewDateEvent.text = postEvent.created
        contentEvent.text = postEvent.content

    }

    @SuppressLint("ResourceAsColor")
    fun likeClick(view: View) {
        post.likedByMe = !post.likedByMe
        if (post.likedByMe) {
            likeBtn.setImageResource(R.drawable.ic_favorite_active_24dp)
            post.likedCount += 1
            likeCount.text = post.likedCount.toString()
            likeCount.setTextColor(resources.getColor(R.color.colorActive))
        }
        else {
            likeBtn.setImageResource(R.drawable.ic_favorite_inactive_24dp)
            post.likedCount -= 1
            likeCount.text = (
                    if (post.likedCount == 0) {
                        ""
                    }
                    else {
                        post.likedCount
                    }).toString()
            likeCount.setTextColor(resources.getColor(R.color.colorInActive))
        }
    }

    @SuppressLint("ResourceAsColor")
    fun commentClick(view: View) {
        post.comments = !post.comments
        if (post.comments) {
            commentsBtn.setImageResource(R.drawable.ic_chat_active_24dp)
            post.commentsCount += 1
            commentsCount.text = post.commentsCount.toString()
            commentsCount.setTextColor(resources.getColor(R.color.colorActive))
        }
        else {
            commentsBtn.setImageResource(R.drawable.ic_chat_inactive_24dp)
            post.commentsCount -= 1
            likeCount.text = (
                    if (post.commentsCount == 0) {
                        ""
                    }
                    else {
                        post.commentsCount
                    }).toString()
            likeCount.setTextColor(resources.getColor(R.color.colorInActive))
        }
    }

    @SuppressLint("ResourceAsColor")
    fun shareClick(view: View) {
        post.shared = !post.shared
        if (post.shared) {
            val intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, """
                ${post.author} (${post.created})
                
                ${post.content}
                """.trimIndent())
                type = "text/plain"
            }
            startActivity(intent)
            post.sharedCount += 1
            shareCount.text = post.sharedCount.toString()
            shareBtn.setImageResource(R.drawable.ic_share_active_24dp)
            shareCount.setTextColor(resources.getColor(R.color.colorActive))
        }
        else {
            shareBtn.setImageResource(R.drawable.ic_share_inactive_24dp)
            post.sharedCount -= 1
            likeCount.text = (
                    if (post.sharedCount == 0) {
                        ""
                    }
                    else {
                        post.sharedCount
                    }).toString()
            likeCount.setTextColor(resources.getColor(R.color.colorInActive))
        }
    }

    fun locationClick(view: View) {
        val lat = postEvent.lat
        val lng = postEvent.lng
        val intent = Intent().apply {
            action = Intent.ACTION_VIEW
            data = Uri.parse("geo:$lat,$lng")
        }
        startActivity(intent)
    }
}
