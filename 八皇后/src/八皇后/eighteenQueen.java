package 八皇后;

import java.util.LinkedList;

public class eighteenQueen {
	
	
	private static final int SIZE = 8;  //皇后的个数，此处设为8，表示8个皇后

    private static int count = 0;  //记录摆放的方式数

    public static void main(String[] args) {

        LinkedList<Location> list = new LinkedList<Location>();

        eightQueen(list, 0, 0);  //从棋盘的第0行第0列开始

        System.out.println("八皇后共有 " + count + "种摆放方式");

    }

    /**
     * 定义位置的数列结构，用于表示皇后的摆放位置
     */
    static class Location {
        int x ;  //对应棋盘的列
        int y ;  //对应棋盘的行

        Location(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    /**
     * 主要函数，用回溯法。
     */
    private static void eightQueen(LinkedList<Location> list, int x, int y) {   

        if(list.size() == SIZE){  //当list元素个数为8时，表示8个皇后都摆放完毕，打印后即可退出函数。
            printLocation(list);  //打印皇后摆放方式
            return ;
        }

        for(int i = x ; i < SIZE ; i++){
            Location loc = new Location(i, y);
            if(isLegalLoc(list, loc)){
                list.offer(loc);  //将第y行的皇后摆放好
                eightQueen(list, 0, y+1);  //开始摆放y+1行的皇后，同样从第0列开始摆放
                list.pollLast();  //每次摆放完一个皇后后，都要将其撤回，再试探其它的摆法。
            }                   
        }           
    }

    /**
     * 判断位置为loc的皇后是否合法
     */
    private static boolean isLegalLoc(LinkedList<Location> list, Location loc) {
        for(Location each : list){
            if(loc.x == each.x || loc.y == each.y)  //判断是否在同一行或同一列
                return false;
            else if (Math.abs(loc.x - each.x) == Math.abs(loc.y - each.y))  //判断是否在同一对角线或反对角线上
                return false;
        }
        return true;
    }

    /**
     * 打印皇后摆放方式
     * @param list
     */
    private static void printLocation(LinkedList<Location> list) {
        for(Location each : list){
            System.out.print(each.toString() + "\t");
        }
        System.out.println();
        count ++;
    }
}
