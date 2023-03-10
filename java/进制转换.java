public class 进制转换 {
    public static void main(String[] args){
        //二进制转十进制
        /*
         * 从最低位开始，将位上的数值乘以2的(位数-1)次方
         * 如 0b1100 转十进制
         * 0*2^(1-1)+0x2^(2-1)+1*2^(3-1)+1*2^(4-1)=12
         */
        // 八进制转十进制
        /*
         * 从最低位开始，将位上的数值乘以8的(位数-1)次方
         * 如01100转十进制
         * 0*8^(1-1)+0x8^(2-1)+1*8^(3-1)+1*8^(4-1)=576
         */
          // 十六进制转十进制
        /*
         * 从最低位开始，将位上的数值乘以16的(位数-1)次方
         * 如0x1100转十进制
         * 0*16^(1-1)+0x16^(2-1)+1*16^(3-1)+1*16^(4-1)=4352
         */
        // 十进制转二进制
        /*
         * 将该数不断除以2,直到商为0,然后将每步的余数倒过来，就是对应的二进制
         * 如 34转二进制
         * 34/2=17 余0 17/2=8 余1 8/2=4 余0 4/2=2 余0 2/2=1 余0 1/2=0 余1
         * 即为ob100010
         */
        // 十进制转八进制
        /*
         * 将该数不断除以8,直到商为0,然后将每步的余数倒过来，就是对应的八进制
         * 如 34转八进制
         * 34/8=4 余2 4/8=0 余4
         * 即为o42
         */
        // 十进制转十六进制
        /*
         * 将该数不断除以16,直到商为0,然后将每步的余数倒过来，就是对应的八进制
         * 如 34转八进制
         * 34/16=2 余2 2/16=0 余2
         * 即为ox22
         */
        System.out.println(0x22);
        // 二进制转八进制
        /*
         * 从低为开始，将二进制数每3位一组，转为八进制数
         * 如ob100010 010 2 100 4 42
         */
        System.out.println(042);
        // 二进制转十六进制
        /*
         * 从低为开始，将二进制数每3位一组，转为八进制数
         * 如0b11000110 0110 6 1100 12 c6
         */
        System.out.println(0xc6);
         // 八进制转二进制
        /*
         * 将八进制数的每一位数转为对应的3位二进制
         * 如0237 2 010 3 011 7 111   0b10011111 
         */
        System.out.println(0b10011111 );
         // 十六进制转二进制
        /*
         * 将十六进制数的每一位数转为对应的4位二进制
         * 如0x23b 0010 2 0011 3 1011 11 0b1000111011
         */
        System.out.println(0x23b );


    }
}

