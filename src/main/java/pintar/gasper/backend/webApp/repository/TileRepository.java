package pintar.gasper.backend.webApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pintar.gasper.backend.webApp.entity.tiles.TileEntity;

import java.util.ArrayList;

public interface TileRepository extends JpaRepository<TileEntity, Long> {

    @Query(value = "SELECT t.id, t.name, t.size " +
            "FROM tiles t", nativeQuery = true)
    ArrayList<TileEntity> getTiles();
}