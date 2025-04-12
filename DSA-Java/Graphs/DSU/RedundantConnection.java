package Graphs.DSU;

public class RedundantConnection {
    public static void main(String[] args) {

    }
    static int[] parent;
    static int[] size;
    public static int leader(int a){//recursion to find group leader
        if(parent[a]==a) return a ;
        int leader= leader(parent[a]);
        parent[a]=leader;
        return leader;
    }
    public static void union(int a,int b){
        int leaderA= leader(a);
        int leaderB= leader(b);
        //now we can either make a ka parent b or b ka parent a ..it's our choice
        //make parent of b as a
        if(leaderA!=leaderB) {
            if(size[leaderA]>size[leaderB]) { // a should be parent of b
                parent[leaderB] = leaderA;
                size[leaderA]+=size[leaderB];
            }else{
                parent[leaderA] = leaderB;
                size[leaderB]+=size[leaderA];
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        parent=new int[n+1];//1 to n nodes, given in question
        size = new int[n+1];
        for (int f = 0; f <= n; f++){
            parent[f]=f;
            size[f]=1;
        }
        //edges [[1,2],[2,3],[3,4],[1,4],[1,5]]
        int[] ans=new int[2];
        for (int i = 0; i < n; i++) {
            if(leader(edges[i][0])== leader(edges[i][1])){
                ans[0]=edges[i][0];
                ans[1]=edges[i][1];
                break;
            }else{
                union(edges[i][0],edges[i][1]);
            }
        }
        return ans;
    }
}
