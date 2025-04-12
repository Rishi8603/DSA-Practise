package OOPs;

public class oop1 {
    public static void main(String[] args) {
        Complex nos=new Complex();
        int real1=2;
        int img1=3;
        int real2=4;
        int img2=5;
        int realsum=nos.realsum(real1,real2);
        int imgsum=nos.imgsum(img1,img2);
        int realdiff=nos.realdiff(real1,real2);
        int imgdiff=nos.imgdiff(img1,img2);
        int productreal= nos.productreal(real1,real2,img1,img2);
        int productimg=nos.productimg(real1,real2,img1,img2);
        System.out.println("The sum of both complex no. is:" + realsum + "+" + imgsum+"i");
        System.out.println("The diff of both complex no. is:" + realdiff + "+" + imgdiff+"i");
        System.out.println("The product of both complex no. is:" + productreal + "+" + productimg + "i");
    }
}

class Complex{
    int realsum(int a1,int a2){
        return a1+a2;
    }

    int realdiff(int a1,int a2){
        return a1-a2;
    }
    int imgsum(int b1,int b2){
        return b1+b2;
    }

    int imgdiff(int b1,int b2){
        return b1-b2;
    }

    int productreal(int a1,int a2,int b1,int b2){
        return (a1*a2-b1*b2);
    }
    int productimg(int a1,int a2,int b1,int b2){
        return (a1*b2+b1*a2);
    }
}
