package 八皇后;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author miao
 *   首先八皇后问题：八个皇后放在8X8的棋盘上，使每个皇后所在的行列以及交叉线中不能出现第二个皇后，问有几种放法
 *   分析：
 *   1、棋盘中的每一行和每一列只能出现一个皇后
 *   2、假设第一行第一列放一个皇后，那么第二皇后的位置从第二行第0列开始，每一列开始判断直到满足条件
 *   3、使用回溯法将每一行的位置都判断过来，并且将元素加入到List集合中，之后要清空集合中的元素，第一个皇后的位置变成了第一行的第二列
 *   4、以此类推，直到第一个皇后放到第一行最后一个位置为止、
 */
public class exerciseQueen {
     public static final int SIZE = 8; //8个皇后
     private static int count = 0; //记录摆放的方式
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       LinkedList<Location> list = new LinkedList<Location>();
		 eightQueen(list,0,0);
     
	}
	//获取当前的位置
    static class Location{
    	private int row; //记录行
    	private int colum; //记录列
    	Location(int row,int colum){
    		this.row = row;
    		this.colum = colum;
    	}
    	public String toString(){
			return "("+row+","+colum+")";
    		
    	}
    }
   public static void eightQueen(LinkedList<Location> list,int row,int colum){
	   if(list.size() == SIZE){
		   printList(list);
		   return ;
	   }
	   
			  for(int i=colum;i<SIZE;i++){
				  Location location = new Location(row,i);
			   if(judgeLocation(list,location)){
				   list.offer(location);
				   eightQueen(list,row+1,0);
				   list.removeLast();
				}
		   }
		 }
	   
  
   //判断位置是否合法
private static boolean judgeLocation(LinkedList<Location> list,Location location) {
	// TODO Auto-generated method stub
	for(Location currentLocation: list){
		if(currentLocation.row==location.row || currentLocation.colum == location.colum){
			//判断是否在同一行
			return false;
		}
		else if(Math.abs(currentLocation.row-location.row)==
			Math.abs(currentLocation.colum-location.colum))
			{return false;}
		
	}
	return true;
}
private static void printList(LinkedList<Location> list) {
	// TODO Auto-generated method stub
	for(Location result: list){
		System.out.print(result.toString()+"\t");
		
	}
	System.out.println(count);
	count++;
}
    
}
