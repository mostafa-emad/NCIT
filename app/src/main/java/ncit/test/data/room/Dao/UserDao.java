package ncit.test.data.room.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import ncit.test.data.room.entity.UserEntity;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    LiveData<List<UserEntity>> getAllLiveData();

    @Query("SELECT * FROM user")
    List<UserEntity> getAll();

    @Query("SELECT * FROM user WHERE `user_name`=:username and `user_pass`=:password")
    UserEntity login(String username,String password);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void inset(List<UserEntity> entities);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void inset(UserEntity entity);

}
