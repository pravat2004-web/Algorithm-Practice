            b = a % b;
            a = temp;
        }
        return a;
    }

    // Build segment tree
    private void buildTree(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = start + (end - start) / 2;
        buildTree(arr, 2 * node, start, mid);
        buildTree(arr, 2 * node + 1, mid + 1, end);
        tree[node] = gcd(tree[2 * node], tree[2 * node + 1]);
    }

    // Point update: arr[idx] = val
    private void updateTree(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = val;
            return;
        }
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            updateTree(2 * node, start, mid, idx, val);
        } else {
            updateTree(2 * node + 1, mid + 1, end, idx, val);
        }
        tree[node] = gcd(tree[2 * node], tree[2 * node + 1]);
    }

    // Range GCD query [l, r]
    private int queryTree(int node, int start, int end, int l, int r) {
        // Range out of bounds
        if (r < start || end < l) {
            return 0; // gcd(x, 0) = x
        }