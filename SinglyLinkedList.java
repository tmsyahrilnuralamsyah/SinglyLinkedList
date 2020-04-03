public class SinglyLinkedList<I> {
    protected NodeSingly<I> first;
    protected NodeSingly<I> last;
    public int size;

    // Constructor
    public SinglyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    // Method untuk mengecek apakah linked list kosong atau tidak
    public boolean isEmpty() {
        return first == null;
    }

    // Method untuk mengembalikan ukuran linked list sekarang 
    public int getSize() {
        return size;
    }

    // Method untuk memasukkan node di awal linked list 
    public void insertAwal(I val) {         
        NodeSingly<I> nptr = new NodeSingly<I>(val, null);                 
        if(first == null) {             
            first = nptr;            
            last = first;         
        } else {             
            nptr.setLink(first);             
            first = nptr;         
        }         
        size++;     
    }

    // Method untuk memasukkan node di akhir linked list 
    public void insertAkhir(I val) {         
        NodeSingly<I> nptr = new NodeSingly<I>(val, null);                        
        if(first == null) {             
            first = nptr;             
            last = first;         
        } else  {             
            last.setLink(nptr);           
            last = nptr;         
        }         
        size++;     
    }    

    // Method untuk memasukkan node di posisi tertentu 
    public void insertAtPos(I val , int pos) {         
        NodeSingly<I> nptr = new NodeSingly<I>(val, null);            
        if (pos > size)
            System.out.println("Posisi melebihi batas linked list");         
        else if (pos == 1)            
            insertAwal(val);         
        else if (pos == size)             
            insertAkhir(val);         
        else {            
            NodeSingly<I> ptr = first;
            pos -= 1;             
            for (int i = 1; i < size; i++) {                 
                if (i == pos) {                    
                    NodeSingly<I> tmp = ptr.getLink();                    
                    ptr.setLink(nptr);                    
                    nptr.setLink(tmp);                     
                    break;                
                }                 
                ptr = ptr.getLink();                        
            }             
            size++ ;        
        }   
    } 
    
    // Method untuk menghapus node di awal linked list 
    public void deleteAwal() {         
        first = first.getLink();
        size--;
    } 

    // Method untuk menghapus node di akhir linked list 
    public void deleteAkhir() {
        NodeSingly<I> temp = first;
        for (int i = 1; i < size-1; i++) {
            temp = temp.getLink();
        }
        last = temp;
        last.setLink(null);
        size--;
    }

    // Method untuk menghapus node pada posisi tertentu 
    public void deleteAtPos(int pos) {         
        if(pos > size)             
            System.out.println("Posisi node melebihi ukuran");         
        else if(pos == 1)             
            this.deleteAwal();         
        else if(pos == size)             
            this.deleteAkhir();         
        else {             
            NodeSingly<I> ptr = first.getLink();  
            pos--;           
            for(int i=2; i<=pos; i++) {                 
                if(i == pos) {                     
                    NodeSingly<I> temp = ptr.getLink(); 
                    temp = temp.getLink();
                    ptr.setLink(temp);                    
                    break;    
                }                
                ptr = ptr.getLink();           
            }        
            size--;
        }    
    }         

    // Method untuk menampilkan semua unsur dalam linked list 
    public void display() {
        NodeSingly<I> ptr = first;
        while (true) {
            if (ptr == null ) {
                break;
            }
            System.out.print(ptr.getData() +" -> ");
            ptr = ptr.getLink();
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLinkedList<String> sll = new SinglyLinkedList<>();
        sll.insertAwal("a");
        sll.insertAwal("b");
        sll.insertAkhir("c");
        sll.insertAtPos("d", 2);
        sll.insertAtPos("e", 1);
        sll.display();
        sll.deleteAwal();
        sll.deleteAkhir();
        sll.deleteAtPos(2);
        sll.display();
    }
}