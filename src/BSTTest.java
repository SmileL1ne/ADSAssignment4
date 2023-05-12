public class BSTTest {

    public static void main(String[] args) {
        BST<Integer, String> myBst = new BST<>();

        // Testing put method
        System.out.println("Testing put method: ");
        myBst.put(0, "da");
        myBst.put(1, "net");
        myBst.put(2, "tuda");
        myBst.put(4, "anet");
        myBst.put(8, "izi");
        myBst.put(0, "ubral");
        myBst.put(-10, "negativ");

        for (BST.KandV<Integer, String> var: myBst) {
            System.out.println("Key is " + var.key + " and value is " + var.value);
        }
        System.out.println();

        // Testing get method
        System.out.println("Testing get method: ");
        System.out.println(myBst.get(8));
        System.out.println(myBst.get(-10));
        System.out.println(myBst.get(2));
        System.out.println("The size is: " + myBst.size());
        System.out.println();

        // Testing delete method
        System.out.println("Testing delete method: ");
        myBst.delete(2);
        for (BST.KandV<Integer, String> var: myBst) {
            System.out.println("Key is " + var.key + " and value is " + var.value);
        }
        System.out.println();

        // Testing size method
        System.out.println("Testing size method: ");
        System.out.println(myBst.size());
    }
}
