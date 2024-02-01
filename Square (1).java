package th.co.cdgs;

public class Square {

    public static void main(String[] args) {
 
        Square square = new Square();
        int rows = 7; // ลองเปลี่ยนค่านี้ตามที่ต้องการ
        String output = square.print(rows);
        System.out.println(output);
       
    }
 
    public String print(int rows) {
        StringBuilder result = new StringBuilder();
 
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                result.append("*");
            }
            result.append("\n");
        }
 
        return result.toString();
    }
}
