package exemplo_1;

import org.mapstruct.factory.Mappers;

public class MapperInstance {

    private MapperInstance() {
    }

    public static <T> T getMapper(Class<T> clazz) {
        return Mappers.getMapper(clazz);
    }
}
