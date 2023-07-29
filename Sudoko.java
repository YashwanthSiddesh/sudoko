import java.util.*;
public class Sudoko {
    public static int a[][]=new int[9][9];
    public static boolean c(int i,int j,int n){
        for(int r=0;r<9;++r)
        if(a[i][r]==n)
        return false;
        for(int r=0;r<9;++r)
        if(a[r][j]==n)
        return false;int ac=0,bc=0;
        if(i<=2)
        bc=2;
        else if(i<=5)
        bc=5;
        else
        bc=8;
        if(j<=2)
        ac=2;
        else if(j<=5)
        ac=5;
        else
        ac=8;
        for(int p=bc-2;p<=bc;++p)
            for(int q=ac-2;q<=ac;++q)
           if(a[p][q]==n)
           return false;
           return true;
    }
    public static boolean fill(){
       for(int i=0;i<9;i++)
       {
        for(int r=0;r<9;r++)
        {
            if(a[i][r]==0)
            {
                for(int n=1;n<10;n++)
                if(c(i,r,n))
                {
                    a[i][r]=n;
                    if(fill())
                    return true;
                    else
                    a[i][r]=0;
                }
                return false;
            }
        }
       }
        return true;   
    }
    public static void print()
    {
        if(fill()){
            System.out.println("Solved one sudoko");
         for(int i=1;i<10;++i){
            for(int r=1;r<10;++r){
                System.out.print(a[i-1][r-1]+" ");
                if((r%3)==0)
                System.out.print("| ");
            }
            if((i%3)==0)
            {
                System.out.println();
                if(i!=9)
               for(int t=0;t<23;t++)
               System.out.print("-");
               else
               System.out.print("######--THE END--######");
            }
                System.out.println();
            }
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int b[][]=new int[9][9];
        System.out.println("ENter the sudoko row wise \nEnter 0 if its Empty Space");
        for(int i=0;i<9;++i)
            for(int r=0;r<9;++r){
            b[i][r]=sc.nextInt();
            a[i][r]=b[i][r];
             }
             print();
    }

}

