import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        /*
        * Hãy chuyển đổi chuỗi sao cho đầu ra là mỗi ký tự sẽ đổi thành liền sau nó, riêng chữ nguyên âm thì phải In hoa
        *
        * Ví dụ input:
"implement*3-2"
output:"knqmfnfOr*3-2"
+ Hãy chuyển số với ví dụ đầu vào là 4465568759 sao cho giữ 2 số chẳn là * và 2 số lẻ là trừ. Số 0 giữ nguyên. Kết quả "4-655687*9"
        * */
        // input: implent*3-2
        // out: kn
        System.out.println("Hello");
        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter a word:");
//        String input = sc.nextLine();
//        S output = convert(input);
        System.out.println(convertNumberUsingTempArray(4465568759L));
//        System.out.println(convertNumberUsingTempArray(44646L));
        ;
    }

    private static StringBuilder convert(String input) {
        StringBuilder result = new StringBuilder();
        for (var word : input.toCharArray()) {
            System.out.println(word);
            if (Character.isDigit(word)) {

            }
            result.append(word);

        }
        return result;
    }


    private static String convertNumber(long inputNum) {
        StringBuilder result = new StringBuilder();
        String string = Long.toString(inputNum);
        char[] charArray = string.toCharArray();
        for (int i = 0; i < charArray.length - 2; i++) {
            if (checkEvenNumber(charArray[i]) && checkEvenNumber(charArray[i + 2])) {
                result.append(charArray[i]);
                result.append("*");
                i++;
                continue;
            }

            if (!checkEvenNumber(charArray[i]) && !checkEvenNumber(charArray[i + 2])) {
                result.append(charArray[i]);
                result.append("-");
                i++;
                continue;
            }

            result.append(charArray[i]);
        }

        return result.toString();
    }

    private static String convertNumberUsingTempArray(long inputNum) {
        StringBuilder result = new StringBuilder();
        String string = Long.toString(inputNum);
        char[] charArray = string.toCharArray();
        List<Character> chars = new ArrayList<>();
        for (var chr : charArray) {
//            System.out.println("chr = " + chr);
            chars.add(chr);
            if (chars.size() == 3) {
                if (checkEvenNumber(chars.get(0)) && checkEvenNumber(chars.get(2))) {
                    result.append(String.format("%s*%s", chars.get(0), chars.get(2)));
                    chars.remove(0);
                    chars.remove(0);
                    continue;
                }

                if (!checkEvenNumber(chars.get(0)) && !checkEvenNumber(chars.get(2))) {
                    result.append(String.format("%s-%s", chars.get(0), chars.get(2)));
                    chars.remove(0);
                    chars.remove(0);
                    continue;
                }

                result.append(chars.get(0));
                chars.remove(0);
                System.out.println("chars = " + chars);

            }
        }

        return result.toString();
    }

    private static boolean checkEvenNumber(char c) {
        return Character.getNumericValue(c) % 2 == 0;
    }
}
