package autojson.integration;

@javax.annotation.Generated("autojson.AutoJsonProcessor")
public final class AutoJson_ObjectCollections extends autojson.bind.NullableMapper<ObjectCollections> {

    private static final autojson.bind.Mapper<java.util.ArrayList<java.lang.Integer>> arrayListMapper = new autojson.internal.bind.java.util.ArrayListMapper<>(new autojson.internal.bind.java.lang.IntegerMapper());
    private static final autojson.bind.Mapper<java.util.LinkedList<java.lang.Integer>> linkedListMapper = new autojson.internal.bind.java.util.LinkedListMapper<>(new autojson.internal.bind.java.lang.IntegerMapper());
    private static final autojson.bind.Mapper<java.util.List<java.lang.Integer>> listMapper = new autojson.internal.bind.java.util.ListMapper<>(new autojson.internal.bind.java.lang.IntegerMapper());
    private static final autojson.bind.Mapper<java.util.HashSet<java.lang.Integer>> hashSetMapper = new autojson.internal.bind.java.util.HashSetMapper<>(new autojson.internal.bind.java.lang.IntegerMapper());
    private static final autojson.bind.Mapper<java.util.LinkedHashSet<java.lang.Integer>> linkedHashSetMapper = new autojson.internal.bind.java.util.LinkedHashSetMapper<>(new autojson.internal.bind.java.lang.IntegerMapper());
    private static final autojson.bind.Mapper<java.util.TreeSet<java.lang.Integer>> treeSetMapper = new autojson.internal.bind.java.util.TreeSetMapper<>(new autojson.internal.bind.java.lang.IntegerMapper());
    private static final autojson.bind.Mapper<java.util.SortedSet<java.lang.Integer>> sortedSetMapper = new autojson.internal.bind.java.util.SortedSetMapper<>(new autojson.internal.bind.java.lang.IntegerMapper());
    private static final autojson.bind.Mapper<java.util.NavigableSet<java.lang.Integer>> navigableSetMapper = new autojson.internal.bind.java.util.NavigableSetMapper<>(new autojson.internal.bind.java.lang.IntegerMapper());
    private static final autojson.bind.Mapper<java.util.Set<java.lang.Integer>> setMapper = new autojson.internal.bind.java.util.SetMapper<>(new autojson.internal.bind.java.lang.IntegerMapper());
    private static final autojson.bind.Mapper<java.util.Collection<java.lang.Integer>> collectionMapper = new autojson.internal.bind.java.util.CollectionMapper<>(new autojson.internal.bind.java.lang.IntegerMapper());

    @Override
    protected ObjectCollections readNotNull(autojson.stream.JsonParser _parser) throws java.io.IOException {
        if (_parser.getToken() != autojson.stream.JsonToken.BEGIN_OBJECT) {
            throw new IllegalStateException(
                    "expected " + autojson.stream.JsonToken.BEGIN_OBJECT +
                            " but was " + _parser.getToken() + " at " + _parser.getLocation());
        }
        java.util.ArrayList<java.lang.Integer> arrayList = null;
        java.util.LinkedList<java.lang.Integer> linkedList = null;
        java.util.List<java.lang.Integer> list = null;
        java.util.HashSet<java.lang.Integer> hashSet = null;
        java.util.LinkedHashSet<java.lang.Integer> linkedHashSet = null;
        java.util.TreeSet<java.lang.Integer> treeSet = null;
        java.util.SortedSet<java.lang.Integer> sortedSet = null;
        java.util.NavigableSet<java.lang.Integer> navigableSet = null;
        java.util.Set<java.lang.Integer> set = null;
        java.util.Collection<java.lang.Integer> collection = null;
        while (_parser.next() && _parser.getToken() != autojson.stream.JsonToken.END_OBJECT) {
            switch (_parser.getName()) {
                case "arrayList":
                    arrayList = arrayListMapper.read(_parser);
                    break;
                case "linkedList":
                    linkedList = linkedListMapper.read(_parser);
                    break;
                case "list":
                    list = listMapper.read(_parser);
                    break;
                case "hashSet":
                    hashSet = hashSetMapper.read(_parser);
                    break;
                case "linkedHashSet":
                    linkedHashSet = linkedHashSetMapper.read(_parser);
                    break;
                case "treeSet":
                    treeSet = treeSetMapper.read(_parser);
                    break;
                case "sortedSet":
                    sortedSet = sortedSetMapper.read(_parser);
                    break;
                case "navigableSet":
                    navigableSet = navigableSetMapper.read(_parser);
                    break;
                case "set":
                    set = setMapper.read(_parser);
                    break;
                case "collection":
                    collection = collectionMapper.read(_parser);
                    break;
                default:
                    _parser.skipValue();
                    break;
            }
        }
        return new AutoValue_ObjectCollections(arrayList, linkedList, list, hashSet, linkedHashSet, treeSet, sortedSet, navigableSet, set, collection);
    }

    @Override
    protected void writeNotNull(autojson.stream.JsonGenerator generator, ObjectCollections element) throws java.io.IOException {
        generator.writeBeginObject();
        generator.writeName("arrayList");
        arrayListMapper.write(generator, element.arrayList());
        generator.writeName("linkedList");
        linkedListMapper.write(generator, element.linkedList());
        generator.writeName("list");
        listMapper.write(generator, element.list());
        generator.writeName("hashSet");
        hashSetMapper.write(generator, element.hashSet());
        generator.writeName("linkedHashSet");
        linkedHashSetMapper.write(generator, element.linkedHashSet());
        generator.writeName("treeSet");
        treeSetMapper.write(generator, element.treeSet());
        generator.writeName("sortedSet");
        sortedSetMapper.write(generator, element.sortedSet());
        generator.writeName("navigableSet");
        navigableSetMapper.write(generator, element.navigableSet());
        generator.writeName("set");
        setMapper.write(generator, element.set());
        generator.writeName("collection");
        collectionMapper.write(generator, element.collection());
        generator.writeEndObject();
    }

}
