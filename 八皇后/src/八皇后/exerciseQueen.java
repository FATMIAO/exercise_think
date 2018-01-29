package �˻ʺ�;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author miao
 *   ���Ȱ˻ʺ����⣺�˸��ʺ����8X8�������ϣ�ʹÿ���ʺ����ڵ������Լ��������в��ܳ��ֵڶ����ʺ����м��ַŷ�
 *   ������
 *   1�������е�ÿһ�к�ÿһ��ֻ�ܳ���һ���ʺ�
 *   2�������һ�е�һ�з�һ���ʺ���ô�ڶ��ʺ��λ�ôӵڶ��е�0�п�ʼ��ÿһ�п�ʼ�ж�ֱ����������
 *   3��ʹ�û��ݷ���ÿһ�е�λ�ö��жϹ��������ҽ�Ԫ�ؼ��뵽List�����У�֮��Ҫ��ռ����е�Ԫ�أ���һ���ʺ��λ�ñ���˵�һ�еĵڶ���
 *   4���Դ����ƣ�ֱ����һ���ʺ�ŵ���һ�����һ��λ��Ϊֹ��
 */
public class exerciseQueen {
     public static final int SIZE = 8; //8���ʺ�
     private static int count = 0; //��¼�ڷŵķ�ʽ
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       LinkedList<Location> list = new LinkedList<Location>();
		 eightQueen(list,0,0);
     
	}
	//��ȡ��ǰ��λ��
    static class Location{
    	private int row; //��¼��
    	private int colum; //��¼��
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
	   
  
   //�ж�λ���Ƿ�Ϸ�
private static boolean judgeLocation(LinkedList<Location> list,Location location) {
	// TODO Auto-generated method stub
	for(Location currentLocation: list){
		if(currentLocation.row==location.row || currentLocation.colum == location.colum){
			//�ж��Ƿ���ͬһ��
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
