package services;

import java.util.List;

public interface MethodService<EntityType> {

    List<EntityType> selectBySQL(String sql, Object... args);

    List<EntityType> getAll();

    EntityType getByID(int id);

    void add(EntityType o);

    void update(EntityType o, int id);

    void remove(int id);

}
