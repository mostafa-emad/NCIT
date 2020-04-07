package ncit.test.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import ncit.test.data.ws.model.BaseModel

@Entity(tableName = "user")
data class UserEntity(
        @PrimaryKey
        var user_id:String,

        var user_name : String,

        var user_pass : String

) : BaseModel()