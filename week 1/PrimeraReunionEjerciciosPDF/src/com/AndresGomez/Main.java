package com.AndresGomez;

public class Main {
    private int[] wall = new int[] {3,4,2,4,2};
    public static void main(String[] args) {
        Main ej1 = new Main();

        System.out.println("Blocks in the wall");
        System.out.println(ej1.blocksAmount());

        int blockAmount = ej1.blocksAmount();
        int avg = ej1.getAvg(blockAmount);
        System.out.println("average of blocks");
        System.out.println(avg);

        System.out.println(ej1.wallSize(avg));

        System.out.println("Blocks missing to complete the wall");
        System.out.println(ej1.blocksAmountM(ej1.maxWall()));
    }

    public int blocksAmount() {
        int blockAmount = 0;
        for (int i = 0; i < wall.length; i++){
            blockAmount += wall[i];
        }
        return blockAmount;
    }
    public int maxWall(){
        int maxWall=0;
        for (int i = 0; i < wall.length; i++){
            if(maxWall <= wall[i]){
                maxWall=wall[i];
            }
        }
        return maxWall;
    }
    public int blocksAmountM(int maxWall){

        int blocksAmountM = 0; //counter blocks missing in the wall

        for (int i = 0; i < wall.length; i++){
            if(maxWall > wall[i]){
            blocksAmountM += maxWall-wall[i];
            }
        }
        return blocksAmountM;
    }
    public int getAvg(int blockAmount) {
        return blockAmount / wall.length;
    }

    public int wallSize(int blockAvg) {
        int blocksToMove = 0;
        for (int i = 0 ; i < wall.length; i++) {
            if (wall[i] > blockAvg) {
                blocksToMove = blocksToMove + (wall[i] - blockAvg);
            }
        }
        return blocksToMove;
    }
}
