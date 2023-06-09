package com.shakiv.husain.instagramui.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shakiv.husain.instagramui.data.LocalPostProvider
import com.shakiv.husain.instagramui.data.post.PostItem
import com.shakiv.husain.instagramui.data.post.User
import com.shakiv.husain.instagramui.ui.components.PostActions
import com.shakiv.husain.instagramui.ui.components.ProfileImage
import com.shakiv.husain.instagramui.utils.IconsInstagram


@Preview
@Composable
fun PreviewPostItem(
) {
    val post = PostItem(
        id = "jhdgdr8734h3j4j3",
        post = "Top things to know in Android Platform and Quality at Google I/O '23",
        isLiked = true,
        user = User("Shakiv Husain", "Developer", profile = IconsInstagram.ProfilePic),
        postActions = com.shakiv.husain.instagramui.data.post.PostActions(false,false)
    )
    FeedListItem(postItem = post, onItemClick = {})
}

@Composable
fun FeedListItem(
    postItem: PostItem,
    modifier: Modifier = Modifier,
    onItemClick: (PostItem) -> Unit,
) {

    Card(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .clickable { onItemClick(postItem) },
        colors = CardDefaults
            .cardColors(MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                ProfileImage(profilePath = postItem.user.profile)

                Spacer(modifier = Modifier.width(12.dp))

                Column(
                    modifier = Modifier.weight(1F),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = postItem.user.name, style = MaterialTheme.typography.titleMedium)
                    Text(text = postItem.user.about, style = MaterialTheme.typography.bodySmall)
                }

                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.clip(CircleShape),

                    ) {

                    Image(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        modifier = Modifier.size(26.dp)
                    )

                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = postItem.post,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(2.dp)
            )


            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(16.dp))




            val onLikeClick = {

            }

            val onCommentClicked = {

            }

            PostActions(
                isLiked =postItem.postActions.isLiked ,
                modifier = Modifier.padding(),
                onLikeClicked = onLikeClick,
                onCommentClicked = onCommentClicked
            ) {


            }

        }
    }
}