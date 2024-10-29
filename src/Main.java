import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        var list = new ArrayList<>(List.of(
        "Привет",
        "мир",
        "а",
        "Привет",
        "б",
        "а"
        ));

        var list2 = new ArrayList<>(List.of(
                10,
                100,
                -10,
                20,
                100,
                5,
                -20,
                5
        ));

        var list3 = new ArrayList<>(List.of(
                new Circle(10),
                new Circle(20),
                new Circle(-1),
                new Circle(5),
                new Circle(30),
                new Circle(3)
        ));

        var list4 = new ArrayList<ArrayList<Circle>>(List.of(
                new ArrayList<>(List.of(new Circle(5), new Circle(10), new Circle(15))),
                new ArrayList<>(List.of(new Circle(3), new Circle(20))),
                new ArrayList<>(List.of(new Circle(-10)))
        ));
        
        System.out.println("Remove duplicates");
        System.out.println(list);
        System.out.println(RemoveDuplics(list));
        System.out.println("-------------------");
        System.out.println(list2);
        System.out.println(RemoveDuplics(list2));
        
        System.out.println("\n\nFind element");
        System.out.println(list2);
        System.out.println("Try find -10, result: " + Find(list2, -10));
        System.out.println("-------------------");
        System.out.println(list);
        System.out.println("Try find с, result: " + Find(list, "с"));

        System.out.println("\n\nMax element");
        System.out.println(list3);
        var max = Max(list3);
        System.out.println("Max radius must be 30, result: " + (max.isEmpty() ? "error" : max.get().get_radius()));

        System.out.println("\n\nMax element of list of list elements");
        System.out.println(list3);
        var max2 = MaxTwoDim(list4);
        System.out.println("Max radius must be 20, result: " + (max2.isEmpty() ? "error" : max2.get().get_radius()));
    }
    
    public static <T> ArrayList<T> RemoveDuplics(ArrayList<T> list) {
        if (list == null || list.isEmpty())
            return new ArrayList<>();
        
        var result = new ArrayList<T>();
        
        for (var item : list)
            if (!result.contains(item))
                result.add(item);
        
        return result;
    }
    
    public static <T> int Find(ArrayList<T> list, T obj) {
        if (list == null || list.isEmpty())
            return -1;
        
        for (var i = 0; i < list.size(); i++)
            if (list.get(i).equals(obj))
                return i;
        
        return -1;
    }
    
    public static <T> Optional<T> Max(ArrayList<T> list) {
        if (list == null || list.isEmpty())
            return Optional.empty();
        
        var max = list.getFirst();
        
        for (var item : list) {
            var cast = (Comparable<T>)item;
            if (cast == null)
                return Optional.empty();
            
            if (cast.compareTo(max) > 0)
                max = item;
        }
            
        return Optional.of(max);
    }

    public static <T> Optional<T> MaxTwoDim(ArrayList<ArrayList<T>> list) {
        if (list == null || list.isEmpty())
            return Optional.empty();

        T max = null;

        for (var in_list : list) {
            for (var item : in_list) {
                var cast = (Comparable<T>)item;
                if (cast == null)
                    return Optional.empty();

                if (max == null || cast.compareTo(max) > 0)
                    max = item;
            }
        }

        if (max == null)
            return Optional.empty();
        
        return Optional.of(max);
    }
}

