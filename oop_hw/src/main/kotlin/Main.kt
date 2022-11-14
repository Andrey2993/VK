import javax.xml.stream.events.Comment

//Задача №1. Посты
data class Comment (
    val id: Int = 0,
    val fromId: Int = 0,
    val date: Int = 1,
    val text: String = "Comment text",
    val replyToUser: Int = 1,
    val replyToComment: Int = 1,
)

data class Views (
    val count: Int
)

data class Comments (
    val count: Int = 0,
    val canPost: Boolean = true,
    val groupsCanPost: Boolean = true,
    val canClose: Boolean = true,
    val canOpen: Boolean = true
)

data class Likes (
    val count: Int = 0,
    val userLikes: Int = 0,
    val canLike: Boolean = true,
    val canPublish: Boolean = true
)


data class Post(
    var id: Int = 0, //Идентификатор записи
    val ownerId: Int = 0, //Идентификатор владельца стены, на которой размещена запись
    val fromId: Int = 0, //Идентификатор автора записи
    val createdBy: Int = 0, //Идентификатор администратора, который опубликовал запись
    val date: Long = System.currentTimeMillis() / 1000L, //Время публикации записи
    val text: String, //Текст записи
    val replyOwnerId: Int = 0, //Идентификатор владельца записи, в ответ на которую была оставлена текущая
    val replyPostId: Int = 0, //Идентификатор записи, в ответ на которую была оставлена текущая
    val friendsOnly: Boolean = true, //Если запись была создана с опцией "только для друзей"
    val comments: Comments = Comments(), //Информация о комментариях к записи, объект с полями
    val likes: Likes = Likes(), //Информация о лайках к записи, объект с полями
    val reposts: Int = 0, //Информация о репостах записи (рассказать друзьям), объект с полями
    val views: Int = 0, //Информация о просмотрах записи. Объект с единственным полем
    val postType: String = "post", //Тип записи, может принимать следующие значения: post, copy, reply, postpone, suggest
)


object WallService {
    private var posts = emptyArray<Post>()

    fun add(newPost: Post): Post {
        if (posts.isNotEmpty()) {
            newPost.id = posts.lastIndex + 2
        } else
            newPost.id = 1
        posts += newPost
        return posts.last()
    }

    fun update(currentPost: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == currentPost.id) {
                posts[index] = currentPost
                return true
            }
        }
        return false
    }
}


fun main(args: Array<String>) {
    val firstPost = Post(
        0,
        10,
        10,
        10,
        60,
        "Проверка работы!",
        10,
        143,
        true,
        Comments(100, canPost = true, groupsCanPost = true, canClose = true, canOpen = true),
        Likes(300, userLikes = 1, canLike = true, canPublish = true),
        1,
        500,
        "reply"
    )

    WallService.add(firstPost)
    WallService.update(firstPost)
    println(firstPost)
}
//gradle test jacocoTestReport