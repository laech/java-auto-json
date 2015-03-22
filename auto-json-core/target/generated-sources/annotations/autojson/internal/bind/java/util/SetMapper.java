package autojson.internal.bind.java.util;

@javax.annotation.Generated("autojson.internal.SimpleCollectionMappersProcessor")
public final class SetMapper<T> extends autojson.bind.NullableMapper<java.util.Set<T>> {

    private final autojson.bind.Mapper<T> delegate;

    public SetMapper(autojson.bind.Mapper<T> delegate) {
        this.delegate = java.util.Objects.requireNonNull(delegate, "delegate");
    }

    @Override
    protected java.util.Set<T> readNotNull(autojson.stream.JsonParser parser) throws java.io.IOException {
        return autojson.bind.Mappers.readJsonArray(delegate, parser, new java.util.HashSet<T>());
    }

    @Override
    protected void writeNotNull(autojson.stream.JsonGenerator generator, java.util.Set<T> value) throws java.io.IOException {
        autojson.bind.Mappers.writeJsonArray(delegate, generator, value);
    }

}
