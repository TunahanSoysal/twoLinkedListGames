
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;




/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author soysa
 */
public class LooseLetterGame {
    public CircularNode current;
    static int size=0;
    
    public LooseLetterGame(){
    current = null;
    }
    
    public void insertAfterCurrent(String s) {
        CircularNode circNode = new CircularNode(s);
        if (current == null) {
            current = circNode;
            current.next = current;
            current.previous = current;
        } else {
            circNode.previous = current;
            circNode.next = current.next;
            current.next.previous = circNode;
            current.next = circNode;
        }
        size++;
    }
    @Override
    public String toString() {

        CircularNode temp = current;
        String s = "";
        while (temp != current.previous) {
            s += temp.data + "->";
            temp = temp.next;
        }
        s += temp.data;

        return s;
    }
    
    public static String randomName() throws Exception {
        int n = (int) ((Math.random() * 120));
        
        return Files.readAllLines(Paths.get("C:\\Users\\soysa\\Documents\\NetBeansProjects\\Project1\\src\\main\\java\\class.txt")).get(n-1);        


    }
    
    public CircularNode search(String value){
    CircularNode temp = current;
    while(temp !=null){
        if(temp.data.equals(value)){
        return temp;
        }
        temp=temp.next;
        }
     
    return null;
    }
    
    public CircularNode GetNth(int index)
    {
        CircularNode a = current;
        int count = 0; /* index of Node we are
                          currently looking at */
        while (a != null)
        {
            if (count == index)
                return a;
            count++;
            
            a = a.next;
        }
        
 
        /* if we get to this line, the caller was asking
        for a non-existent element so we assert fail */
        assert (false);
        System.out.println(count);
        return null;
    }
    
    public static void main(String[] args) throws Exception {

        LooseLetterGame cl = new LooseLetterGame();
        
        Scanner scn = new Scanner(System.in);
        System.out.println("please enter the number of people");
        int n = scn.nextInt();
       
        for(int i = 1;i<n;i++){
        
            cl.insertAfterCurrent(randomName());
            
            
        }
         
        boolean b = true;
        System.out.println(cl);
        
        
        while(b){
            
            
        int x = (int)(Math.random()*n);
        
        
        cl.GetNth(x).data=cl.GetNth(x).data.substring(1) ;
            
            
        System.out.println(x);
            
        
        System.out.println(cl);
        
        if(!"".equals(cl.GetNth(x).data)){
            
        
        }else if("".equals(cl.GetNth(x).data)){
            System.out.println((x+1)+"th name won");
        b = false;
        }
            
        
    }   
}
   
}

