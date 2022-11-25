package pintar.gasper.backend.game.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pintar.gasper.backend.game.entity.Units;

@Repository
public interface ShopRepository extends JpaRepository<Units, String> {

    @Query(value = "SELECT u.name, u.healthPoints FROM Units u")
    String[] getUnits();
}
