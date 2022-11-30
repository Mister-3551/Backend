package pintar.gasper.backend.webApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pintar.gasper.backend.game.entity.Users;
import pintar.gasper.backend.webApp.object.User;

@Repository
public interface WebLoginRepository extends JpaRepository<Users, String> {

    @Query("SELECT NEW pintar.gasper.backend.webApp.object.User(u.id, u.name, u.username, u.email) FROM Users u WHERE u.username = :usernameEmail OR u.email = :usernameEmail AND u.password = :password")
    User findByUsernameOrEmailAndPassword(String usernameEmail, String password);
}
