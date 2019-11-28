# EuclideanAlgorithm
Software: Eclipse Java Oxygen, Version: Oxygen.2 Release (4.7.2)
Programming Language: Java Language
Compiler: jdk-9.0.4

Step 1: Initialisation:
We have set the n, p, q, p*q, a,x,(p-1)*(q-1) as BigIntegers

Step 2:ModInverse(b):
In this, we pass the (p-1)*(q-1) value and ‘a’ value to modInverse function. This function is calculated based on Extended Euclidean Algorithm. For that, we assign certain variables then calculate q=n/a,r=n-q*a. We perform this function, to get a-1 (mod(p-1)(q-1))

Step 3: Convert to Binary:

Step 3.a: Call bitsConversion (): We make sure that the value is in integer form and then call the conversion function.
This is returned as a string value.

Step 4: Apply Square and Multiply Method:

Step1: Call the square_multiply()

Step 2: Set z=1. Starting from length-1 to 0 calculate z=z*zmodn

Step 3: For char equal to 1, compute z=z*x modn
This is returned as a BigInteger value which is the Encryption value.

Step 4: Decryption:

Step 1: Convert a to binary

Step 2: Call the decryption function which calculates the square_multiply
This is returned as a BigInteger value which is the Decryption value.
