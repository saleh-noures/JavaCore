package HackerRank;


public class HR0_PlayGround {

    public static void main(String[] args) {
        String str1 = "pale";
        String str2 = "bae";


        if (str1.length() < str2.length())
            System.out.println(isInsertDelete(str1,str2));
        else if (str1.length() > str2.length())
            System.out.println(isInsertDelete(str2,str1));
        else
            System.out.println(isReplace(str1,str2));

    }

    public static boolean isInsertDelete(String s1, String s2)
    {

        boolean[] s2IndArr = new boolean[128];

        if (s1.length() + 1 < s2.length())
        return false;
        else{

            for (int i = 0; i < s2.length(); i++) {
                int s1Ind = s2.charAt(i);
                s2IndArr[s1Ind] = true;
            }

            for (int i = 0; i < s1.length(); i++) {
                int s2Ind = s1.charAt(i);
                if (!s2IndArr[s2Ind])
                    return false;
            }
        }
        return true;
    }

    public static boolean isReplace(String s1, String s2)
    {
        boolean[] s2IndArr = new boolean[128];
        int count = 0;

        for (int i = 0; i < s2.length(); i++) {
            int s1Ind = s2.charAt(i);
            s2IndArr[s1Ind] = true;
        }

        for (int i = 0; i < s1.length(); i++) {
            int s2Ind = s1.charAt(i);
            if (!s2IndArr[s2Ind])
                count++;
        }

        if (count == 1)
        return true;
        else
            return false;
    }


}

