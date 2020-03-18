package com.examples.examples;

class GFG {
      
    // Function to calculate 
    // mean of data. 
    static double mean(double arr[], int n) 
    { 
        double sum = 0; 
          
        for (int i = 0; i < n; i++) 
            sum = sum + arr[i];  
          
        return sum / n; 
    } 
      
    // Function to calculate standard 
    // deviation of data. 
    static double standardDeviation(double arr[], 
                                            int n) 
    { 
          
        double sum = 0 ; 
          
        // find standard deviation  
        // deviation of data. 
        for (int i = 0; i < n; i++) 
            sum = (arr[i] - mean(arr, n)) * 
                        (arr[i] - mean(arr, n)); 
                  
        return Math.sqrt(sum / n); 
    } 
      
    // Function to calculate skewness. 
    static double skewness(double arr[], int n) 
    {  
        // Find skewness using 
        // above formula 
        double sum = 0; 
          
        for (int i = 0; i < n; i++) 
            sum = (arr[i] - mean(arr, n)) *  
                    (arr[i] - mean(arr, n)) *  
                        (arr[i] - mean(arr, n));              
          
        return sum / (n * standardDeviation(arr, n) * 
                          standardDeviation(arr, n) * 
                          standardDeviation(arr, n));
    } 
      
    // Driver function 
    public static void main (String[] args)  
    { 
        double arr[] = { -5, 0, 2, 3, 6, 12, 15, 34, 65, 78, 80 };
                          
        // calculate size of array. 
        int n = arr.length; 
          
        // skewness Function call 
        System.out.println(skewness(arr, n)); 
    } 
} 