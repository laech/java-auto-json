@SimpleCollectionMappers({
        @SimpleCollectionMapper(value = ArrayList.class, declareAs = Collection.class),
        @SimpleCollectionMapper(value = ArrayList.class, declareAs = List.class),
        @SimpleCollectionMapper(value = HashSet.class, declareAs = Set.class),
        @SimpleCollectionMapper(value = TreeSet.class, declareAs = SortedSet.class),
        @SimpleCollectionMapper(value = TreeSet.class, declareAs = NavigableSet.class),
        @SimpleCollectionMapper(ArrayList.class),
        @SimpleCollectionMapper(LinkedList.class),
        @SimpleCollectionMapper(HashSet.class),
        @SimpleCollectionMapper(TreeSet.class),
        @SimpleCollectionMapper(LinkedHashSet.class),
}) // TODO test each of these
package autojson.internal.bind.java.util;

import autojson.internal.SimpleCollectionMapper;
import autojson.internal.SimpleCollectionMappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
