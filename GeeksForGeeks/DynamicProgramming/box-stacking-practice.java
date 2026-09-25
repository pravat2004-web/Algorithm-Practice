class Solution {
    static class Box {
        int h, w, l;

        Box(int h, int w, int l) {
            this.h = h;
            this.w = w;
            this.l = l;
        }
    }

    public int maxHeight(int[] height, int[] width, int[] length) {
        int n = height.length;

        // 3 rotations for every box
        Box[] boxes = new Box[3 * n];

        int index = 0;

        for (int i = 0; i < n; i++) {

            // height = height[i]
            boxes[index++] = new Box(
                height[i],
                Math.max(width[i], length[i]),
                Math.min(width[i], length[i])
            );

            // height = width[i]
            boxes[index++] = new Box(
                width[i],
                Math.max(height[i], length[i]),
                Math.min(height[i], length[i])
            );

            // height = length[i]
            boxes[index++] = new Box(
                length[i],
                Math.max(height[i], width[i]),