package mithun; 
import java.math.*; 
import java.util.*; 
 
class RSA { 
 public static void main(String args[]) 
 { 
 int p, q, n, phi, d = 0, e, i; 
 
 // The number to be encrypted and decrypted
 int msg = 12; 
 double c; 
 BigInteger msgback; 
 Scanner sc=new Scanner(System.in); 
 
 // 1st prime number p
 //p = 3;
 System.out.println("Enter the value of p: "); 
 p=sc.nextInt(); 
 
 // 2nd prime number q
 //q = 11;
 System.out.println("Enter the value of q: "); 
 q=sc.nextInt(); 
 n = p * q; 
 phi = (p - 1) * (q - 1); 
 System.out.println("the value of phi = " + phi); 
 
 for (e = 2; e < phi; e++) { 
 
 // e is for public key exponent
 if (gcd(e, phi) == 1) { 
 break; 
 } 
 } 
 System.out.println("the value of e = " + e); 
 for (i = 0; i <= 9; i++) { 
 int x = 1 + (i * phi); 
 
 // d is for private key exponent
 if (x % e == 0) { 
 d = x / e; 
 break; 
 } 
 } 
 System.out.println("the value of d = " + d); 
 c = (Math.pow(msg, e)) % n; 
 System.out.println("Encrypted message is : " + c); 
 
 // converting int value of n to BigInteger
 BigInteger N = BigInteger.valueOf(n); 
 
 // converting float value of c to BigInteger
 BigInteger C = BigDecimal.valueOf(c).toBigInteger(); 
 msgback = (C.pow(d)).mod(N); 
 System.out.println("Decrypted message is : "
 + msgback); 
 } 
 
 static int gcd(int e, int phi) 
 { 
 if (e == 0) 
 return phi; 
 else
 return gcd (phi % e, e); 
 } 
}
