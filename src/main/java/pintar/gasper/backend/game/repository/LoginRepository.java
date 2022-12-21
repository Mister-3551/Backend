package pintar.gasper.backend.game.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pintar.gasper.backend.game.entity.Users;
import pintar.gasper.backend.game.object.User;

@Repository
public interface LoginRepository extends JpaRepository<Users, String> {

    @Query("SELECT NEW pintar.gasper.backend.game.object.User(u.id, u.name, u.username, u.rank) FROM Users u WHERE u.username = :username AND u.password = :password")
    User findByUsernameAndPassword(String username, String password);
}