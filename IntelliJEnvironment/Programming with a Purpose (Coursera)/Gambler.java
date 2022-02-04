public class Gambler {
    public static void main(String[] args) {
        int stake = Integer.parseInt(args[0]);//how many we have
        int goal = Integer.parseInt(args[0]); // winning line
        int trails = Integer.parseInt(args[0]); // how many trail I can try
        ///something is not working. input  5 25 1000  191;
        int win = 0;
        for (int i = 0; i < trails; i++) {
            int cash = stake;
            while (cash > 0 && cash < goal) {
                if (Math.random() < 0.5) {
                    cash++;
                }
                else {
                    cash--;
                }
            }
            if (cash == goal) win++;
        }
        System.out.println(win + " wins of " + trails);

    }
}
