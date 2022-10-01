/*
Idea is simple, only traverse those elements which are in boundary range
*/  
static ArrayList<Integer> boundaryTraversal(int s[][], int m, int n)
    {
        // code here 
        ArrayList<Integer> res = new ArrayList<Integer>();
         for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0)
                    res.add(s[i][j]);
                if (i == m - 1)
                    res.add(s[i][j]);
                if (j == 0)
                    res.add(s[i][j]);
                if (j == n - 1)
                    res.add(s[i][j]);
            }
        }
        return res;
    }
