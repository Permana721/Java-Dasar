public class ForEach {
    public static void main(String[] args) {
        String[] names = {
                "Permana", "Surya", "Dharma",
                "Arido", "Shifuka"
        };

        for (var i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }

        System.out.println("FOR EACH");

        //  For Each
        for(var name : names){
            System.out.println(name);
        }
    }
}
