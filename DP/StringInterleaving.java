package Questions.DP_15;

public class StringInterleaving {
    static boolean[][]dp;
    public static void main(String[] args) {
        String a="AAB";
        String b="AAC";
        String c="AACAAB";
        dp=new boolean[a.length()][b.length()];
        if(a.length()+b.length()!=c.length())
            System.out.println(false);
        System.out.println(isInterleaf(a,b,c,0,0,0));
    }
    static boolean isInterleaf(String a,String b,String c,int pos1,int pos2,int pos3){
        if(pos1==a.length() && pos2==b.length() && pos3==c.length())
            return true;
        if(pos3==c.length())
            return false;
        return (a.charAt(pos1)==c.charAt(pos3) && isInterleaf(a,b,c,pos1+1,pos2,pos3+1)
                || (b.charAt(pos2)==c.charAt(pos3) && isInterleaf(a,b,c,pos1,pos2+1,pos3+1)));
    }
    public boolean isInterleaved(char str1[], char str2[], char str3[]){
        boolean T[][] = new boolean[str1.length +1][str2.length +1];

        if(str1.length + str2.length != str3.length){
            return false;
        }

        for(int i=0; i < T.length; i++){
            for(int j=0; j < T[i].length; j++){
                int l = i + j -1;
                if(i == 0 && j == 0){
                    T[i][j] = true;
                }
                else if(i == 0){
                    if(str3[l] == str2[j-1]){
                        T[i][j] = T[i][j-1];
                    }
                }
                else if(j == 0){
                    if(str1[i-1] == str3[l]){
                        T[i][j] = T[i-1][j];
                    }
                }
                else{
                    T[i][j] = (str1[i-1] == str3[l] ? T[i-1][j] : false) || (str2[j-1] == str3[l] ? T[i][j-1] : false);
                }
            }
        }
        return T[str1.length][str2.length];
    }
}
