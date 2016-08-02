package ru.sbt;

import java.util.HashMap;
import java.util.Map;

public class CountMap<T> implements CountMapInt<T> {
    private final Map<T, Integer> map = new HashMap<>();

    private void add(T o, int i) {
        map.put(o, map.getOrDefault(o,0) + i);
    }

    @Override
    public void add(T o) {
        add(o, 1);
    }

    @Override
    public int getCount(T o) {
        if (map.get(o) != null) {
            return map.get(o);
        }
        else {
            return 0;
        }
    }

    @Override
    public int remove(T o) {
        if (map.get(o) != null) {
            return map.remove(o);
        }
        else {
            return 0;
        }
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMapInt<? extends T> countMap) {
        Map<? extends T, Integer> map = countMap.toMap();
        for (T o : map.keySet()) {
            add(o, map.get(o));
        }
    }

    @Override
    public Map<T,Integer> toMap() {
        return map;
    }

    @Override
    public void toMap(Map<? super T, Integer> destination) {
        for (Map.Entry<T, Integer> entry : map.entrySet()) {
            T key = entry.getKey();
            destination.put(key, destination.getOrDefault(key, 0) + map.get(key));
        }
    }
}