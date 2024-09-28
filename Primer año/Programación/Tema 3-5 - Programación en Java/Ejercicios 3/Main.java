public class Main {
    public static void main(String[] args)  {
        System.out.println(getPayroll(1000, 1, 10, false));
    }
    
    public static double getSalaryMean(double[] salaries){
        double media = 0;
        for (double d : salaries) {
            media += d;
        }
        return media/salaries.length;
    }

    public static double getSalaryMedian(double[] salaries){
        double resultado = 0;
        if (salaries.length%2 != 0){
            return salaries[salaries.length/2];
        }else{
            return (salaries[salaries.length/2-1] + salaries[(salaries.length/2)])/2;
        }
    }

    public static double getPayroll(double salary, int children, double percentage, boolean disability){
        double importe = 0;
        double childrenPercent = 0;
        double disabilityPlus = (disability)?500:0;
        if (children >= 3 ){
            double childrenDouble = children;
            childrenPercent = (((childrenDouble-2 ) * 3 ) + 2 )/100;
        } 
        else {
            double childrenDouble = children;
            childrenPercent = childrenDouble/100;
        }
        return salary - ( salary * ( percentage/100 - childrenPercent )) + disabilityPlus; // + disabilityPlus;
    }

    public static double[][] transposeMatrix(double[][] matrix){
        double[][] matrixTrans = new double[matrix[0].length][matrix.length]; 
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrixTrans[i][j] = matrix[j][i];
            }
        }
        return matrixTrans;
    }
}
