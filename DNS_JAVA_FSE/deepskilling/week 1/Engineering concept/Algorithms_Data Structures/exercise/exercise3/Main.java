public class Main {

    public static void display(Order[] orders) {

        for (Order order : orders) {

            System.out.println(order);
            System.out.println("-----------------------");

        }

    }

    public static void main(String[] args) {

        Order[] orders = {

                new Order(101, "Rahul", 5000),
                new Order(102, "Aman", 12000),
                new Order(103, "Priya", 3000),
                new Order(104, "Neha", 8000)

        };

        System.out.println("----- Original Orders -----");

        display(orders);

        BubbleSort.sort(orders);

        System.out.println("\n----- Bubble Sort -----");

        display(orders);

        Order[] orders2 = {

                new Order(101, "Rahul", 5000),
                new Order(102, "Aman", 12000),
                new Order(103, "Priya", 3000),
                new Order(104, "Neha", 8000)

        };

        QuickSort.quickSort(orders2, 0, orders2.length - 1);

        System.out.println("\n----- Quick Sort -----");

        display(orders2);

    }

}