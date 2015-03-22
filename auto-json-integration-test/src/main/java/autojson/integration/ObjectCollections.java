package autojson.integration;

import autojson.AutoJson;
import com.google.auto.value.AutoValue;

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

@AutoJson
@AutoValue
abstract class ObjectCollections {

    // Lists

    abstract ArrayList<Integer> arrayList();

    abstract LinkedList<Integer> linkedList();

    abstract List<Integer> list();

    // Sets

    abstract HashSet<Integer> hashSet();

    abstract LinkedHashSet<Integer> linkedHashSet();

    abstract TreeSet<Integer> treeSet();

    abstract SortedSet<Integer> sortedSet();

    abstract NavigableSet<Integer> navigableSet();

    abstract Set<Integer> set();

    // Collection

    abstract Collection<Integer> collection();

}
