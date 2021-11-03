import java.util.HashMap;
import java.util.Map;

import solution.T_015;

public class Test {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(3, 1);
        map.put(2, 1);
        T_015 testModel = new T_015();
        System.out.println(map);
        testModel.changeMap(map, 3, -1,null);
        System.out.println(map);
    }
    
}
