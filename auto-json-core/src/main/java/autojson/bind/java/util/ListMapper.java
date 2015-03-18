package autojson.bind.java.util;

import autojson.bind.Mapper;

import java.util.ArrayList;
import java.util.List;

public final class ListMapper<T> extends CollectionMapper<T, List<T>> {

    public ListMapper(Mapper<T> delegate) {
        super(delegate);
    }

    @Override
    protected List<T> newCollection() {
        return new ArrayList<>();
    }

}
