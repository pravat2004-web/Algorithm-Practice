
        // Build adjacency list
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] dep : dependencies) {
            int u = dep[0], v = dep[1];
            graph.get(u).add(v);
            indegree[v]++;
        }

        // Queue for modules with no dependencies
        Queue<Integer> q = new LinkedList<>();
        int[] finishTime = new int[n];

        // Initialize with modules that can start immediately
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                finishTime[i] = duration[i];
            }
        }

        int visited = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            visited++;
            for (int v : graph.get(u)) {
                // Update finish time for dependent module
                finishTime[v] = Math.max(finishTime[v], finishTime[u] + duration[v]);
                indegree[v]--;
                if (indegree[v] == 0) q.add(v);
            }
        }

        // If not all modules were processed → cycle exists
        if (visited != n) return -1;

        // Minimum project completion time = max finish time
        int ans = 0;
        for (int time : finishTime) ans = Math.max(ans, time);