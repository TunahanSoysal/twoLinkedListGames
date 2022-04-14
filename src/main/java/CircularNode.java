/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author soysa
 */
public class CircularNode {
    public String data;
    public CircularNode next;
    public CircularNode previous;
    
    public CircularNode(String data){
    this.data = data;
    next = null;
    previous = null;
    }
    
}