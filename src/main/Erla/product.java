public class product {

    int maxProduct;

    public product(String s) {
        int product = (s.charAt(0)-'0')*
                (s.charAt(1)-'0')*(s.charAt(2)-'0')*
                (s.charAt(3)-'0')*(s.charAt(4)-'0');
        maxProduct = product;
        for (int i = 0; i+5 < s.length(); i++){
            if (s.charAt(i) != '0')
                product = product
                        /(s.charAt(i)-'0')
                        *(s.charAt(i+5)-'0');
            else
                product = (s.charAt(i+1)- '0')
                        *(s.charAt(i+2)-'0')*(s.charAt(i+3)-'0')
                        *(s.charAt(i+4)-'0')*(s.charAt(i+5)-'0');
            if (product > maxProduct)
                maxProduct = product;
        }
    }

    int getMaxProduct(){
        return maxProduct;
    }

    public static void main(String[] args){
        System.out.println(new product(
                "7316717653133062491922511967442657474235534919493471636269561882670428252483600823257530420752963450" ).getMaxProduct());
    }
}
