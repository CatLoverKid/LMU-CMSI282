class MathMethods{


  public static long factorial(int n){
    int tempResult = n;
    for(int i = n-1; i > 1; i--){
      tempResult *= i;
    }
    return tempResult;
  }
  
  public static long fibonacci(int n){
    int tempResult1 = 1;
    int tempResult2 = 1;
    if(n<2){
      return 1;
    }else{
      for(int i = 2; i < n; i++){
        tempResult2 += tempResult1;
	tempResult1 = Math.abs(tempResult2 - tempResult1);
      }
    }
    return tempResult2;
  }
  
  public static long gcd(long m, long n){
    if(m == 0 || n == 0){
      return 0;
    }
    long r1 = 0;
    long r2 = 0;
    if(m>n){
      r1 = n;
      r2 = m;
    }else{
      r1 = m;
      r2 = n;
    }
    while( r2 != 0){
      long temp = r2;
      r2 = r1%r2;
      r1 = temp;
    }
    return r1;
  }
  
  public static long lcm(long m, long n){
    if(m == 0 || n == 0){
      return 0;
    }
    return (m==0||n==0)?0:(m*n)/gcd(m,n);
  }
  
  public static void main(String[] args){
    
  }
  
  public static double poly(double x, double[] coeff){
    long result = 0;
    for(int i = 0; i < coeff.length; i++){
      result += power(x, i)*coeff[i];
    }
    return result;
  }
  
  public static double power(double x, int n){
    return 1;
  }

  public static double root(int n, double x, double epsilon){
    return 1;
  }

  public static double sqrt(double x, double epsilon){    
    if (x == 0 || x == 1){
      return x;
    }
    double start = 1;
    double end = x;
    double ans = 0;   
    while (start <= end) {
      double mid = (start + end) / 2;
      if (mid*mid == x){
        return mid;
      }						  
      if (mid*mid < x){
        start = mid + 1;
        ans = mid;
      }else{
        end = mid - 1;
      }
    }
    return ans;
  }
}
