package Quiz.a6_oop.coins;

public class LoopLoopCoinsChanger {

    private static final int[] coinNominals = new int[]{1, 2, 5, 10, 25};

    public static void main(String[] args) {
        System.out.println(getCombinations(19));
    }

    public static int getCombinations(int amountForExchange) {
        if (amountForExchange <= 0) return 0;
        int countVariant = 0, stack = 0;
        int count = 0;
        for (int i25 = 0; i25 <= amountForExchange / 25; i25++) {
            for (int i10 = 0; i10 <= amountForExchange / 10; i10++) {
                for (int i5 = 0; i5 <= amountForExchange / 5; i5++) {
                    for (int i2 = 0; i2 <= amountForExchange / 2; i2++) {
                        for (int i1 = 0; i1 <= amountForExchange; i1++) {
                            stack = (i25 * 25 + i10 * 10 + i5 * 5 + i2 * 2 + i1);
                            if (stack == amountForExchange) {
                                countVariant++;
                            }
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println("����� ��������: " + count);
        System.out.println("�� ��� ��������: " + countVariant);
        return countVariant;
    }

}