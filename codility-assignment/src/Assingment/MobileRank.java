package Assingment;

import java.util.*;

public class MobileRank {

    static class Ranking {
        String number;
        int rank;

        Ranking(String number, int rank) {
            this.number = number;
            this.rank = rank;
        }
    }

    private static int calculateRank(String num) {
        int rank = 0;

        
        boolean isDesc = true;
        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(i) > num.charAt(i - 1)) {
                isDesc = false;
                break;
            }
        }
        if (isDesc) rank += 20; 
        
        boolean isAsc = true;
        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(i) < num.charAt(i - 1)) {
                isAsc = false;
                break;
            }
        }
        if (isAsc) rank += 30; 

     
        Set<Character> digits = new HashSet<>();
        int repeatedCount = 0;
        for (char c : num.toCharArray()) {
            if (!digits.add(c)) {
                repeatedCount++;
            }
        }
        if (repeatedCount > 0) rank += (repeatedCount * 5); 

        return rank;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of mobiles:");
        int n = sc.nextInt();
        sc.nextLine(); 

        List<String> mobiles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the mobile " + (i + 1) + ":");
            String number = sc.nextLine();

            
            if (number.length() != 10 || !number.matches("\\d{10}")) {
                System.out.println("Invalid mobile number.");
                continue;
            }
            mobiles.add(number);
        }

        List<Ranking> rankNumber = new ArrayList<>();
        for (String num : mobiles) {
            int rank = calculateRank(num);
            rankNumber.add(new Ranking(num, rank));
        }

       
        rankNumber.sort((a, b) -> {
            if (a.rank != b.rank) {
                return Integer.compare(b.rank, a.rank); 
            } else {
                return a.number.compareTo(b.number);
            }
        });

        System.out.println("Mobiles based on rank:");
        for (int i = 0; i < rankNumber.size(); i++) {
            System.out.println("Mobile Number: " + rankNumber.get(i).number + " Rank :" + (i + 1));
        }

        sc.close();
    }
}
