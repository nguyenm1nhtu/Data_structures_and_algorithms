package Bai5;

public class P26 {

    public static void main(String[] args) {
        String input = "Lời xin lỗi này đối với mình khá thú vị khi mở bài gợi sự tò mò. Thân bài là câu chuyện tình mà “chỉ có người trong cuộc mới hiểu rõ tận tường”. Còn người ngoài cuộc như chúng ta thì chỉ hiểu đơn giản là 5 triệu thôi. Jack nói khán giả bỏ đi hết, cậu ấy vẫn hát. Vậy ý của Jack tức là có khán giả hay không đều không quan trọng";
        String[] sentences = input.split("\\.");

        StringBuilder sb = new StringBuilder();
        for (int i = sentences.length - 1; i >= 0; i--) {
            sb.append(sentences[i]);
        }
        System.out.println(sb);
    }
}
