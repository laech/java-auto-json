package autojson.internal.bind.java.util;

@javax.annotation.Generated("autojson.internal.SimpleCollectionMappersProcessor")
public final class CollectionMapper<T> extends autojson.bind.NullableMapper<java.util.Collection<T>> {

    private final autojson.bind.Mapper<T> delegate;

    public CollectionMapper(autojson.bind.Mapper<T> delegate) {
        this.delegate = java.util.Objects.requireNonNull(delegate, "delegate");
    }

    @Override
    protected java.util.Collection<T> readNotNull(autojson.stream.JsonParser parser) throws java.io.IOException {
        return autojson.bind.Mappers.readJsonArray(delegate, parser, new java.util.ArrayList<T>());
    }

    @Override
    protected void writeNotNull(autojson.stream.JsonGenerator generator, java.util.Collection<T> value) throws java.io.IOException {
        autojson.bind.Mappers.writeJsonArray(delegate, generator, value);
    }

}
