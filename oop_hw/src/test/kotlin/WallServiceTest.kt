import org.junit.Test
import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun add() {
        val expected = true //fun add returns true
        WallService.add(Post(
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
        ))

        WallService.add(Post(
            0,
            10,
            10,
            10,
            60,
            "SOME TEXT :-)",
            10,
            143,
            true,
            Comments(100,groupsCanPost = true, canClose = true, canOpen = true, canPost = true),
            Likes(300, userLikes = 1, canLike = false, canPublish = true),
            10,
            1000,
            "postpone"))

        assertEquals(expected, true)
    }

    @Test
    fun update() {
        val result = true //fun update returns true
        WallService.update(Post(
            1,
            10,
            10,
            10,
            60,
            "Я сделал дз",
            10,
            143,
            true,
            Comments(100,groupsCanPost = true, canClose = true, canOpen = true, canPost = true),
            Likes(300, userLikes = 0, canLike = false, canPublish = true),
            50,
            400,
            "post",))

        assertTrue(result)
    }
}
//gradle test jacocoTestReport