package Graphs.DSU;

public class NoOFProvine {
    public static void main(String[] args) {

    }
    //Path compression METHOD
    static int[] parent;
    static int[] size;
    public static int find(int a){//recursion to find group leader
        if(parent[a]==a) return a ;
        int leader=find(parent[a]);
        parent[a]=leader;
        return leader;
    }
    public static void union(int a,int b){
        int leaderA=find(a);
        int leaderB=find(b);
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


    //using UNION BY SIZE
//    static int[] parent;
//    static int[] size;
////    public static int find(int a){//recursion to find group leader
////        if(parent[a]==a) return a ;
////        return find(parent[a]);
////    }
//    public static void union(int a,int b){
//        int leaderA=find(a);
//        int leaderB=find(b);
//        //now we can either make a ka parent b or b ka parent a ..it's our choice
//        //make parent of b as a
//        if(leaderA!=leaderB) {
//            if(size[leaderA]>size[leaderB]) { // a should be parent of b
//                parent[leaderB] = leaderA;
//                size[leaderA]+=size[leaderB];
//            }else{
//                parent[leaderA] = leaderB;
//                size[leaderB]+=size[leaderA];
//            }
//        }
//    }


    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        parent=new int[n+1];//1 to n nodes, given in question
        size = new int[n+1];
        for (int f = 0; f <= n; f++){
            parent[f]=f;
            size[f]=1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //here in this question edges is from i+1 to j+1
                if(i!=j && isConnected[i][j]==1) union(i+1,j+1);
            }
        }
        int count=0;
        for (int i = 1; i < parent.length; i++) {
            if(parent[i]==i) count++;
        }
        return count;
    }
}
