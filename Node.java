public class Node{
  private String data;
  private Node next,prev;
  public Node(String value)
  {
    data = value;
  }
 public String getData()
 {
   return data;
 }
 public Node getNext()
 {
   return next;
 }
 public Node getPrev()
 {
   return prev;
 }
 public String setValue(String value)
 {
   String temp = data;
   data = value;
   return temp;
 }
 public void setPrev(Node newn)
 {
   prev = newn;

 }
 public void setNext(Node newn)
 {
   next = newn;

 }
}
