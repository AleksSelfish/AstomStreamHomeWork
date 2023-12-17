import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


class Main {
    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        List<Transaction> result = transactions.stream()
                .filter(year -> year.getYear() == 2011)
                .sorted(Comparator.comparing(transaction -> transaction.getValue()))
                .collect(Collectors.toList());
        System.out.println(result);
        System.out.println();


        //EX 2
        List<String> result2 = transactions.stream()
                .map(city -> city.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(result2);
        System.out.println();

        //EX 3
        List<String> result3 = transactions.stream()
                .filter(cityTrader -> cityTrader.getTrader().getCity().equals("Cambridge"))
                .map(name -> name.getTrader().getName())
                .sorted()
                .toList();
        System.out.println(result3);
        System.out.println();

        //EX 4
        List<String> result4 = transactions.stream()
                .map(name -> name.getTrader().getName())
                .sorted()
                .toList();
        System.out.println(result4);
        System.out.println();

        //EX 5

        List<String> result5 = transactions.stream()
                .filter(cityTrader -> cityTrader.getTrader().getCity().equals("Milan"))
                .map(name -> name.getTrader().getCity())
                .toList();
        System.out.println(result5.get(0).equals("Milan") ? "Yes":"No");
        System.out.println();


        //EX 6
        List<Integer> result6 = transactions.stream()
                .filter(cityTrader -> cityTrader.getTrader().getCity().equals("Cambridge"))
                .map(transaction -> transaction.getValue())
                .toList();
        System.out.println(result6);
        System.out.println();


        //EX 7
        List<Transaction> result7 = transactions.stream()
                .max(Comparator.comparingInt(Transaction ::getValue ))
                .stream().toList();
        System.out.println(result7);
        System.out.println();

        //EX 8

        List<Transaction> result8 = transactions.stream()
                .min(Comparator.comparingInt(Transaction ::getValue ))
                .stream().toList();
        System.out.println(result8);
        System.out.println();
    }
}






