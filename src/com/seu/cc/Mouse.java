package com.seu.cc;

import java.util.Stack;

public class Mouse {

    private int startI, startJ;  // 入口    
    private int endI, endJ;  // 出口   
    private boolean success = false;   
      
    private Stack<String> stack = new Stack<String>();
    public static void main(String[] args){   
    	//迷宫   2表示墙 0表示可走
        int[][] maze = {{2, 2, 2, 2, 2, 2, 2},    
                        {2, 0, 0, 0, 0, 0, 2},    
                        {2, 0, 2, 2, 2, 0, 2},    
                        {2, 0, 0, 2, 0, 2, 2},    
                        {2, 2, 0, 2, 0, 2, 2},    
                        {2, 0, 0, 0, 0, 0, 2},    
                        {2, 2, 2, 2, 2, 2, 2}};   
       
        System.out.println("显示迷宫：");    
        for(int i = 0; i < maze.length; i++){    
            for(int j = 0; j < maze[0].length; j++){
                if(maze[i][j] == 2){
                    System.out.print("██"); 
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();    
        }   
 
        Mouse mouse = new Mouse();   
        mouse.setStart(1, 1);   
        mouse.setEnd(5, 5);   
        
        if(!mouse.go(maze)){   
            System.out.println("\n没有找到出口！");   
        }   
        else{   //打印出选择的路线
            System.out.println("\n找到出口！");   
            for(int i = 0; i < maze.length; i++){    
                for(int j = 0; j < maze[0].length; j++){    
                   if(maze[i][j] == 2){
                       System.out.print("██");  
                   }
                    else if(maze[i][j] == 1){
                        System.out.print(".."); 
                    }  
                    else{
                        System.out.print("  ");  
                    }
                 }    
                 System.out.println();    
            }               
       }   
        System.out.println(mouse.stack);
   }   
           
    public void setStart(int i, int j){   
        this.startI = i;   
        this.startJ = j;   
    }   
       
    public void setEnd(int i, int j){   
        this.endI = i;   
        this.endJ = j;   
    }   
       
    public boolean go(int[][] maze){   
        return visit(maze, startI, startJ);   
    }   
     //核心算法  递归  
    private boolean visit(int[][] maze, int i, int j){   
    	//该点已走过，设置为1 
        maze[i][j] = 1;    
        stack.push("i:"+i+" j:"+j);
        if(i == endI && j == endJ){  //到达结尾 返回成功
            success = true;  
        }
       //第一选择向右边走（右边如果已经走过 不再继续走 下同）
        if(!success && maze[i][j+1] == 0){
            visit(maze, i, j+1);   
        }
        //第二选择向下走
        if(!success && maze[i+1][j] == 0){
         	visit(maze, i+1, j); 
        }
        //第三选择向左走
        if(!success && maze[i][j-1] == 0){
        	visit(maze, i, j-1);  
        }
       //第四选择向右边走
       if(!success && maze[i-1][j] == 0){
           visit(maze, i-1, j);  
       }
  
       if(!success) {//无路可走  将该点重新标志为0
           maze[i][j] = 0; 
           stack.pop();
       }  
        return success;    
   }   


}