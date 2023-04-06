package graph.topologicalsort;

import java.util.*;

/*
You have a package repository in which there are dependencies between packages
for building like package A has to be built before package B.
If you are given dependencies between the packages and package name x,
we have find the build order for x.
Ex: A → {B,C}
B → {E}
C → {D,E,F}
D → {}
F → {}
G → {C}
        A     G
      /   \ /
     v    vv
     B    C
     |  / | \
     vv   v  v
     E    D  F

For package A, build order is E B F D C A (may not unique)
Ques. - How would you handle cyclic dependencies ?
 */

public class PackageDependency {
    public static void main(String[] args) {
        Map<String, List<String>> packageMap = new HashMap<>();
        packageMap.put("A", Arrays.asList("B", "C"));
        packageMap.put("B", Arrays.asList("E"));
        packageMap.put("C", Arrays.asList("D", "E", "F"));
        packageMap.put("D", Arrays.asList());
        packageMap.put("F", Arrays.asList());
        packageMap.put("G", Arrays.asList("C"));
        System.out.println(orderPackageName(packageMap, "A")); // [F, E, D, C, B, A]
        System.out.println(orderPackageName(packageMap, "G")); // [F, E, D, C, G]

        // print all dependencies together
        System.out.println(orderPackageName(packageMap)); // [F, E, D, C, B, G, A]
    }

    public static List<String> orderPackageName(Map<String, List<String>> packageMap, String packageName) {
        // find the subset using bfs
        Queue<String> queue = new LinkedList<>();
        queue.offer(packageName);
        Set<String> subset = new HashSet<>();
        subset.add(packageName);
        while (!queue.isEmpty()) {
            String currentPackage = queue.poll();
            for (String dependency : packageMap.getOrDefault(currentPackage, new ArrayList<>())) {
                if (subset.add(dependency))
                    queue.add(dependency);
            }
        }

        List<String> packageOrder = new ArrayList<>();
        Map<String, Integer> inDegree = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();

        for (String key : subset) {
            inDegree.put(key, inDegree.getOrDefault(key, 0));
            graph.put(key, new ArrayList<>());
            for (String value : packageMap.getOrDefault(key, new ArrayList<>())) {
                inDegree.put(value, inDegree.getOrDefault(value, 0) + 1);
                graph.get(key).add(value);
                graph.put(value, graph.getOrDefault(value, new ArrayList<>()));
            }
        }

        Queue<String> source = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                source.add(entry.getKey());
            }
        }
        while (!source.isEmpty()) {
            String currentPackage = source.poll();
            packageOrder.add(0, currentPackage);
            List<String> dependencies = graph.get(currentPackage);
            for (String dependency : dependencies) {
                inDegree.put(dependency, inDegree.get(dependency) - 1);
                if (inDegree.get(dependency) == 0) {
                    source.add(dependency);
                }
            }
        }
        // this means it has cyclic dependency, which is not a valid case.
        if (packageOrder.size() != subset.size()) {
            return new ArrayList<>();
            // throw new IllegalArgumentException("circle found");
        }
        return packageOrder;
    }

    public static List<String> orderPackageName(Map<String, List<String>> packageMap) {
        List<String> packageOrder = new ArrayList<>();
        Map<String, Integer> inDegree = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();

        for (String key : packageMap.keySet()) {
            inDegree.put(key, inDegree.getOrDefault(key, 0));
            graph.put(key, new ArrayList<>());
            for (String value : packageMap.get(key)) {
                inDegree.put(value, inDegree.getOrDefault(value, 0) + 1);
                graph.get(key).add(value);
                graph.put(value, graph.getOrDefault(value, new ArrayList<>()));
            }
        }

        Queue<String> source = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                source.add(entry.getKey());
            }
        }
        while (!source.isEmpty()) {
            String packageName = source.poll();
            packageOrder.add(0, packageName);
            List<String> dependencies = graph.get(packageName);
            for (String dependency : dependencies) {
                inDegree.put(dependency, inDegree.get(dependency) - 1);
                if (inDegree.get(dependency) == 0) {
                    source.add(dependency);
                }
            }
        }
        // this means it has cyclic dependency, which is not a valid case.
        if (packageOrder.size() != graph.size()) {
            return new ArrayList<>();
        }
        return packageOrder;
    }

}
