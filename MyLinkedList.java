public class MyLinkedList{
 private int size;
 private Node start,end;
 public MyLinkedList()
 {
   size = 0;
 }
 public int size()
 {
   return size;
 }
 public boolean add(String value)
 {
   Node insert = new Node(value);
   if (size == 0) {this.start = insert; this.end = insert; size ++; return true;}
   this.end.setNext(insert);
   insert.setPrev(end);
   this.end = insert;
   size ++;
   return true;
 }
 public boolean add(int index, String value)
 {
   Node insert = new Node(value);
   if (index < 0 || index > size) {throw new IndexOutOfBoundsException();}
   if (size == 0) {this.start = insert; this.end = insert; size ++; return true;}
   if (index == 0)
   {
     insert.setNext(this.start);
     this.start.setPrev(insert);
     this.start = insert;
     size ++;
     return true;
   }
   else if (index == size)
   {

     this.end.setNext(insert);
     insert.setPrev(end);
     this.end = insert;
     size ++;
     return true;
   }
   else
   {
     Node front = nodeAt(index);
     Node back = nodeAt(index + 1);
     front.setNext(insert);
     insert.setNext(back);
     insert.setPrev(front);
     back.setPrev(insert);
     size ++;
     return true;
   }
 }
 private Node nodeAt(int index)
 {
   Node curr = this.start;
   for (int i = 0; i < index - 1; i ++ ) {
     curr = curr.getNext();
   }
   return curr;
 }
 public String get(int index)
 {
   if (index < 0 || index > size) {throw new IndexOutOfBoundsException();}
   if (size == 0) {throw new IndexOutOfBoundsException();}
   return this.nodeAt(index).getData();
 }
 public String set(int index, String value)
 {
   Node target = this.nodeAt(index);
   String out = target.getData();
   target.setValue(value);
   return out;
 }
 public String toString()
 {
   if (size == 0) {return "[]";}
   String out = "[" + this.start.getData();
   Node curr = this.start;
   for (int i = 0; i < size - 1 ; i ++) {
     curr = curr.getNext();
     out += ", " + curr.getData();
   }
   return out + "]";
 }
 public String toStringReversed()
 {
   if (size == 0) {return "[]";}
   String out = "[" + this.end.getData();
   Node curr = this.end;
   for (int i = size - 1; i > 0 ; i --) {
     curr = curr.getPrev();
     out += ", " + curr.getData();
   }
   return out + "]";
 }
 public String remove(int index)
 {
   Node out = nodeAt(index);
   if (index < 0 || index > size) {throw new IndexOutOfBoundsException();}
   if (size == 0) {throw new IndexOutOfBoundsException();}
   if (size == 1) { start = new Node(null); end = start ; size --; return out.getData();}
   if (index == 0)
   {
     this.start = nodeAt(1);
     size --;
     return out.getData();
   }
   else if (index == size)
   {
     this.end = nodeAt(size - 1);
     size --;
     return out.getData();
   }
   else
   {
     Node overlapfront = nodeAt(index - 1);
     Node overlapback = nodeAt(index + 1);
     overlapfront.setNext(overlapback);
     overlapback.setPrev(overlapfront);
     size --;
     return out.getData();
   }

 }
 public void extend(MyLinkedList other)
 {
   this.end.setNext(other.start);
   other.start.setPrev(this.end);
   this.end = other.end;
   this.size += other.size;
 }
}
