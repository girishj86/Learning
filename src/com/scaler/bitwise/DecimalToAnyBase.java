package com.scaler.bitwise;

public class DecimalToAnyBase {
    public static void main(String[] args) {
        System.out.println(1<<-1);
        //System.out.println(DecimalToAnyBase.decimalToAnyBase(8,2));
    }

    public static int decimalToAnyBase(int A, int B) {
        int temp = A, remainder = 0, result = 0, i = 1;
        while(temp > 0){
            remainder = temp % B;
            result = result + (remainder * i);
            i = i * 10;
            temp = temp / B;
        }
        return result;
    }
}
