// remove methods from graph
// You are given two integers n and k, and a 2D integer array invocations, where invocations[i] = [ai, bi] indicates that method ai invokes method bi.

// There is a known bug in method k. Method k, along with any method invoked by it, either directly or indirectly, are considered suspicious and we aim to remove them.

// A group of methods can only be removed if no method outside the group invokes any methods within it.

// Return an array containing all the remaining methods after removing all the suspicious methods. You may return the answer in any order. If it is not possible to remove all the suspicious methods, none should be removed.

  // graph problem!!
  // step 1: make adjacency list
  // step 2: mark sus methods(direct/indirect)
  // step 3: if any safe methods call sus, theyre safe too; return all methods
  // step 4: if not sus, remove all safe and return the rest

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        // step1 make adj list
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge:invocations){
            adjList.get(edge[0]).add(edge[1]);
            // 0-1
            // 1-2
            // 3-2 (list example)
        }
            // step 2 mark sus
            boolean[] sus = new boolean[n];
                // dfs
            Deque<Integer> stack = new ArrayDeque<>(); 
            stack.push(k);
            sus[k] = true;
            while(!stack.isEmpty()){
                int curr = stack.pop();
                for(int m: adjList.get(curr)){
                    if(!sus[m]){
                        sus[m] = true;
                        stack.push(m);
                    }
                }
            }

        // step3
        for(int[] edges: invocations){
            int caller = edges[0], called = edges[1];
            if(!sus[caller] && sus[called]){
                List all = new ArrayList<>();
                for (int a =0; a<n;a++) all.add(a);
                return all;
            }
        }

        // step4
        List res = new ArrayList<>();
        for(int i = 0; i < n;i++){
            if(!sus[i]) res.add(i);
        }
        return res;
    }
}

