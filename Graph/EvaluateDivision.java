package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision{
     private double dfs(Map<String, Map<String, Double>> graph, String src, String dst, Set<String> visited) {
        if (src.equals(dst)) {
            return 1.0;
        }
        
        visited.add(src);
        
        for (Map.Entry<String, Double> entry : graph.get(src).entrySet()) {
            String neighbor = entry.getKey();
            double weight = entry.getValue();
            
            if (!visited.contains(neighbor)) {
                double result = dfs(graph, neighbor, dst, visited);
                if (result != -1.0) {
                    return weight * result;
                }
            }
        }
        
        return -1.0;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double v = values[i];
            
            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            
            graph.get(a).put(b, v);
            graph.get(b).put(a, 1.0 / v);
        }

        double[] answers = new double[queries.size()];
        
        for (int i = 0; i < queries.size(); i++) {
            String c = queries.get(i).get(0);
            String d = queries.get(i).get(1);
            
            if (!graph.containsKey(c) || !graph.containsKey(d)) {
                answers[i] = -1.0;
            } else {
                Set<String> visited = new HashSet<>();
                answers[i] = dfs(graph, c, d, visited);
            }
        }
        
        return answers;

    }
}