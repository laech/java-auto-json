package autojson.bind.java.util;

import autojson.bind.Mapper;

import java.util.HashSet;
import java.util.Set;

public final class SetMapper<T> extends CollectionMapper<T, Set<T>> {

    public SetMapper(Mapper<T> delegate) {
        super(delegate);
    }

    @Override
    protected Set<T> newCollection() {
        return new HashSet<>();
    }

}
