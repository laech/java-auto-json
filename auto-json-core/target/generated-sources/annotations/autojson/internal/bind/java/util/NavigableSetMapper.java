package autojson.internal.bind.java.util;

@javax.annotation.Generated("autojson.internal.SimpleCollectionMappersProcessor")
public final class NavigableSetMapper<T> extends autojson.bind.NullableMapper<java.util.NavigableSet<T>> {

    private final autojson.bind.Mapper<T> delegate;

    public NavigableSetMapper(autojson.bind.Mapper<T> delegate) {
        this.delegate = java.util.Objects.requireNonNull(delegate, "delegate");
    }

    @Override
    protected java.util.NavigableSet<T> readNotNull(autojson.stream.JsonParser parser) throws java.io.IOException {
        return autojson.bind.Mappers.readJsonArray(delegate, parser, new java.util.TreeSet<T>());
    }

    @Override
    protected void writeNotNull(autojson.stream.JsonGenerator generator, java.util.NavigableSet<T> value) throws java.io.IOException {
        autojson.bind.Mappers.writeJsonArray(delegate, generator, value);
    }

}
